public class Queue_L {
    private Node Head= null ;
    private Node Tail= null ;
    private int Size = 0;
    private static class Node {
        Object data ;
        Node Next ;
        Node(Object data ,Node next)
        {
            this.data=data;
            this.Next=next;
        }
    }
    public boolean isEmpty(){
        return Size==0;
    }
    public void enqueue(Object elem) {
        if (isEmpty())
            Head = Tail = new Node(elem, null);
        else {
            Head = new Node(elem, Head);
        }
        Size++;
    }
    Object dequeue()
    {
        Size--;
        Node cur = Head ;
        while(cur.Next.Next!=null)
        {
            cur=cur.Next;
        }
        Object temp = cur.Next.data;
        cur.Next=null;
        Tail=cur;
        return temp ;
    }
    int size()
    {return Size;}
}
