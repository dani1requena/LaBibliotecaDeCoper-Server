package com.api.LaBibliotecaDeCoper.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.LaBibliotecaDeCoper.models.*;
import com.api.LaBibliotecaDeCoper.repositories.IBookRepository;

@Service
public class BookService {

    @Autowired
    IBookRepository bookRepository;

    public ArrayList<BookModel> getBooks (){
        return (ArrayList<BookModel>) bookRepository.findAll();
    }

    public BookModel saveBook(BookModel book){
        return bookRepository.save(book);
    }

    public Optional<BookModel> getById(Long id){
        return bookRepository.findById(id);
    }

    public BookModel updateById(BookModel request, Long id){
        BookModel book = bookRepository.findById(id).get();
        
        book.setBookName(request.getBookName());
        book.setPhoto(request.getPhoto());
        book.setDescription(request.getDescription());
        book.setAuthor(request.getAuthor());
        book.setCategory(request.getCategory());

        return book;
    }

    public List<BookModel> getBooksByCategory (String category){
        return bookRepository.findAllByCategory(category);
    }

    public Boolean deleteBook(Long id){
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}