
public class Doubly_Linked_List <T> {
    private Node<T> Head = null ;
    private Node<T> Tail = null;
    private int Size = 0;
   private static class Node <T>{
        T data ;
        Node<T> Next,Prev ;
        Node(T data , Node<T> prev , Node<T> next)
        {
            this.data=data;
            this.Next=next;
            this.Prev=prev;
        }
    }
   public void clear ()
   {
       Node<T> trav = Head ;
       while(trav!=null)
       {
         Node <T> next = trav.Next;
         trav.Prev=trav.Next=null ;
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
           Head = Tail = new Node<>(elem, null, null);
       else {
           Tail.Next = new Node<>(elem,Tail, null);
           Tail = Tail.Next;
       }
       Size++;
   }
    public void addFirst(T elem) {
        if (isEmpty())
            Head = Tail = new Node<>(elem, null, null);
        else {
            Head.Prev = new Node<>(elem, null, Tail);
            Head = Head.Prev ;
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
      Node <T> INS = new Node<>(V,null,null);
      Node<T> cur = Head.Next;
      for(int count = 1; count<idx ;){
          count++;
          cur=cur.Next;
      }
       Node<T> temp =cur.Prev ;
       temp.Next=INS;
       INS.Prev=temp;
       INS.Next=cur;
       cur.Prev=INS;
    }
   public void insert(T V , int idx)
   {
     if(idx==0)addFirst((V));
     else if(idx==Size)addLast(V);
     else if(idx > 0 && idx < Size)addMiddle(V,idx);
     else{
         throw new ArrayIndexOutOfBoundsException("Not Valid Index");
     }

   }
  public void printF()
  {
      if(Size==0) System.out.println("List is Empty");
      else {
          Node<T> cur = Head;
          while (cur != null) {
              System.out.print(cur.data + " ");
              cur = cur.Next;
          }
          System.out.print("\n");
      }
  }
    public void printR()
    {
        if(Size==0) System.out.println("List is Empty");
        else {
            Node<T> cur = Tail;
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.Prev;
            }
        }
        System.out.print("\n");
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
  public void pop_back()
  {
      Tail = Tail.Prev ;
      Tail.Next =null;
      Size--;
  }
   public void pop_front()
   {
       Head = Head.Next ;
       Head.Prev=null ;
       Size-- ;
   }

    public void pop_middle(int idx)
    {
        Size--;
        int count = 1 ;
        Node<T> cur = Head.Next;
        for(;count<idx ;count++)
        {
          cur = cur.Next;
        }
        Node<T> P = cur.Prev;
        P.Next=cur.Next;
        cur.Next.Prev=P;
    }
    public void remove(int idx)
    {
      if(idx==0)pop_front();
      else if(idx==Size-1)pop_back();
      else if(idx>0 && idx<Size-1)pop_middle(idx);
      else
          throw new IndexOutOfBoundsException("Not Valid index");
    }
    public void revers()
    {
        Node<T> temp =Head;
        Head=Tail;
        Tail=temp ;
        Node<T> cur = Head.Prev;
        Head.Next=Head.Prev;
        while(cur!=null)
        {
            Node<T> P = cur.Prev;
            Node<T> N = cur.Next;
            cur.Next=P;
            cur.Prev=N;
            cur=P;
        }
    }



















}
