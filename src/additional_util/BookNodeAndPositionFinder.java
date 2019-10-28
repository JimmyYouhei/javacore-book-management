package additional_util;

import entity.Book;
import exception.NoBookException;
import util.MyList;
import util.NodeAndPosition;

public interface BookNodeAndPositionFinder {

    public static NodeAndPosition<Book> findNode(int position, MyList thisList) throws IndexOutOfBoundsException, NoBookException {
        checkPositionInput(position , thisList);

        NodeAndPosition<Book> pointer = new NodeAndPosition<Book>(thisList.getHead(), 0);

        while (pointer.getPosition() != position){
            pointer.travelNextNode();
        }

        return pointer;
    }

    private static void checkPositionInput(int k , MyList thisList) throws IndexOutOfBoundsException, NoBookException {

        if (k < 0 || k > thisList.size()){
            throw new IndexOutOfBoundsException("no such position");
        }

        if (thisList.isEmpty()){
            throw new NoBookException("no book ");
        }

    }

}
