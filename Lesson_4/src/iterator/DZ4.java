package iterator;

import linkedlist.LinkedList;
import linkedlist.SimpleLinkedListImpl;

public class DZ4 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new SimpleLinkedListImpl<>();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        displayAll(list);


        ListIterator<Integer> iterator = (ListIterator<Integer>) list.iterator();
        iterator.reset();
        iterator.insertAfter(11);
        iterator.next();
        iterator.remove();
        iterator.insertBefore(0);

        displayAll(list);

        iterator = (ListIterator<Integer>) list.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            displayAll(list);
        }

    }

    private static void displayAll(LinkedList<Integer> list) {
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}