package com.example.mycollections.controllers;

import com.example.mycollections.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final List<Book> books = new ArrayList<>() {{
        add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180));
        add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281));
        add(new Book("1984", "George Orwell", 1949, 328));
    }};


    @Override
    public String toString() {
        return name + " by " + author;
    }

    @GetMapping("/json")
    public List<Book> getBooksJson() {
        return books;
    }

    @GetMapping("/html")
    public String getBooksHtml() {
        String bookList = "<ul>";
        for (Book book : books) {
            bookList += "<li>" + book + "</li>";
        }
        bookList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Books</h1>
                        <ul>
                """ +
                bookList + 
                """
                        </ul>
                    </body>
                """;
    }

}
