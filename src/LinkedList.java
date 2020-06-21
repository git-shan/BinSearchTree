public class LinkedList<E>{
    private class Node{
        public E e;
        public Node next;
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){this(e,null);}
        public Node(){this(null,null);}
        @Override
        public String toString(){
            return e.toString();
        }

    }

//    private Node dummy head;
    private final Node dummyHead;
    int size;

    public LinkedList(){
        dummyHead = new Node (null,null);
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public void add (int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, index out of range");
        Node prev = dummyHead;
        for (int i =0;i <index;i++)
            prev = prev.next;
        prev.next = new Node(e,prev.next);
        size++;
        }
    public void addLast(E e){
        add(size, e);
    }
    public void addFirst (E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0,e);
    }
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed, index out of range");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }
    public E getFirst() {
        return get(0);
    }
    public E getLast() {
        return get(size-1);
    }
    public void set(int index,E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed, index out of range");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur !=null ){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }
    public void removeElement(E e) {
        Node cur;
        for (Node node = dummyHead; (node != null && node.next != null); node = node.next) {
            cur = node.next;
            if (cur.e.equals(e)) {
//        set prev.next to cur.next to skip cur. clear cur
                node.next = cur.next;
                size--;
                return; // remove once, if need to remove all, just delete this line
            }
        }
    }

    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed, index out of range");
        Node prev = dummyHead;
//        find prev node of index
        for (int i=0; i<index; i++)
            prev = prev.next;
//        store cur node
        Node cur = prev.next;
//        set prev.next to cur.next to skip cur. clear cur
        prev.next = cur.next;
        cur.next = null;

        size --;
        return cur.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");
        return res.toString();
    }
}
