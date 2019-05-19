package com.ptl;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private Integer[][] graph;
    private Boolean visited[];
    private Integer size;
    private Double density;

    public Graph(Integer size, Double density, Boolean withCycles){
        this.size = size;
        this.density = density;
        this.graph = new Integer[size][size];
        this.visited = new Boolean[size];

        Arrays.fill(visited, false);
        for(int i = 0; i < size; i++) Arrays.fill(graph[i], 0);

        if(withCycles) createWithCycles();
        else createWithoutCycles();
    }

    public String name(){
        return "Adjacency Matrix";
    }

    private void createWithCycles(){
        Integer maxVertex = (int)Math.floor(size * (size - 1) * density) - 1;
        Integer vertexesCount = size * 2;

        for(int i = 1; i < size; i++){
            graph[i - 1][i] = 1;
            graph[i][i - 1] = 1;
        }
        graph[0][size - 1] = 1;
        graph[size - 1][0] = 1;

        while(vertexesCount < maxVertex){
            int v1 = (int)Math.floor(Math.random() * size);
            int v2 = (int)Math.floor(Math.random() * size);
            int v3 = (int)Math.floor(Math.random() * size);

            graph[v1][v2] += 1;
            graph[v2][v1] += 1;

            graph[v2][v3] += 1;
            graph[v3][v2] += 1;

            graph[v1][v3] += 1;
            graph[v3][v1] += 1;

            vertexesCount += 3;
        }
    }

    private void createWithoutCycles(){
        createWithCycles();
        for(int i = 0; i < size; i++){
            graph[i][0] = 0;
            graph[0][i] = 0;
        }

        graph[0][1] = 1;
        graph[1][0] = 1;
    }

    private void removeVerticies(Integer v1, Integer v2){
        graph[v1][v2] -= 1;
        graph[v2][v1] -= 1;
    }

    private ArrayList<Integer> connectionsOf(Integer vertex){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < size; i++){
            if(graph[vertex][i] >= 1) result.add(i);
        }
        return result;
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.println(Arrays.asList(graph[i]));
        }
    }

    public ArrayList<Integer> eulerCycles(Integer vertex){
        Integer next = 0;
        ArrayList sorted = new ArrayList();

        while(next < size){
            if(graph[next][vertex] >= 1){
                removeVerticies(next, vertex);
                sorted.addAll(eulerCycles(next));
            }
            next++;
        }
        sorted.add(vertex);
        return sorted;
    }

    public ArrayList<Integer> hamiltonCycles(){
        ArrayList<Integer> unvisited = new ArrayList<>();
        for(int i = 0; i < size; i++) unvisited.add(i);

        return hamiltonCyclesSearch(0, new ArrayList<Integer>(), unvisited);
    }

    private ArrayList<Integer> hamiltonCyclesSearch(Integer vertex, ArrayList<Integer> path, ArrayList<Integer> unvisited){
        path.add(vertex);
        unvisited.remove(vertex);
        if(unvisited.size() == 0) return null;
        for(Integer next : connectionsOf(vertex)){
            if(unvisited.contains(next)){
                if(unvisited.size() == 1 && graph[0][next] >= 1){
                    path.add(next);
                    path.add(path.get(0));
                    return path;
                }
                else{
                    ArrayList<Integer> finalPath = hamiltonCyclesSearch(next, path, unvisited);
                    if(finalPath != null) return finalPath;
                }
            }
        }
        return null;
    }

}

