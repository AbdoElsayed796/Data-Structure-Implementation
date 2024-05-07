public class Pair <K,V> {
    private final K first ;
    private final V second ;
    public Pair ( K first , V second)
    {
        this.first=first;
        this.second=second;
    }
    public K get_first(){
        return this.first ;
    }
    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
