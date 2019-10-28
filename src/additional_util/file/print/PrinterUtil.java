package additional_util.file.print;

import exception.NoBookException;
import wrapper.BookList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public interface PrinterUtil {

    public static void printBooks(File file , BookList books) throws IOException {

        PrintWriter printWriter = getPrintWriter(file);

        printWriter.println(String.format("%-10s%-20s%-10s%-10s%-10s%-10s", "Code","Title",
                "Quantity" , "Lender" , "Price" , "Value"));

        for (int i = 0 ; i < books.getBooks().size() ; i++){
            try {
                printWriter.println(books.getBooks().getNode(i).getInfo().toString());
            } catch (NoBookException ignored) {

            }
        }

        printWriter.close();

    }


    private static PrintWriter getPrintWriter(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        return new PrintWriter(fileWriter);
    }

}

