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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

    private BooksRepository repository;

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        PrintWriter out = httpServletResponse.getWriter();
        out.println("<h1>Update Book</h1>");
        String bookId = httpServletRequest.getParameter("id");
        Book e = BooksRepository.getBookById(bookId);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td><input type='hidden' name='id' value='" + e.get_id() + "'/></td></tr>");
        out.print("<tr><td>Title:</td><td><input type='text' name='title' value='" + e.getTitle() + "'/></td></tr>");
        out.print("<tr><td>Price:</td><td><input type='text' name='price' value='" + e.getPrice() + "'/></td></tr >");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.println("<a href='index.html'>Add New Book</a>");

        out.close();
    }
}
