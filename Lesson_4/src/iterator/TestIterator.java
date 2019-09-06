package iterator;


import linkedlist.SimpleLinkedListImpl;
import linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TestIterator {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        int index = 0;
        while (index < array.length) {
            int value = array[index++];
            doAction(value);
        }


        LinkedList<Integer> linkedList = createLinkedList();

        for (Integer o : linkedList) {
            doAction(o);
        }

        LinkedList.Node<Integer> current = linkedList.getFirst();
        while (current != null) {
            Integer value = current.value;
            doAction(value);
            current = current.next;
        }


        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);



        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            doAction(value);
        }

        List<Integer> jdkLinkedList = new java.util.LinkedList<>();
        jdkLinkedList.add(1);
        jdkLinkedList.add(2);
        jdkLinkedList.add(3);

        jdkLinkedList.removeIf(value -> value % 2 == 0);


        iterator = jdkLinkedList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value % 2 == 0) {
                iterator.remove();
            }

        }



        for (Integer value : arrayList) {
            doAction(value);
        }




    }

    private static LinkedList<Integer> createLinkedList() {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        return linkedList;
    }

    private static void doAction(int value) {
        System.out.println(value);
    }
}