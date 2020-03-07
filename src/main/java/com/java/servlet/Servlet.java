package com.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().print("Hello from servlet");
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        PrintWriter out = httpServletResponse.getWriter();

        String title = httpServletRequest.getParameter("title");
        String price = httpServletRequest.getParameter("price");

        Book book = new Book();
        book.setTitle(title);
        book.setPrice(price);

        BooksRepository.save(book);
        out.print("<p>Record saved successfully!</p>");
        // httpServletRequest.getRequestDispatcher("index.html").include(httpServletRequest, httpServletResponse);

        out.close();
    }

}
