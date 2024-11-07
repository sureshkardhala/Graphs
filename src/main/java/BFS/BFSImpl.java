package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Version1 : Source and connected graph has given
public class BFSImpl {
    public static void addEdge(List<List<Integer>> graph, int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void printGraph(List<List<Integer>> graph){
        for (int i=0; i<graph.size(); i++){
            for (int j=0; j<graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void breadthFirstSearch(List<List<Integer>> graph, int initialNode){
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[graph.size()+1];
        visited[initialNode]=true;
        queue.add(initialNode);
        while (!queue.isEmpty()){
            int poll = queue.poll();
            System.out.print(poll + " ");
            for(int element : graph.get(poll)){
               if(visited[element]==false){
                   queue.add(element);
                   visited[element]=true;
               }

            }

        }
    }

    public static void main(String[] args) {
        int v=6;
        List<List<Integer>> graph = new ArrayList<>(5);
        for (int i=0; i<v ; i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0,1);
        addEdge(graph, 0,2);
        addEdge(graph, 0,5);
        addEdge(graph, 1,3);
        addEdge(graph, 2,4);
        addEdge(graph, 3,5);
        addEdge(graph, 4,5);

        printGraph(graph);
        System.out.println();
        System.out.println("BFS of Graph is : ");
        breadthFirstSearch(graph, 0);
    }
}
