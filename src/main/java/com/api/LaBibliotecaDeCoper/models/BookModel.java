package com.api.LaBibliotecaDeCoper.models;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String bookName;

    @Lob
    @Column(name = "photo", columnDefinition="MEDIUMBLOB")
    private byte[] photo;

    @Column
    private String description;

    @Column
    private String author;

    @Column
    private String category;

    @Lob
    @Column(name = "pdf", columnDefinition="MEDIUMBLOB")
    private byte[] pdf;


    public Long getId (){
        return id;
    }
    public void setId ( Long id){
        this.id = id;
    }

    public String getBookName (){
        return bookName;
    }
    public void setBookName ( String bookName){
        this.bookName = bookName;
    }

    public byte[] getPhoto() {
        return photo;
    }
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getDescription (){
        return description;
    }
    public void setDescription ( String description){
        this.description = description;
    }

    public String getAuthor (){
        return author;
    }
    public void setAuthor ( String author){
        this.author = author;
    }

    public String getCategory (){
        return category;
    }
    public void setCategory ( String category){
        this.category = category;
    }

    public byte[] getPdf() {
        return pdf;
    }
    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }
}