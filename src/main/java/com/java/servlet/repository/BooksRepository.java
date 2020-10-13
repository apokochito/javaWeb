package com.java.servlet.repository;


import com.java.servlet.domain.Book;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooksRepository {

    public static Object getConnetion() {
        MongoDatabase db = null;
        try {
            MongoClientURI uri = new MongoClientURI("mongodb+srv://guest_admin:Pmm0nvnSZqoKXy8W@library-pnk2h.mongodb.net/test?retryWrites=true&w=majority");
            MongoClient mongoClient = new MongoClient(uri);
            db = mongoClient.getDatabase("library");
            return db.getCollection("faculty");
        } catch (Exception e) {
            System.err.println("Occurs an exception to get the connection to the database");
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public static void save(Book book) {
        try {
            MongoCollection<Document> collection = (MongoCollection<Document>) getConnetion();
            Document doc = new Document();
            doc.put("title", book.getTitle());
            doc.put("price", book.getPrice());
            collection.insertOne(doc);
        } catch (Exception e) {
            System.err.println("Occurs an exception to save this resource");
            System.out.println(e.getMessage());
        }
    }

    public static List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            MongoCollection<Document> collection = (MongoCollection<Document>) getConnetion();
            MongoCursor<Document> cursor = collection.find().cursor();
            int i = 0;
            while (cursor.hasNext()) {
                Document e = cursor.next();
                Book book = new Book();
                book.set_id(e.get("_id").toString());
                book.setTitle(e.get("title").toString());
                book.setPrice(e.get("price").toString());
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            System.err.println("Occurs an exception to get all the resources");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Book getBookById(String id) {
        try {
            MongoCollection<Document> collection = (MongoCollection<Document>) getConnetion();
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("_id", new ObjectId(id));
            FindIterable<Document> col = collection.find(whereQuery);
            Book book = new Book();
            book.set_id(col.first().get("_id").toString());
            book.setTitle(col.first().get("title").toString());
            book.setPrice(col.first().get("price").toString());
            return book;
        } catch (Exception e) {
            System.err.println("Occurs an exception to get the id of this resource");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void update(Book book, String newTitle, String newPrice) {
        try {
            MongoCollection<Document> collection = (MongoCollection<Document>) getConnetion();
            System.out.println(book.get_id() + book.getPrice() + book.getTitle());
            collection.updateOne(Filters.eq("_id", new ObjectId(book.get_id())), new Document("$set", new Document("price", newPrice)));
            collection.updateOne(Filters.eq("_id", new ObjectId(book.get_id())), new Document("$set", new Document("title", newTitle)));
        } catch (Exception e) {
            System.err.println("Occurs an exception to update this resource");
            System.err.println(e.getMessage() + "-" + e.toString() + "-" + Arrays.toString(e.getStackTrace()));
        }
    }

    public static void delete(String id) {
        try {
            MongoCollection<Document> collection = (MongoCollection<Document>) getConnetion();
            System.out.println(id);
            collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
        } catch (Exception e) {
            System.err.println("Occurs an exception to delete this resource");
            System.out.println(e.getMessage());
        }
    }
}