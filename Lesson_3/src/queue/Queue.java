package queue;

import collection.ICollection;

public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();
    E peek();

}
