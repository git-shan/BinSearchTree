public class Array<E>{
    private E[] data;
    private int size;
//  construction function
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

//    no para
    public Array(){
        this (10);
    }

    public int getSize(){
        return size;
            }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E e){
        add(size,e);
//        if (size == data.length)
//            throw new IllegalArgumentException("AddLast failed, Array is fulled");
//        data[size] = e;
//        size++;
    }

// get data @ index
    E get(int index){
        if (index <0 ||index > size)
            throw new IllegalArgumentException("get failed, require index is in range");
    return data[index];
    }

//    set data @ index
    void set(int index, E e){
        if (index <0 ||index > size)
            throw new IllegalArgumentException("set failed, require index is in range");
        data [index] = e;
    }
    public void addFirst(E e){
        add(0,e);
    }
    public void add(int index, E e){

        if (index <0 ||index > size)
            throw new IllegalArgumentException("add failed, require index is in range");
        if (size == data.length)
            resize(2 * data.length);

        for (int i = size -1; i>= index; i--)
            data[i+1] =data[i];
        data[index]= e;
        size++;
    }
    public boolean contains(E e){
        for(int i = 0 ; i<size; i++){
            if(data[i].equals(e))
                return true;
                    }
        return false;
    }

    public int find(E e){
        for(int i = 0 ; i<size; i++){
            if(data[i] == e)
                return i;
        }
        return -1;
    }

    public E remove (int index){
        if (index <0 ||index > size)
            throw new IllegalArgumentException("remove failed, require index is in range");
        E ret = data[index];
        for(int i = index; i<size-1; i++){
            data [i] = data[i+1];
        }
        size--;
        data[size] = null; // loitering objects != memory leak
        if (size == data.length /4 && data.length/4 !=0) //lazy reduce capacity
            resize(data.length/4);
        return ret;
    }

    public E removeLast(){
        return remove(size-1);
    }

    public E removeFirst(){
        return remove(0);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index !=-1)
            remove(index);
    }
//    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d, capacity =%d\n", size, data.length));
        res.append('[');
        for(int i =0; i< size; i++){
            res.append(data[i]);
            if(i !=size-1 )
                res.append(",");
                  }
        res.append(']');
        return  res.toString();

    }
    private void resize (int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i=0;i<size; i++){
            newData[i] = data [i];
        }
        data = newData;
    }

}
