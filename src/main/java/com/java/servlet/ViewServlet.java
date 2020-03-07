package com.java.servlet;

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

        List<Book> books = repository.findAll();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Title</th><th>Price</th></tr> ");
        for (Book e : books) {
            out.print("<tr><td>" + e.getId() + "</td><td>" + e.getTitle() + "</td><td>" + e.getPrice() + "</td><td><a href = 'EditServlet?id="+e.getId()+"'>edit</a></td><td ><a href = 'DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
    }
}
