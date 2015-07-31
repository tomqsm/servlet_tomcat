package com.letsweb.tutorial.servlet_tomcat.servlets;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import javax.servlet.AsyncContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebListener;

@WebListener
public class Dispatcher implements ServletContextListener {

    private static final int PROCESSING_THREAD_COUNT = 3;
    private static final BlockingQueue<RemoteClient> REMOTE_CLIENTS = new LinkedBlockingQueue<RemoteClient>();
    private final Executor executor = Executors.newFixedThreadPool(PROCESSING_THREAD_COUNT);

    public static void addRemoteClient(RemoteClient remoteClient) {
        REMOTE_CLIENTS.add(remoteClient);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        int count = 0;
        while (count < PROCESSING_THREAD_COUNT) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                        RemoteClient remoteClient;
                        try {
              // fetch a remote client from the waiting queue
                            // (this call blocks until a client is available)
                            remoteClient = REMOTE_CLIENTS.take();
                        } catch (InterruptedException e1) {
                            throw new RuntimeException("Interrupted while waiting for remote clients");
                        }

                        AsyncContext asyncContext = remoteClient.getAsyncContext();
                        ServletResponse response = asyncContext.getResponse();
                        response.setContentType("text/plain");

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e1) {
                            throw new RuntimeException(e1);
                        }

                        // increment bytes sent by 10
                        remoteClient.incrementBytesSent();

                        try {
                            // send bytes to client
                            PrintWriter out = response.getWriter();
                            out.print("Already sent " + remoteClient.getBytesSent() + " bytes");
                            out.flush();

                            // check if we have already sent the 100 bytes to this client
                            if (remoteClient.getBytesSent() < 100) {
                                // if not, put the client again in the queue
                                REMOTE_CLIENTS.put(remoteClient);
                            } else {
                                // if the 100 bytes are sent, the response is complete
                                asyncContext.complete();
                            }

                        } catch (Exception e) {
                            // discard current client
                            asyncContext.complete();
                        }
                    }
                }
            });
            count++;
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

}
