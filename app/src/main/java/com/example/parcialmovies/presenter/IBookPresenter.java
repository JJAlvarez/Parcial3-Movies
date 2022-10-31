package com.example.parcialmovies.presenter;

import com.example.parcialmovies.bean.Book;

import java.util.List;

public interface IBookPresenter {

    void getBooks();
    void onBooksSuccess(List<Book> books);
    void onBooksError(String msg);
}
