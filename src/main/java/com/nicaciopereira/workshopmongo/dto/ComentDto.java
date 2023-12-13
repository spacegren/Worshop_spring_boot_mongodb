package com.nicaciopereira.workshopmongo.dto;

import com.nicaciopereira.workshopmongo.domain.User;

import java.io.Serializable;
import java.util.Date;

public class ComentDto implements Serializable {
    private static long serialVersionUID = 1l;
    private String text;
    private Date date;
    private User author;


    public ComentDto(){

    }
    public ComentDto(String text , Date date , User author){
        super();
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
