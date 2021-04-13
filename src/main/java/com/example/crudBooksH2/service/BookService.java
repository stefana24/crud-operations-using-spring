package com.example.crudBooksH2.service;

import com.example.crudBooksH2.model.Book;
import com.example.crudBooksH2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> books.add(book));
        return books;
    }

    public Book getBookById(Long id){
        Book book =  bookRepository.findById(id).get();
        return book;
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }


}
