public class DArray <T> {
    private int Size;
    private T [] arr;
    private int Capacity;
    DArray(int N)
    {
      if(N < 1)
          throw new IllegalArgumentException("Illegal Size " + N);
      else
      {
          Capacity=Size=N ;
          arr = (T[]) new Object[Size];
      }
    }
    public int len(){return Size ;}
    public boolean isEmpty(){return (len()==0);}
    public T get(int idx){return arr[idx];}
    public void set(T val ,int idx){arr[idx]=val;}
    public void clear()
    {
      for(int i = 0 ; i < Size ; i++)
          arr[i]=null;
      Size=0;
    }
    public void add(T El)
    {
      if(Size>=Capacity)
      {if(Capacity==0)Capacity=1;
         else Capacity*=2;
          T []arr2 = (T[])new Object[Capacity];
          for(int i = 0 ; i < Size ; i++)
              arr2[i]=arr[i];
          arr=arr2 ;
      }
      arr[Size++]=El;
    }
    public T removeAt(int idx)
    {
      if(idx>=Size || idx < 0) throw new IndexOutOfBoundsException();
      T temp = arr[idx];
      for(int i = idx ; i < Size-1 ; i++)
          arr[i]=arr[i+1];
      Size--;
      return temp ;
    }
    public boolean remove(Object O)
    {
        for(int i = 0 ; i < Size ; i++)
        {
            if(arr[i].equals(O))
            {
                removeAt(i);
                return true ;
            }
        }
        return false;
    }
    public int idx(Object O)
    {
        for(int i = 0 ; i < Size ; i++)
        {
            if(arr[i].equals(O))
            {
               return i ;
            }
        }
        return -1 ;
    }
   public boolean contains(Object O)
   {
       return idx(O)!=-1 ? true : false ;
   }
   public String toSting()
  {
    if(Size==0)return "[]";
    else
    {
        StringBuilder S = new StringBuilder(Size);
        S.append("[");
        for(int i = 0 ; i < Size - 1 ; i++)
        {
            S.append(arr[i]+", ");
        }
        S.append(arr[Size-1]+"]");
        return S.toString() ;
    }
  }
  public void Print()
  {
      for(int i = 0 ; i < Size ; i++)
      {
          System.out.print(arr[i]+" ");
      }
  }

}
