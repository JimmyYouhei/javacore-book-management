package additional_util.ui;

import additional_util.process.AdvanceProcessChoice;
import exception.NoBookException;
import wrapper.BookList;

public interface AdvanceUI {

    public static void printAdvanceCommand(){
        System.out.println("7.Sort books");
        System.out.println("8.Save books to file");
        System.out.println("9.Load books from file");
    }

    public static void processChoice(BookList books , int choice) {
        switch (choice){
            case 7:
                AdvanceProcessChoice.choice7(books);
                UICommand.reRun(books);
                break;

            case  8:
                AdvanceProcessChoice.choice8(books);
                UICommand.reRun(books);
                break;

            case 9:
                AdvanceProcessChoice.choice9(books);
                try {
                    books.list();
                } catch (NoBookException ignored) {

                }
                UICommand.reRun(books);

        }
    }

    static void printSortMenu(){
        System.out.println("Sort Option below: ");
        System.out.println("1.Sort by Price");
        System.out.println("2.Sort by BCode");
    }

}
