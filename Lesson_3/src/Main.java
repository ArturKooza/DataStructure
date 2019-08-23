import deque.Deque;
import deque.DequeImpl;
import stack.Stack;
import stack.StackImpl;


public class Main {

    public static void main (String[] args){

//        String s = "Привет";

//        Stack<Character> st = new StackImpl<>(s.length());
//        for (int i = 0; i < s.length(); i++) {
//            st.push(s.charAt(i));
//        }

//        while (!st.isEmpty()) {
//            System.out.print(st.pop());
//        }
//        System.out.println();

//        if (true) {
//            return;
 //       }

        Deque<Integer> deq = new DequeImpl<>(6);

        deq.insertRight(1);
        deq.insertRight(2);
        deq.insertRight(3);
        deq.insertRight(4);
        deq.insertLeft(5);
        deq.insertLeft(6);

        displayLeftToRight(deq);
//        displayRightToLeft(deq);

    }
    private static <E> void displayLeftToRight(Deque<E> deq) {
        while (!deq.isEmpty()) {
            System.out.println(deq.removeLeft());
        }
    }
//        private static <E> void displayRightToLeft(Deque<E> deq) {
//            while (!deq.isEmpty()) {
//                System.out.println(deq.removeRight());
//            }
//    }
}



