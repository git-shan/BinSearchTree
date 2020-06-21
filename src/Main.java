import java.util.Random;

public class Main {
    private static double testSet( Set<Integer>q, int opCount){
        return testSet(q,opCount,true);
    }
    private static double testSet( Set<Integer>q, int opCount, boolean debug){
        long startTime =System.nanoTime();
        Random random = new Random();
        int val =0;
        if(debug) {
            for (int i = 0; i < 10; i++) {
                q.add(i);
                System.out.println("Set :" + q);
            }
           q.remove(11);
            System.out.println("Set :" + q);

            for (int i = 0; i < 10; i++) {
                q.remove(i);
                System.out.println("Set :" + q);
            }
            q.remove(11);
        }
        if (debug) System.out.println("test start ->" + startTime/1000000000.0);
        for (int i = 0; i<opCount; i++ ) {
            val = random.nextInt(Integer.MAX_VALUE);
            q.add(val);

            val = random.nextInt(Integer.MAX_VALUE);
            q.remove(val);
//            if(debug && i%(opCount/100)==0)System.out.print(".");
        }
        long endTime =System.nanoTime();
//        q.reset();
        if(debug) System.out.println("\ntest ended ->" +endTime/1000000000.0);

        return (endTime - startTime) /1000000000.0;
    }
    public static void main(String[] args) {
	// write your code here
        BstSet<Integer> bset = new BstSet();
        LinkedListSet<Integer> lset = new LinkedListSet();

        int opCount = 10000;
        double time1, time2 = 0;
        time1 =  testSet(bset,opCount);
        System.out.println("BSTset time:" +time1 +"s");
        System.out.println(bset);
        System.out.println("Set :" +lset);

        time2 =  testSet(lset,opCount);
        System.out.println("LinkedListSet time:" +time2 +"s");
        System.out.println(lset);

        for (int i = opCount;i<1000*opCount; i+= 10*opCount){
            time1 =  testSet(bset,i,false);
            System.out.print(i+",");
            System.out.print(time1+"\n");
            //time2 =  testSet(lset,i,false);
            //System.out.print(time2+"\n");

        }

    }
}
