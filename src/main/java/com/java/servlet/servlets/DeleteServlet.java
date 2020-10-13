package com.java.servlet.servlets;

import com.java.servlet.domain.Book;
import com.java.servlet.repository.BooksRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    public BooksRepository repository;

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        PrintWriter out = httpServletResponse.getWriter();
        String bookId = httpServletRequest.getParameter("id");
        System.out.println(bookId);
        repository.delete(bookId);
        out.print("<p>Record deleted successfully!</p>");
        out.println("<a href='index.html'>Add New Book</a>");
        out.println("<a href='ViewServlet'>View books</a>");
        out.close();
    }
}
