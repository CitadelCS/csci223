/*
Disable AI tools before starting homework.

This assignment is individual work. You may not use CoPilot, JetBrains AI,
or any other AI code generation tool to help you with this assignment.
You may ask for help from the instructor or TAs, but you must write the code yourself.

CWID:
Honor Code: I have neither given nor received unauthorized aid on this assignment,
and I have followed the academic honor code as specified in the syllabus.
Type your name -->

Instructions: Implement the missing methods. To test them, you can add a main function that
creates a LinkedList, adds some items, and calls the methods to see if they return the
expected results. You can also use the toString() method to print the list and visually verify its contents.

Hints: Study the given methods and draw diagrams for the ones you must write. Consider
corner cases as well, such as when the list is empty or has only one item. You may find it helpful to use
helper methods, such as getNode, to avoid repeating code.

If you prefer Python, a Python version of this starter code is available.
 */

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

    // here are the instance variables/data fields for the list
    private int size;
    private Node<Item> first;

    // no constructor because default is fine.

    // here are the instance methods for the class
    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Item> iter = this.iterator();
        while (iter.hasNext())
            sb.append(iter.next().toString() + "\n");
        return sb.toString();
    }

    // add to beginning
    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    // remove from beginning
    public Item remove() {
        Item doomed = null;
        if (!isEmpty()) {
            doomed = first.item;
            first = first.next;
            size--;
        }
        return doomed;
    }



    private Node<Item> getNode(Item item) {
        for (Node<Item> curr = first; curr != null; curr = curr.next) {
            if (curr.item.equals(item)) return curr;
        }
        return null;
    }

    //    Return the zero-based index of the node containing the given item. If no node contains the item, return -1.
    public int indexOf(Item item) {
        boolean found = false;
        int loc = 0;
        for (Node<Item> x = first; x != null; x = x.next, loc++) {
            if (x.item.equals(item)) {
                found = true;
                break;
            }
        }
        return found ? loc : -1;
    }


    //Return the item contained by the node immediately following the node containing the parameter item. Return null if this is not possible/available. Be careful with empty or short lists.
    public Item after(Item item) {
        // TODO: implement
        return null; //delete this
    }

    //    Return the item contained by the node immediately preceding the node containing the parameter item. Return null if this is not possible/available. Be careful with empty or short lists.
    public Item before(Item item) {
        //TODO: implement
        return null; //delete this
    }

    //    Create a new node containing the provided item and add it to the end of your LinkedList instead of the beginning (like the existing add method does). Be careful with empty or short lists.
    public void addLast(Item item) {
        if (size == 0) add(item);
        else {
            Node<Item> x = first;
            for (; x.next != null; x = x.next) {
            }
            x.next = new Node<Item>();
            x.next.item = item;
            size++;
        }
    }

    //Create a new node containing the provided item and add it to your LinkedList at the specified position. Be careful with empty or short lists. If the index is invalid, do not add (negative or beyond the end of the list). Assume zero-based indexing.
    public void addAt(int i, Item item) {
        // TODO: implement
    }


    //Remove the node immediately preceding the node containing the parameter item. Return the item contained in the deleted node, or instead, return null if the deletion is not possible.
    public Item removeBefore(Item item) {
        if (size < 2) return null;
        if (first.item.equals(item)) return null;
        Node<Item> prev = first;
        Node<Item> curr = first.next;
        if (curr.item.equals(item)) {
            first = curr;
            size--;
            return prev.item;
        }
        for (Node<Item> lead = curr.next; lead != null; prev = curr, curr = lead, lead = lead.next) {
            if (lead.item.equals(item)) {
                prev.next = lead;
                size--;
                return curr.item;
            }
        }
        return null;
    }

    // remove purged item, null if arg not found
    // no longer required spring 2023
    public Item removeAfter(Item item) {
        Node<Item> curr = getNode(item);
        if (curr == null || curr.next == null) return null;
        Item save = curr.next.item;
        curr.next = curr.next.next;
        size--;
        return save;
    }
    // ---

    // here's the method we must write to call ourselves Iterable
    // it's only job is to return an object that knows how to iterate over this
    // list.
    @Override
    public Iterator<Item> iterator() {
        return new FancyIterator<Item>(first);
    }

    // here come the inner classes used by the list.

    /*
     * we don't need to write a constructor -- the default one is fine. we don't
     * need getters/setters since it's a nested class. private means no other
     * class can use this Node type static means this inner class can only
     * access static members of the list class
     */
    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    /*
     * this class defines an iterator that knows how to traverse this
     * collection. an iterator is like an arrow you advance through a collection
     * one by one. in our case, our iterator knows that our data items are
     * trapped inside of our linked list nodes.
     */
    private static class FancyIterator<Item> implements Iterator<Item> {
        // the only instance variable is the reference to the next node to
        // process
        private Node<Item> nextNode;

        // the constructor needs a reference to the first node in the list to
        // set things up.
        public FancyIterator(Node<Item> startNode) {
            nextNode = startNode;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        // this method is careful to return the item, not the node itself.
        @Override
        public Item next() {
            Node<Item> save = nextNode;
            nextNode = nextNode.next;
            return save.item;
        }

    }
}
