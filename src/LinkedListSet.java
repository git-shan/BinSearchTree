public class LinkedListSet <E extends Comparable<E>> implements Set<E> {
    private LinkedList list;

    public LinkedListSet() {
        list = new LinkedList();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void add(E e) {
        if (!contains(e))
            list.addFirst(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }
    @Override
    public void reset(){
        list = new LinkedList();
    }
    @Override
    public String toString(){
        return list.toString();
    }
}
