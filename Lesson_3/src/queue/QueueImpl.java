package queue;

public class QueueImpl<E> implements Queue<E> {

    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;

    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;

  public QueueImpl(int maxCapacity) {
      this.data =(E[]) new Object[maxCapacity];
      this.head = DEFAULT_HEAD;
      this.size = DEFAULT_TAIL;
  }




    public QueueImpl() {
        data = null;
    }

    @Override
    public boolean insert(E value) {
      if (isFull())
        return false;

      if (tail == data.length - 1){
          tail = DEFAULT_TAIL;
      }
      data[++tail] = value;
      size++;
      return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        if (head == data.length) {
            head = DEFAULT_HEAD;
        }
        E value = data[head++];
        size--;
        return value;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
