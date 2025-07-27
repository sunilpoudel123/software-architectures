package miu.edu.springmongodemo.domain;

import java.time.LocalDate;

public class Review {
    private int rating;
    private String comment;
    private String customer;
    private LocalDate date;

    public Review(int rating, String comment, String customer, LocalDate date) {
        this.rating = rating;
        this.comment = comment;
        this.customer = customer;
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}