import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BSTmap<K extends Comparable<K>, V > implements Map<K,V> {
    private BSTiM<K,V> bstMap;
    public BSTmap(){
     bstMap = new BSTiM<>();
    }
   @Override
   public void add(K k, V v){
        bstMap.add(k,v);
   }
   @Override
   public V remove(K k){
        return bstMap.remove(k);
   }
   @Override
    public boolean contains(K key){
        return bstMap.contains(key);
   }
   @Override
    public int getSize(){
        return bstMap.getSize();
   }
   @Override
    public boolean isEmpty(){
        return bstMap.isEmpty();
   }
   @Override
    public boolean set(K k, V v){
        return bstMap.set(k,v);
   }

   @Override
   public V get(K k){
        return bstMap.get(k);
   }
   @Override
    public String toString(){
        return bstMap.toString();
   }
   @Override
   public void reset(){
       bstMap = new BSTiM<>();
   }


    private static double testMap( Map<Integer,Integer>q, int opCount, boolean debug){
        long startTime =System.nanoTime();
        Random random = new Random();
        int val =0;
        if(debug) {
            for (int i = 0; i < 10; i++) {
                q.add(i,i);
                System.out.println("Map :" + q);
            }
            System.out.println(q.remove(9));
            System.out.println("Map :" + q);

            for (int i = 0; i < 10; i++) {
                q.remove(i);
                System.out.println("Map :" + q);
            }
            q.remove(11);
        }
        if (debug) System.out.println("test start ->" + startTime/1000000000.0);
        for (int i = 0; i<opCount; i++ ) {
            val = random.nextInt(Integer.MAX_VALUE);
            q.add(val,i);

            val = random.nextInt(Integer.MAX_VALUE);
            q.remove(val%opCount);
//            if(debug && i%(opCount/100)==0)System.out.print(".");
        }
        long endTime =System.nanoTime();
        if(debug) System.out.println("\ntest ended ->" +endTime/1000000000.0);
        q.reset();

        return (endTime - startTime) /1000000000.0;
    }

    public static void main(String[] args) {
        // write your code here
        BSTmap<Integer, Integer> bmap = new BSTmap<>();

        int opCount = 10000;
        double time1, time2 = 0;
        time1 =  testMap(bmap,opCount,true);
        System.out.println("BSTmap time:" +time1 +"s");
//        System.out.println(bmap);

        for (int i = opCount;i<1000*opCount; i+= 10*opCount){
            time1 =  testMap(bmap,i,false);
            System.out.print(i+",");
            System.out.println(time1+",");
        }

    }
}
