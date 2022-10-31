package com.example.parcialmovies.presenter;

import com.example.parcialmovies.bean.Book;
import com.example.parcialmovies.model.BookModel;
import com.example.parcialmovies.model.IBookModel;
import com.example.parcialmovies.view.IBookView;

import java.util.List;

public class BookPresenter implements IBookPresenter {

    private IBookView view;
    private IBookModel model;

    public BookPresenter(IBookView view) {
        this.view = view;
        this.model = new BookModel(this);
    }

    @Override
    public void getBooks() {
        this.model.getBooks();
    }

    @Override
    public void onBooksSuccess(List<Book> books) {
        if (view == null)
            return;

        this.view.onBookSuccess(books);
    }

    @Override
    public void onBooksError(String msg) {
        if (view == null)
            return;

        this.view.onBookError(msg);
    }
}
