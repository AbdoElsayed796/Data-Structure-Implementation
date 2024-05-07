public class Linked_List <T>{
    private Node<T> Head= null ;
    private Node<T> Tail= null ;
    private int Size = 0;
   private static class Node<T>{
        T data ;
        Node Next ;
        Node(T data , Node<T> next)
        {
            this.data=data;
            this.Next=next;
        }
    }
    public void clear ()
    {
        Node<T> trav = Head ;
        while(trav!=null)
        {
            Node<T> next = trav.Next;
            trav.Next=null ;
            trav.data = null ;
            trav = next ;
        }
        Head=Tail=null ;
        Size = 0 ;
    }
    public int len(){return Size;}
    public boolean isEmpty(){
        return len()==0;
    }
    public void addLast(T elem) {
        if (isEmpty())
            Head = Tail = new Node<>(elem, null);
        else {
            Tail.Next = new Node<>(elem, null);
            Tail= Tail.Next;
        }
        Size++;
    }
    public void addFirst(T elem) {
        if (isEmpty())
            Head = Tail = new Node<>(elem, null);
        else {
             Head = new Node<>(elem, Head);
        }
        Size++;
    }
    public T get_head()
    {
        if(isEmpty())throw new RuntimeException("List is Empty");
        else
            return Head.data;
    }
    public T get_tail()
    {
        if(isEmpty())throw new RuntimeException("List is Empty");
        else
            return Tail.data;
    }
    public void addMiddle(T V, int idx)
    {
        Size++;
        Node<T> INS = new Node<>(V,null);
        Node<T> cur = Head.Next;
        Node<T> temp = Head;

        for(int count = 1; count<idx ;){
            count++;
            cur=cur.Next;
            temp = temp.Next;
        }
        temp.Next=INS;
        INS.Next=cur;
    }
    public void insert(T V , int idx)
    {
        if(idx==0)addFirst((V));
        else if(idx==Size-1)addLast(V);
        else if(idx > 0 && idx < Size-1)addMiddle(V,idx);
        else
            throw new ArrayIndexOutOfBoundsException("Not Valid Index");
    }
    public void print() {
        if (Size == 0) System.out.println("List is Empty");
        else {
            Node<T> cur = Head;
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.Next;
            }
        }
        System.out.println();
    }
    public String toString() {
        if (Size == 0)
            return "List is Empty";
        else {
            StringBuilder stringBuilder = new StringBuilder("[");
            Node<T> cur = Head;
            while (cur != null) {
                stringBuilder.append(cur.data);
                if (cur.Next != null)
                    stringBuilder.append(", ");
                cur = cur.Next;
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public T get_val(int idx)
    {
        int count = 0 ;
        Node<T> cur = Head ;
        for(;count<idx; )
        {
            count++;
            cur=cur.Next;
        }
        return cur.data;
    }

    public int get_idx(T V)
    {
        int count = 0 ;
        Node<T> cur = Head ;
        for(;count<Size;count++,cur=cur.Next)
        {
            if(V== cur.data)
                return count;
        }
        return -1;
    }
   void pop_back()
   {
       Node<T> cur = Head ;
       while(cur.Next.Next!=null)
       {
           cur=cur.Next;
       }
   cur.Next=null;
       Tail=cur;
   }
   void pop_front()
   {
       Size--;
       Node<T> temp = Head.Next;
       Head=null;
       Head=temp;
   }
   public void pop_middle(int idx)
   {
       Size--;
       int count = 1 ;
       Node<T> cur = Head.Next;
       Node<T> P = Head;
       for(;count<idx ;count++)
       {
           cur = cur.Next;
       }
       P.Next=cur.Next;
   }
    public void remove(int idx) {
        if (idx == 0) pop_front();
        else if (idx == Size - 1) pop_back();
        else if (idx > 0 && idx < Size - 1) pop_middle(idx);
        else
            throw new IndexOutOfBoundsException("Not Valid index");
    }
    public void remove_val(T X)
    {
      Node cur = Head;
      int idx = 0;
      while(cur != null)
      {
          if(cur.data==X)
          {
              remove(idx);
          }
          cur =cur.Next ;
      }
    }
    public void interchange() {
        if (Head == null || Head.Next == null || Head.Next.Next == null) {
            return; // No need to perform interchange if there are 0, 1, or 2 nodes
        }

        // Initialize the current pointer to the head node
        Node<T> cur = Head;

        // Move the current pointer to the node before the tail
        while (cur.Next.Next != null) {
            cur = cur.Next;
        }

        // Save the tail node into a temporary variable
        Node<T> temp = cur.Next;

        // Set the next pointer of the current node to the head node
        cur.Next = Head;

        // Set the next pointer of the tail node to the second node from the head
        temp.Next = Head.Next;

        // Set the next pointer of the head node to null to make it the new tail
        Head.Next = null;
        Head = temp;
        Tail =cur.Next;

    }
    public void set(int index, T element)
    {
        if(index >= 0 && index <= Size)
        {
            Node<T> cur = Head ;
            int count = 0 ;
            while(count<index)
            {
                cur = cur.Next;
                count++;
            }
            cur.data=element;
        }
        else
            System.out.println("Error");
    }
    public Linked_List<T> sublist(int fromIndex, int toIndex) {
        Linked_List<T> L = new Linked_List<>();
        int count = 0;
        Node<T> cur = Head;

        // Traverse the list until reaching the starting index
        while (count < fromIndex && cur != null) {
            cur = cur.Next;
            count++;
        }

        // Add elements to the new list from starting index to ending index
        while (cur != null && count <= toIndex) {
            L.addLast(cur.data);
            cur = cur.Next;
            count++;
        }

        return L;
    }

}
