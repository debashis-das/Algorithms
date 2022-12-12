package deva.com.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph {

    int v;
    List<Edge> edges;

    public class Edge{
        public int src;
        public int dest;

        public Edge(int x, int y){
            this.src = x;
            this.dest = y;
        }
    }

    public UndirectedGraph(int v){
        this.v = v;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest){
        edges.add(new Edge(src,dest));
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(3,1);
        graph.addEdge(1,4);
        graph.addEdge(2,4);
//        graph.addEdge(3,2);
        System.out.println("Cycle exists : "+graph.isCyclic());
    }

    public boolean isCyclic(){
        int parent[] = new int[v];
        int rank[] = new int[v];
        for(int i=0;i<v;i++){
            parent[i] = i;
        }
        for(int i=0;i<edges.size();i++){
            int x = find(parent,edges.get(i).src);
            int y = find(parent,edges.get(i).dest);
            if(x==y){
                return true;
            }
            union(parent,rank,x,y);
        }
        return false;
    }

    private int find(int[] parent, int x){
        if(parent[x] == x)
            return x;
        return find(parent, parent[x]);
    }

    private void union(int[] parent, int[] rank, int x, int y){
        if(rank[x] >= rank[y]){
            parent[y] = x;
            ++rank[x];
        }else{
            parent[x] = y;
            ++rank[y];
        }
    }
}
