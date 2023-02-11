package client2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OverallRecoardProcessor {
    private FileWriter newCSV;
    public OverallRecoardProcessor(String filePath) throws IOException{
        newCSV = new FileWriter(filePath);
//        newCSV.append("Start Time");
        newCSV.append("Start Time, Request Type, Latency, Response Code\n");
//        System.out.println("Start Time, Request Type, Latency, Response Codde\n");
    }

    public void Plothelper(ArrayList<Integer> count) throws IOException{
        newCSV = new FileWriter("./plot.csv");
        for (int i = 0; i < count.size(); i++){
            newCSV.append(""+count.get(i)+"\n");
        }
    }

    public void addRecords(ArrayList<Record> record) throws IOException{
        int length = record.size();
//        System.out.println(length);
        for (int i = 0; i < length; i++){
            newCSV.append(record.get(i).createThisResult());
        }
    }

    public void finishwriting() throws IOException {
        newCSV.close();
    }
}
