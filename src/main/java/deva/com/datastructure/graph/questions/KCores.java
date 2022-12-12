package deva.com.datastructure.graph.questions;

import deva.com.datastructure.graph.Graph;
import deva.com.datastructure.graph.Node;

public class KCores {

    static Graph graph;

    public static void main(String[] args){
        graph = new Graph(9);
        graph.addEdge(1,5,-1);
        graph.addEdge(1,2,-1);
        graph.addEdge(1,0,-1);
        graph.addEdge(0,2,-1);
        graph.addEdge(2,5,-1);
        graph.addEdge(5,8,-1);
        graph.addEdge(5,6,-1);
        graph.addEdge(6,8,-1);
        graph.addEdge(2,4,-1);
        graph.addEdge(2,3,-1);
        graph.addEdge(2,6,-1);
        graph.addEdge(4,6,-1);
        graph.addEdge(4,3,-1);
        graph.addEdge(3,7,-1);
        graph.addEdge(3,6,-1);
        graph.addEdge(6,7,-1);
        graph.addEdge(4,7,-1);
        KCores kCores = new KCores();
        kCores.fetchAllKCores(3);
    }

    public void fetchAllKCores(int k){
        int[] degree = new int[graph.vertices];
        boolean[] visited = new boolean[graph.vertices];
        for(int i=0;i< graph.vertices;i++){
            degree[i] = graph.nodes.get(i).size();
        }
        for(int i=0;i< graph.vertices;i++){
            if(!visited[i] && degree[i] < k)
                dfsUtil(i,visited, degree, k);
        }
        for(int i=0;i< graph.vertices;i++){
            if(degree[i] >= k) {
                System.out.printf("Head -> %d -> Connections : ", i);
                for (Node temp : graph.nodes.get(i)) {
                    if (degree[temp.index] >= k)
                        System.out.print(temp.index + " ");
                }
                System.out.println();
            }
        }
    }

    public void dfsUtil(int startNode, boolean[] visited, int[] degree,int k){
        if(visited[startNode])
            return;
        visited[startNode] = true;
        for(Node temp : graph.nodes.get(startNode)){
            --degree[temp.index];
            if(degree[temp.index] < k){
                dfsUtil(temp.index,visited,degree,k);
            }
        }
    }

}
