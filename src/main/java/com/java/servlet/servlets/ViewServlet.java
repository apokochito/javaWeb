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
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    private BooksRepository repository;

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter out = httpServletResponse.getWriter();
        out.println("<a href='index.html'>Add New Book</a>");
        out.println("<h1>Book List</h1>");

        List<Book> books = BooksRepository.findAll();

        out.println("<table border='1' width='100%'");
        out.println("<tr><th>Id</th><th>Title</th><th>Price</th></tr>");
        for (Book e : books) {
            out.println("<tr><td>" + e.get_id() + "</td><td>" + e.getTitle() + "</td><td>" + e.getPrice() + "</td><td><a href = 'EditServlet?id=" + e.get_id() + "'>edit</a></td><td><a href = 'DeleteServlet?id=" + e.get_id() + "'>delete</a></td></tr>");
        }
        out.println("</table>");

        out.close();
    }
}
