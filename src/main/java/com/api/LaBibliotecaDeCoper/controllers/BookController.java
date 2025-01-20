package com.api.LaBibliotecaDeCoper.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.api.LaBibliotecaDeCoper.models.BookModel;
import com.api.LaBibliotecaDeCoper.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ArrayList<BookModel> getBooks(){
        return this.bookService.getBooks();
    }

    @PostMapping
    public BookModel saveBook(@RequestParam("title") String title,
                              @RequestPart("photo") MultipartFile photo,
                              @RequestParam("description") String description,
                              @RequestParam("author") String author,
                              @RequestParam("category") String category,
                              @RequestPart("pdf") MultipartFile pdf) throws IOException{

        BookModel book = new BookModel();
        book.setBookName(title);
        book.setPhoto(photo.getBytes());
        book.setAuthor(author);
        book.setDescription(description);
        book.setCategory(category);
        book.setPdf(pdf.getBytes());

        return this.bookService.saveBook(book);
            
    }

    @GetMapping(path = "/{id}")
    public Optional<BookModel> getBook(@PathVariable("id") Long id){
        return this.bookService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public BookModel updateBookById(@RequestBody BookModel book, @PathVariable("id") Long id){
        return this.bookService.updateById(book, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteBookById(@PathVariable("id") Long id){
        boolean ok = this.bookService.deleteBook(id);

        if(ok){
            return "The user with id " + id + " is deleted";
        } else{
            return "ERROR";
        }
    }
    @GetMapping("/category/all/{category}")
    public ResponseEntity<List<BookModel>> getBooksByCategory (@PathVariable("category") String category){
        List<BookModel> books = bookService.getBooksByCategory(category);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si no hay libros
        }
        return ResponseEntity.ok(books);
    }
}