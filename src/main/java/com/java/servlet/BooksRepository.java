package com.java.servlet;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
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
            System.out.println(e);
            return e.getMessage();
        }
    }

    public static void save(Book book) {
        try {
            MongoCollection<Document> db = (MongoCollection<Document>) getConnetion();
            Document doc = new Document();
            doc.put(book.getTitle(),book.getPrice());
            db.insertOne(doc);
        } catch (Exception e) {
            System.err.println("Occurs an exception");
            System.out.println(e.getMessage());
        }
    }

    public static List<Book> findAll(){
        List<Book> books = new ArrayList<>();
        try{
            MongoCollection<Document> db = (MongoCollection<Document>) getConnetion();
            db.find();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return books;
    }

}
