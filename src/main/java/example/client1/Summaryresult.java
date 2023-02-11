package example.client1;
import java.util.concurrent.atomic.AtomicInteger;

public class Summaryresult {
    private AtomicInteger successful = new AtomicInteger(0);

    public AtomicInteger getSuccessful() {
        return successful;
    }
    public void addSuccessful(){
        this.successful.getAndIncrement();
    }

    public void addunSuccessful(){
        this.unsuccessful.getAndIncrement();
    }

    public void setSuccessful(AtomicInteger successful) {
        this.successful = successful;
    }

    public AtomicInteger getUnsuccessful() {
        return unsuccessful;
    }

    public void setUnsuccessful(AtomicInteger unsuccessful) {
        this.unsuccessful = unsuccessful;
    }

    public long getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(Long totaltime) {
        this.totaltime = totaltime;
    }

    public long getTotalthroughput() {
        return totalthroughput;
    }

//    public void setthroughtput(){
//        this.totalthroughput = this.totaltime.intValue()/this.successful.get();
//    }

    public void setTotalthroughput(int totalthroughput) {
        this.totalthroughput = totalthroughput;
    }

    private AtomicInteger unsuccessful =  new AtomicInteger(0);
    private Long totaltime;
    private long totalthroughput;

    public void printout(){
        System.out.println(successful.get() + " successful requests sent\n");
        System.out.println(unsuccessful.get() + " unsuccessful requests sent\n");
        System.out.println(totaltime + " Millis was taken to process the data");
        this.totalthroughput = successful.get()*1000/totaltime;
        System.out.println(totalthroughput + " requests/second");
    }
}
