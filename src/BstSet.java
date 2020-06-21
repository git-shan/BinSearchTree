public class BstSet <E extends Comparable <E>> implements Set <E> {
    private BST bst;
    public BstSet (){
        bst = new BST(BST.traMode.FMID,false);
    }
    @Override
    public void reset(){
        bst = new BST(BST.traMode.FMID,false);
    }

    @Override
    public int getSize(){
//        return bst.sizeNC(); //size no count: count repeated elements 1 time
        return bst.getSize();
    }
    @Override
    public boolean contains(E e){
        return bst.contains(e);
    }
    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }
    @Override
    public void add(E e){
            bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.removeN(e);
    }
    @Override
    public String toString(){
        return bst.toString();
    }
}
