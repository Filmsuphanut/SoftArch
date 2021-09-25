package com.solid.book;


import java.util.List;

public class BookReader {
    public static void main(String[] args) {
        Book_Read my_book = new Book_Read("Tyland", List.of("I", "moved", "here", "recently", "too"));
        my_book.printToScreen();
    }
}
