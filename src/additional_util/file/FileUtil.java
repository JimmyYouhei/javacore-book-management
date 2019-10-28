package additional_util.file;

import additional_util.file.loader.FileLoader;
import additional_util.file.print.PrinterUtil;
import exception.BooksInMemoryException;
import exception.NoBookException;
import wrapper.BookList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public interface FileUtil {

    File newFile = new File("book.txt");

    public static void saveFile(BookList books) throws IOException, NoBookException , FileAlreadyExistsException {

        if (books.getBooks().size() == 0){
            throw new NoBookException("there is no book loaded to save");
        }


        if (newFile.exists() && newFile.length() >0){
            throw new FileAlreadyExistsException("file already exist, you want to override?");
        }


        PrinterUtil.printBooks(newFile , books);

    }

    public static void loadFile(BookList books) throws BooksInMemoryException, FileNotFoundException {

        if (books.getBooks().size() > 0){
            throw new BooksInMemoryException("there already books load are you sure?");
        }

        if (!newFile.exists() || newFile.length() == 0){
            throw new FileNotFoundException("there is nothing to load");
        }

        FileLoader.loadFile(books);

    }

    public static void confirmSave(BookList books) throws NoBookException, IOException {

        if (books.getBooks().size() == 0){
            throw new NoBookException("there is no book loaded to save");
        }

        PrinterUtil.printBooks(newFile , books);
    }

    public static void confirmLoad(BookList books) throws FileNotFoundException {

        if (!newFile.exists() || newFile.length() == 0){
            throw new FileNotFoundException("there is nothing to load");
        }

        FileLoader.loadFile(books);

    }

}
