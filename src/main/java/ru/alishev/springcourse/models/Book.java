package ru.alishev.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {
    private int book_id;
    @NotEmpty(message = "Имя не может быть пустым")
    private String name;
    @NotEmpty(message = "Автор не может быть пустым")
    private String author;
    @Min(value = 0, message = "Год должен быть выше нуля")
    private int year;

    public Book(int book_id, String name, String author, int year) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Book() {}

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
