public class Queue_A<T> {
    final private int Size;
    private int added = 0;
    private int front = 0;
    private int back = 0;
    final private T[] arr;

    Queue_A(int N) {
        if (N < 1)
            throw new IllegalArgumentException("Illegal Size " + N);
        else {
            Size = N;
            arr = (T[]) new Object[Size];
        }
    }

    public int size() {
        return Size;
    }

    public boolean isFull() {
        return added == Size;
    }

    public int currentsize() {
        return added;
    }

    public boolean isEmpty() {
        return added == 0;
    }

    void enqueue(T elem) {
        if (isFull())
            throw new IllegalStateException("Queue is full");
        arr[back] = elem;
        back = (back + 1) % Size;
        added++;
    }

    T dequeue() {
        if (added == 0)
            throw new RuntimeException("queue is Empty");
        else {
            T elem = arr[front];
            arr[front] = null;
            front = (front + 1) % Size;
            added--;
            return elem;

        }
    }

    T front() {
        if (added == 0)
            throw new RuntimeException("queue is Empty");
        return arr[front];
    }

    T back() {
        if (isEmpty())
            throw new RuntimeException("queue is Empty");
        int lastIndex = (back - 1 + Size) % Size;
        return arr[lastIndex];
    }
}
