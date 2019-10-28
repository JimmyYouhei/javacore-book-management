package wrapper;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entity.Book;
import exception.DuplicationException;
import exception.InputNotProperlyException;
import exception.NoBookException;
import util.MyList;

import java.io.FileNotFoundException;

/**
 *
 * @author TrongDuyDao
 */
public class BookList {

    //a list of book
    private MyList books;

    public void setBooks(MyList books) {
        this.books = books;
    }

    public MyList getBooks() {
        return books;
    }

    
    
    public BookList() {
        books = new MyList();
    }

    //1.0 accept information of a Book
    private Book getBook(String bCode) throws FileNotFoundException, InputNotProperlyException, NoBookException {
        return books.search(bCode).getInfo();
    }
    
    //1.1 accept and add a new Book to the end of book list
    public void addLast(Book bookToBeAdded) throws DuplicationException, InputNotProperlyException {

            books.addLast(bookToBeAdded);

    }

    //1.2 output information of book list
    public void list() throws NoBookException {

        books.traverse();

    }

    //1.3 search book by book code
    public Book search(String bCode) throws FileNotFoundException, InputNotProperlyException, NoBookException {

        return books.search(bCode).getInfo();
    }

    //1.4 accept and add a new Book to the begining of book list
    public void addFirst(Book bookToBeAdded) throws DuplicationException, InputNotProperlyException {

            books.addFirst(bookToBeAdded);

    }

    //1.5 Add a new Book after a position k
    public void addAfter(Book bookToBeAdded, int position) throws DuplicationException, NoBookException,
            InputNotProperlyException , IndexOutOfBoundsException {

            books.addAfter(bookToBeAdded , position);

    }

    //1.6 Delete a Book at position k
    public void deleteAt(int position) throws NoBookException , IndexOutOfBoundsException {

            books.deleteAt(position);

    }
}
