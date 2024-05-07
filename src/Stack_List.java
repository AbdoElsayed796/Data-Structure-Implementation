import java.util.EmptyStackException;

public class Stack_List<T> {
    private Node <T> Top ;
    private int Size ;
    private static class Node <T>{
         T Val ;
         Node <T> Next ;
         Node(T element)
         {
             this.Val=element;
         }
     }
     void push(T element) {
         Size++;
         if (Top == null) {
             Node <T>temp = new Node<>(element);
             Top =temp;
         }
         else {
             Node Temp = new Node<>(element);
             Temp.Next = Top;
             Top = Temp;
         }
     }
     T pop()
     {
         T Temp ;
         if(Top==null)
             throw new EmptyStackException() ;
         else {
             Temp = Top.Val ;
             Top = Top.Next;
             Size--;
         }
         return Temp ;
     }
     T top()
     {
         return Top.Val;
     }
     boolean isEmpty()
     {
         return Size==0 ;
     }
     int size()
     {
         return Size ;
     }

}
