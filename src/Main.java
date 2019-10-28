/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import additional_util.file.FileUtil;
import additional_util.file.loader.FileLoader;
import additional_util.ui.UICommand;
import entity.Book;
import exception.DuplicationException;
import exception.InputNotProperlyException;
import exception.NoBookException;
import wrapper.BookList;

import java.io.IOException;

/**
 *
 * @author TrongDuyDao
 */
public class Main {
    
    
     
    public static void main(String[] args) throws DuplicationException, InputNotProperlyException, NoBookException, IOException {

        BookList books = new BookList();
        System.out.println(books.getBooks().size());

        UICommand.runStart(books);




    }
}
