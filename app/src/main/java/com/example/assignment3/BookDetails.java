package com.example.assignment3;

public class BookDetails {
    public String book_title;
    public String book_url;
    public String book_cover_url;
    public String book_level;
    public String book_description;


    public BookDetails(String bookTitle, String book_cover, String book_url, String book_level,String bookDesc ) {
        this.book_title = bookTitle;
        this.book_description = bookDesc;
        this.book_url = book_url;
        this.book_level = book_level;
        this.book_cover_url= book_cover;
    }
    public BookDetails() {
    }

}
