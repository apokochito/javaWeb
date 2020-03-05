package com.java.servlet;

import lombok.Data;

import java.util.UUID;

@Data
public class Book {

    private UUID id;
    private String title;
    private Float price;

}
