package example.client1;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.api.SwipeApi;
import io.swagger.client.model.SwipeDetails;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Multithreadingswipe implements Runnable {

    public Summaryresult summary;
    private int threadcount = 1000;

    public ArrayList<Record> getRecordarraylist() {
        return recordarraylist;
    }

    public void setRecordarraylist(ArrayList<Record> recordarraylist) {
        this.recordarraylist = recordarraylist;
    }

    public ArrayList<Record> recordarraylist;
    private int i;

    private  CountDownLatch latch;

    private static Random random = new Random();
    public void setResult(Summaryresult result){
        this.summary = result;
    }
//    private static final String BASE_PATH = "http://localhost:8080/lab2try2_war_exploded";
        private static final String BASE_PATH = "http://34.216.221.106:8080/lab2try2_war";

    public void run() {
//        System.out.println("run() called");
//            int threadruns = 1;
            while (threadcount > 0 ){
//                System.out.println(threadcount);
                one_swipe(latch);
            }
//        System.out.println("run() ending");
        latch.countDown();
//        System.out.println(i);
        }

    public Multithreadingswipe(CountDownLatch latch,int i) {
        this.i = i;
        Body_gen this_body = new Body_gen();
        this.latch = latch;
        this.recordarraylist = new ArrayList<Record>();

    }

    public void one_swipe(CountDownLatch latch){
        this.threadcount = this.threadcount-1;
//        System.out.println(this.threadcount);
        try {

            SwipeApi apiInstance = new SwipeApi();
            ApiClient newapi = new ApiClient();
            newapi.setBasePath(BASE_PATH);
            apiInstance.setApiClient(newapi);
            SwipeDetails new_body = create_body();
            String new_leftorright = create_leftorright();

            try {
                Record curRecord = new Record();
                curRecord.setStartOfThisRequest();
                curRecord.setRequestType("POST");
                ApiResponse<Void> res = apiInstance.swipeWithHttpInfo(new_body, new_leftorright);
                int retry = 5;
                int result = res.getStatusCode();
                curRecord.setEndOfThisRequest();
                curRecord.setLatencyOfThisRequest();
                curRecord.setResponseCode(""+result);
                while ((Integer.toString(result).startsWith("5") || Integer.toString(result).startsWith("4")) && (retry > 0)){
                    System.out.println("retrying");
                    retry = retry-1;
                    newapi.setBasePath(BASE_PATH);
                    apiInstance.setApiClient(newapi);
                    SwipeDetails new_body1 = create_body();
                    String new_leftorright1 = create_leftorright();
                    curRecord.setStartOfThisRequest();
                    ApiResponse<Void> res1 = apiInstance.swipeWithHttpInfo(new_body1, new_leftorright1);
                    result =res1.getStatusCode();
                    curRecord.setEndOfThisRequest();
                    curRecord.setLatencyOfThisRequest();
                    curRecord.setResponseCode(""+result);
                }
//                System.out.println(res.getStatusCode());
                if (result == 201 ){
                    summary.addSuccessful();
                }else{
                    summary.addunSuccessful();
                }

//                System.out.println(curRecord.createThisResult());
                this.recordarraylist.add(curRecord);
//                if (random.nextInt(10000) == 0){
//                    System.out.println(latch.getCount());
//                }

//                System.out.println(res.getStatusCode());

            } catch (ApiException e) {
//                e.printStackTrace();
                System.out.println("Exception is caught");
            }
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
    public static SwipeDetails create_body(){
        SwipeDetails body = new SwipeDetails(); // SwipeDetails | response details
        Body_gen new_gen = new Body_gen();
        new_gen.gen_wholebody();
        body.setComment(new_gen.getComment());
        body.setSwipee(new_gen.getSwipee());
        body.setSwiper(new_gen.getSwiper());
        return body;
    }

    public static String create_leftorright(){
        Random new_r = new Random();
        String leftorright;
        if (new_r.nextBoolean()) {
            leftorright = "left";
        } else {
            leftorright = "right";
        }
        return leftorright;
    }
}
