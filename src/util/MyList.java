/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import additional_util.BookUtil;
import additional_util.StringUtil;
import entity.Book;
import exception.DuplicationException;
import exception.InputNotProperlyException;
import exception.NoBookException;

import java.io.FileNotFoundException;

import static additional_util.BookNodeAndPositionFinder.findNode;
import static additional_util.BookUtil.bCodeAlreadyExist;

/**
 *
 * @author TrongDuyDao
 */
public class MyList {
    
    Node<Book> head, tail;

    //ctor
    public MyList() {
        head = tail = null;


    }
    //check if the list is empty or not
    public boolean isEmpty() {
        return head == null;
    }
    //add a new Book to the end of list
    public void addLast(Book b) throws InputNotProperlyException, DuplicationException {

        BookUtil.checkInputProperly(b);

        bCodeAlreadyExist(b , this);

        if(isEmpty()){
            addToFirst(b);
        } else {
            Node<Book> newTail = new Node<>(b , null);
            tail.setNext(newTail);
            tail = newTail;
        }
    }



    //add a new Book to the begining of list
    public void addFirst(Book b) throws DuplicationException, InputNotProperlyException {

        BookUtil.checkInputProperly(b);

        bCodeAlreadyExist(b , this);

        if(isEmpty()){
            addToFirst(b);
        } else{
            head = new Node<Book>(b , head);
        }
    }
    //output information of all books in the list
    public void traverse() throws NoBookException {

        if (isEmpty()){
            throw new NoBookException("There is no book");
        }


        Node<Book> pointer = head;

            while (pointer != tail){
                System.out.println(pointer.getInfo().toString());
                pointer = pointer.getNext();
            }

            System.out.println(tail.getInfo().toString());
    }
    //return number of nodes/elements in the list
    public int size() {

        if (isEmpty()){
            return 0;
        }

        NodeAndPosition<Book> pointer = new NodeAndPosition<Book>(head , 0);

        while (pointer.getNode() != tail){

            pointer.travelNextNode();

        }

        return pointer.getPosition() + 1;
    }
    //return a Node at position k, starting position is 0
    public Node<Book> getNode(int k) throws IndexOutOfBoundsException, NoBookException {

        NodeAndPosition<Book> pointer = findNode(k , this);

        return pointer.getNode();

    }
    //add a new book after a position k
    public void addAfter(Book b, int k) throws DuplicationException, NoBookException, InputNotProperlyException , IndexOutOfBoundsException {
        bCodeAlreadyExist(b , this);

        NodeAndPosition<Book> pointer = findNode(k , this);

        Node<Book> newNode = new Node<>(b , null);

        newNode.setNext(pointer.getNode().getNext());

        pointer.getNode().setNext(newNode);

    }
    //delete a book at position k
    public void deleteAt(int k) throws NoBookException , IndexOutOfBoundsException{

        NodeAndPosition<Book> pointerToNodeDelete = findNode(k , this);

        NodeAndPosition<Book> pointerToNodeBefore = findNode(k-1 , this);

        pointerToNodeBefore.getNode().setNext(pointerToNodeDelete.getNode().getNext());

        pointerToNodeDelete.getNode().setNext(null);
        pointerToNodeDelete.getNode().setInfo(null);

    }
    //search a Node by a given book code
    public Node<Book> search(String bCode) throws InputNotProperlyException, NoBookException, FileNotFoundException {

        if (isEmpty()){
            throw new NoBookException("no book loaded");
        }

        StringUtil.checkInputProperly(bCode);

        Node<Book> pointer = head;

        while (pointer != tail){

            if (pointer.getInfo().getbCode().equals(bCode)){
                return pointer;
            }

            pointer = pointer.getNext();
        }

        if (pointer.getInfo().getbCode().equals(bCode)){
            return pointer;
        } else {
            throw new FileNotFoundException("no book found");
        }

    }


    private void addToFirst(Book b) {
        Node<Book> firstNode = new Node<Book>(b, null);
        head = firstNode;
        tail = firstNode;
    }

    public Node<Book> getHead() {
        return head;
    }

    public void setHead(Node<Book> head) {
        this.head = head;
    }

    public Node<Book> getTail() {
        return tail;
    }

    public void setTail(Node<Book> tail) {
        this.tail = tail;
    }
}
