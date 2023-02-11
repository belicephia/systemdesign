package client2;

public class Record {

    private long startOfThisRequest;
    private long endOfThisRequest;
    private long latencyOfThisRequest;
    private String requestType;
    private String responseCode;
    public long getStartOfThisRequest() {

        return startOfThisRequest;
    }

    public void setStartOfThisRequest() {
        startOfThisRequest = System.currentTimeMillis();
        this.startOfThisRequest = startOfThisRequest;
    }

    public long getEndOfThisRequest() {

        return endOfThisRequest;
    }

    public void setEndOfThisRequest() {
        endOfThisRequest = System.currentTimeMillis();
        this.endOfThisRequest = endOfThisRequest;
    }

    public long getLatencyOfThisRequest() {

        return latencyOfThisRequest;
    }

    public void setLatencyOfThisRequest() {
        latencyOfThisRequest = this.endOfThisRequest - this.startOfThisRequest;
        this.latencyOfThisRequest = latencyOfThisRequest;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String createThisResult(){
        String result = startOfThisRequest + "," + requestType + "," + latencyOfThisRequest + "," + responseCode + "\n";
        return result;
    }



}
