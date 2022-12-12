package deva.com.datastructure.graph.questions;

import deva.com.datastructure.graph.Graph;
import deva.com.datastructure.graph.Node;

import java.util.List;

public class MotherVertex {

    List<List<Node>> nodes;
    int vertices;

    public MotherVertex(List<List<Node>> nodes, int vertices){
        this.nodes = nodes;
        this.vertices = vertices;
    }

    public static void main(String[] args){
        Graph graph = new Graph(7);
        graph.addDirectedEdge(0,1,10);
        graph.addDirectedEdge(0,2,20);
        graph.addDirectedEdge(1,3,40);
        graph.addDirectedEdge(1,4,50);
        graph.addDirectedEdge(5,2,60);
        graph.addDirectedEdge(5,6,70);
        graph.addDirectedEdge(6,4,70);
        graph.addDirectedEdge(6,0,70);
        MotherVertex mv = new MotherVertex(graph.nodes, graph.vertices);
        System.out.println(mv.motherVertex());
    }

    public int motherVertex(){
        int mv = -1;
        boolean[] visited = new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(!visited[i]) {
                depthFirstSearch(i, visited);
                mv = i;
            }
        }
        boolean[] checkVisited = new boolean[vertices];
        depthFirstSearch(mv,checkVisited);
        int count = 0;

        for(boolean temp : checkVisited)
            if(!temp) return -1;

        return mv;
    }

    public void depthFirstSearch(int startNode,boolean[] visited){
        if(visited[startNode])
            return;
        visited[startNode] = true;
        for(Node temp : nodes.get(startNode))
            if(!visited[temp.index])
                depthFirstSearch(temp.index,visited);
    }
}
