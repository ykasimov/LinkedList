package ass.kasimyur;

import java.util.*;

/**
 * Created by username on 2/21/17.
 */
public class LinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int counter;

    public LinkedList() {
        head = null;
        tail = null;
        counter = 0;
    }


    public LinkedList(E input) {
        head = new Node<E>(input, null, null);
        tail = head;
        counter = 1;

    }

    public static void main(String[] args) {

        java.util.LinkedList<Integer> t = new java.util.LinkedList<Integer>();


    }


    public static void main(String[] args) {
        java.util.LinkedList test = new java.util.LinkedList();
        List<String> t = new ArrayList<String>();
        test.addAll(t);
    }

    /**
     * Adds element to the beginning of the linked list.
     *
     * @param elem the element to be added to the linked list
     */
    public void append(E elem) {
        if (counter == 0) {
            head = new Node<E>(elem, null, null);
            tail = head;
            counter++;
            return;
        }
        Node<E> tmp = new Node<E>(elem, null, head);
        head.setPrev(tmp);
        head = tmp;
        counter++;

    }

    /**
     * Adds element to the beginning of the linked list.
     *
     * @param elem the element to be added to the linked list
     */
    public void prepend(E elem) {
        if (counter == 0) {
            tail = new Node<E>(elem, null, null);
            head = tail;
            counter++;
        }
        Node<E> tmp = new Node<E>(elem, tail, null);
        tail.setNext(tmp);
        tail = tmp;
        counter++;
    }

    /**
     * Removes the first element from the linked list.
     */
    public void removeFront() {
        Node<E> tmp = head.getNext();
        tmp.setPrev(null);
        head = tmp;
        counter--;
    }

    /**
     * Removes the last element from the linked list.
     */
    public void removeBack() {
        Node<E> tmp = tail.getPrev();
        tmp.setNext(null);
        tail = tmp;
        counter--;
    }


    /**
     * Adds elements from a list to the specified collection. Elements are added in the order they are
     * returned by the list's iterator
     *
     * @param output the collection to place elements into
     * @throws NullPointerException if the specified collection is null
     */
    public void takeAll(Collection<? super E> output) {
        if (output == null) {
            throw new NullPointerException("Provided collection is null");
        }
        Node<E> current = head;
        while (current != null) {
            output.add(current.getObject());
            current = current.getNext();
        }
    }

    /**
     * Appends elements to a list from the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param input the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public void appendAll(Collection<? extends E> input) {

        for (E elem : input) {
            this.append(elem);
        }
    }

    /**
     * Returns the size of the specified collection
     *
     * @param input the collection's size is returned
     * @throws NullPointerException if the specified collection is null
     */
    public int count(Collection<?> input) {
        return input.size();
    }


    public E getFirst() {
        return head.getObject();
    }

    /**
     * Returns a backward iterator through a list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    public Iterator<E> backwardIterator() {
        return new Iterator<E>() {
            Node<E> current = tail;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                if (counter == 0) {
                    throw new NoSuchElementException();
                }
                Node<E> tmp = current;
                current = current.getPrev();
                return tmp.getObject();
            }
        };
    }

    /**
     * Returns a forward iterator through a list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            Node<E> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                if (counter == 0) {
                    throw new NoSuchElementException();
                }
                Node<E> tmp = current;
                current = current.getNext();
                return tmp.getObject();
            }
        };
    }


    private class Node<T> {

        T object;
        Node<T> prev;
        Node<T> next;

        public Node(T object, Node<T> prev, Node<T> next) {
            this.object = object;
            this.prev = prev;
            this.next = next;
        }

        public T getObject() {
            return object;
        }


        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}


