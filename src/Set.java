public interface Set <E extends Comparable <E>>  {
    void add(E e);
    void remove(E e);
    void reset();
    int getSize();
    boolean isEmpty();
    boolean contains(E e);

}
