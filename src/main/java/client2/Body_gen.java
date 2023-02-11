package client2;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.google.gson.annotations.SerializedName;

public class Body_gen {
    private String swiper;

    private String swipee;

    private String comment;

    public void gen_wholebody(){
        this.swipee = genSwipee();
        this.swiper = genSwiper();
        this.comment = genComment();
    }


    public String genSwiper() {
        int swiperId = ThreadLocalRandom.current().nextInt(0,5001);

        return String.valueOf(swiperId);
    }

    public String genSwipee() {
        int swipeeId = ThreadLocalRandom.current().nextInt(0,1000001);

        return String.valueOf(swipeeId);
    }

    public String genComment(){
        String comment = createstring();
        return comment;
    }



    public String createstring() {
        byte[] array = new byte[256]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }


    public String getSwiper() {
        return swiper;
    }

    public void setSwiper(String swiper) {
        this.swiper = swiper;
    }

    public String getSwipee() {
        return swipee;
    }

    public void setSwipee(String swipee) {
        this.swipee = swipee;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }




}
