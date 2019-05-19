package com.ptl;

import com.ptl.measure.Timmer;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Graph graph = new Graph(5, 0.7, false);
        graph.print();
        System.out.println(graph.hamiltonCycles());

        /*
        Timmer.eulerCycles();
        Timmer.hamiltonCycles();
        Timmer.hamiltonCyclesWithoutCycles();

         */
    }
}
