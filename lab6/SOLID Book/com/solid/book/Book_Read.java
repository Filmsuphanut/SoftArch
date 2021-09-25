package com.solid.book;
import java.util.List;

public class Book_Read extends Book {

    public Book_Read(String title, List<String> pages) {
        super(title, pages);
    }

    public void printToScreen() {
        Book book = this;
        do {
            System.out.println(book.getCurrentPage());
        } while (book.turnToNextPage());
    }

}
