package stack;


import collection.ICollection;

public interface Stack<E> extends ICollection {

    boolean push(E value);

    E pop();

    E peek();

}