package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Version3: Count no.of connected components in undirected graph
public class BFSImpl2 {
    public static void addEdge(int u, int v, List<List<Integer>> graph){
        graph.get(u).add(v);
        graph.get(v).add(u);

    }
    public static void print(List<List<Integer>> graph){
        for(List<Integer> list : graph){
            System.out.println(list);
        }
    }

    public static void BFS(int s, List<List<Integer>> graph, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s]=true;
        while (!queue.isEmpty()){
            int poll = queue.poll();
            System.out.print(poll+" ");
            for(int v : graph.get(poll)){
                if(!visited[v]){
                    visited[v]=true;
                    queue.add(v);
                }
            }
        }
    }

    public static void BFSDis(List<List<Integer>> graph){
        boolean [] visited = new boolean[graph.size()];
        int count=0;
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                BFS(i, graph, visited);
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>(7);
        for (int i=0; i<9; i++){
            graph.add(new ArrayList<>());
        }
        addEdge(0,1,graph);
        addEdge(0,2,graph);
        addEdge(1,2,graph);
        addEdge(3,4,graph);
        addEdge(5,6,graph);
        addEdge(5,7,graph);
        addEdge(7,8,graph);
//        print(graph);
        BFSDis(graph);


    }
}
