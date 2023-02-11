package example.client1;
//import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Main {
    private static final String BASE_PATH = "http://localhost:8080/lab2try2_war_exploded";

    static long start;
    static long finish;
    static long timeElapsed;
    public static void main(String[] args) throws InterruptedException, IOException {
        Summaryresult overall = new Summaryresult();
//        int countdown = 500000;
//        int n = 500000;
        int n = 500;
        CountDownLatch latch =  new CountDownLatch(n);
//        OverallRecoardProcessor sum = new OverallRecoardProcessor("./output.csv");

        ExecutorService excutable = new ScheduledThreadPoolExecutor(200);
        start = System.currentTimeMillis();
        ArrayList<Multithreadingswipe> swipes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            swipes.add(new Multithreadingswipe(latch,i));
//            System.out.println(i);
            Multithreadingswipe a_thread = swipes.get(i);
            a_thread.setResult(overall);
            excutable.execute(a_thread);

        }
//        excutable.awaitTermination(10, TimeUnit.SECONDS);
        latch.await();
        finish = System.currentTimeMillis();

//        ArrayList<Integer> allLatency = new ArrayList<Integer>();
//        for (Multithreadingswipe a_thread : swipes)
//            sum.addRecords(a_thread.recordarraylist);
//
//        for (int i = 0; i < n; i++) {
//            int j = swipes.get(i).recordarraylist.size();
//            for (int a = 0; a < j; a++){
//                allLatency.add((int)swipes.get(i).recordarraylist.get(a).getLatencyOfThisRequest());
//            }
//        }
//        allLatency.sort(Comparator.naturalOrder());

        /**
         * client one result
         */

//        if (countdown == 0 ){

            timeElapsed = finish - start;
            overall.setTotaltime(timeElapsed);
//            sum.finishwriting();
//            overall.setthroughtput();
            overall.printout();
//        }
        /**
         * client two result
         */
//        int sumoflat = 0;
//        for (int k = 0; k < allLatency.size() ; k++){
////            System.out.println(allLatency.get(k));
//            sumoflat = sumoflat +allLatency.get(k);
//        }
//        int mean = sumoflat/allLatency.size();
//        System.out.println("The mean response time millisecs: " + mean);
//        System.out.println("The median response time millisecs: " + allLatency.get(allLatency.size()/2));
//        System.out.println("The throughput: " + overall.getTotalthroughput());
//        System.out.println("The P99 response time: " + allLatency.get(allLatency.size()-allLatency.size()/100));
//        System.out.println("The min response time: " + allLatency.get(0));
//        System.out.println("The max response time: " + allLatency.get(allLatency.size()-1));


    }

    }







