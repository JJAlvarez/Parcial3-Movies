package com.example.parcialmovies.view;

import com.example.parcialmovies.bean.Book;

import java.util.List;

public interface IBookView {

    void onBookSuccess(List<Book> books);
    void onBookError(String msg);
}
