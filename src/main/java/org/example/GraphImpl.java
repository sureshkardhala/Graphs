package org.example;

import java.util.ArrayList;
import java.util.List;

public class GraphImpl {
    public static void addEdge(List<List<Integer>> graph, int u, int v){
        graph.get(u).add(v);
//        graph.get(v).add(u);
    }

    public static void printGraph(List<List<Integer>> graph){
        for (int i=0; i<graph.size(); i++){
            for (int j=0; j<graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v=5;
        List<List<Integer>> graph = new ArrayList<>(5);
        for (int i=0; i<v ; i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0,1);
        addEdge(graph, 0,2);
        addEdge(graph, 1,0);
        addEdge(graph, 1,2);
        addEdge(graph, 1,3);
        addEdge(graph, 2,0);
        addEdge(graph, 2,1);
        addEdge(graph, 3,1);
        printGraph(graph);
    }
}
