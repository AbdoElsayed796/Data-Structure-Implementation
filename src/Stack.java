import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private int Capacity = 0 ;
    private int Size = 0 ;
    private T []arr;
    Stack()
    {
        Capacity=10;
       this.arr = (T[]) new Object[Capacity];
    }
    void resize()
    {
        Capacity*=2;
        T [] arr2 =(T[]) new Object[Capacity];
        for(int i = 0 ; i < Size ; i++)
        {arr2[i]=arr[i];}
        arr = arr2;
        arr2 = null;
    }
    int size(){return Size;}
    boolean isEmpty(){return Size==0;}
    T top()
    {
        if(!isEmpty()){
            return arr[Size-1];}
            else
                throw new EmptyStackException();
    }
    void push(T elem) {
        if (Capacity == Size) {
            resize();
        }
        Size++;
        arr[Size-1] = elem;

    }

    void pop()
    {
        arr[Size]=null;
        Size--;
    }
}
