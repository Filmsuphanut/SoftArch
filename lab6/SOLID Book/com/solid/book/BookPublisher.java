package com.solid.book;


import java.util.List;

public class BookPublisher {
    public static void main(String[] args) {
        Book_Print my_book = new Book_Print("Tyland", List.of("I", "moved", "here", "recently", "too"));
        my_book.printToFile();
    }
}
