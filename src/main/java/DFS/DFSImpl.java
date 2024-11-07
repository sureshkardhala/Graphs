package DFS;

import java.util.ArrayList;
import java.util.List;

//DFS : Depth First Search ( First complete one adjacent vertex recursively, and it goes for next )
public class DFSImpl {
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

    public static void DFS(List<List<Integer>> graph, int s, boolean[] visited){
        if(visited[s]) return;
        System.out.print(s + " ");
        visited[s]=true;
        for(int v : graph.get(s)){
            DFS(graph, v, visited);
        }
    }

    public static void main(String[] args) {
        int v=7;
        List<List<Integer>> graph = new ArrayList<>(7);
        for (int i=0; i<v ; i++){
            graph.add(new ArrayList<>());
        }
        boolean [] visited = new boolean[v];
        addEdge(graph, 0,1);
        addEdge(graph, 0,2);
        addEdge(graph, 1,3);
        addEdge(graph, 1,4);
        addEdge(graph, 2,3);
        addEdge(graph, 4,5);

//        printGraph(graph);
        DFS(graph, 0, visited);

    }
}
