package com.example.crudBooksH2.controller;

import com.example.crudBooksH2.model.Book;
import com.example.crudBooksH2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> allBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable(value="id") Long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/removeBook/{id}")
    public void remove(@PathVariable(value="id") Long id){
        bookService.deleteBook(id);
    }

    @PutMapping("/updateBook/{id}")
    public Book updated(@PathVariable(value = "id") Long id, @RequestBody Book changedBook){
        Book book = bookService.getBookById(id);
        book.setReview(changedBook.getReview());
        return bookService.saveBook(book);
    }
}
