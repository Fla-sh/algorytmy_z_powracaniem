package com.ptl.measure;

import com.ptl.Graph;
import org.apache.commons.lang3.time.StopWatch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Timmer {
    public static void eulerCycles(){
        Integer[] sizes = {1, 2, 3, 4};
        try {
            FileWriter fileWriter = new FileWriter("euler.csv", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Integer size : sizes){
                Graph graph = new Graph(size * 100, 0.3, true);

                StopWatch stopWatch = new StopWatch();
                System.out.println("Testing " + "euler cycles" +
                                " " + size * 100
                        );
                stopWatch.start();
                graph.eulerCycles(0);
                stopWatch.stop();
                System.out.println("time: " + stopWatch.getTime(TimeUnit.MILLISECONDS) + "\n\n");
                bufferedWriter.write(size * 100 + "," + stopWatch.getTime(TimeUnit.MILLISECONDS) + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void hamiltonCycles(){
        Integer[] sizes = {1, 2, 3, 4 ,5, 6, 7, 8, 9};
        try {
            FileWriter fileWriter = new FileWriter("hamilton.csv", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Integer size : sizes){
                Graph graph = new Graph(size * 100, 0.3, true);

                StopWatch stopWatch = new StopWatch();
                System.out.println("Testing " + "hamilton cycles" +
                        " " + size * 100
                );
                stopWatch.start();
                graph.hamiltonCycles();
                stopWatch.stop();
                System.out.println("time: " + stopWatch.getTime(TimeUnit.MILLISECONDS) + "\n\n");
                bufferedWriter.write(size * 100 + "," + stopWatch.getTime(TimeUnit.MILLISECONDS) + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void hamiltonCyclesWithoutCycles(){
        Integer[] sizes = {1, 2, 3, 4 ,5, 6, 7, 8, 9};
        try {
            FileWriter fileWriter = new FileWriter("hamiltonwo.csv", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Integer size : sizes){
                Graph graph = new Graph(size * 100, 0.3, false);

                StopWatch stopWatch = new StopWatch();
                System.out.println("Testing " + "hamilton /wo cycles" +
                        " " + size * 100
                );
                stopWatch.start();
                graph.hamiltonCycles();
                stopWatch.stop();
                System.out.println("time: " + stopWatch.getTime(TimeUnit.MILLISECONDS) + "\n\n");
                bufferedWriter.write(size * 100 + "," + stopWatch.getTime(TimeUnit.MILLISECONDS) + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
