package com.letsweb.tutorial.servlet_tomcat.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toks
 */
@WebServlet(name = "TestAsyncServlet", urlPatterns = {"/TestAsyncServlet"}, asyncSupported = true)
public class TestAsyncServlet extends HttpServlet {

    /** 
     http://www.byteslounge.com/tutorials/asynchronous-servlets-in-java
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final long startTime = System.nanoTime();
        final AsyncContext asyncContext = request.startAsync(request, response);
        new Thread() {

            @Override
            public void run() {
                try {
                    ServletResponse response = asyncContext.getResponse();
                    response.setContentType("text/plain");
                    PrintWriter out = response.getWriter();
                    Thread.sleep(2000);
                    out.print("Thread slept 2 sec. Work completed. Time elapsed: " + (System.nanoTime() - startTime));
                    out.flush();
                    asyncContext.complete();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
