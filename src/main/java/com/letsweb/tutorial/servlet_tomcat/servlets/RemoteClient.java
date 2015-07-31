package com.letsweb.tutorial.servlet_tomcat.servlets;

import javax.servlet.AsyncContext;

public class RemoteClient {

    private final AsyncContext asyncContext;
    private int bytesSent;

    public RemoteClient(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    public AsyncContext getAsyncContext() {
        return asyncContext;
    }

    public void incrementBytesSent() {
        this.bytesSent += 10;
    }

    public int getBytesSent() {
        return bytesSent;
    }

}
