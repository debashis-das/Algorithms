package deva.com.datastructure.graph;

import java.util.*;

/**
 * IDS : Iterative Deepening Search
 * IDDFS : Iterative Deepening Depth First Search
 */
public class Graph {


    public int vertices;
    public List<List<Node>> nodes;

    public Graph(int noOfVertices){
        this.vertices = noOfVertices;
        this.nodes = new ArrayList<>(vertices);
        for(int i=0;i<vertices;i++){
            this.nodes.add(new ArrayList<>());
        }
    }

    public void addEdge(int startNode, int endNode, int weight){
        nodes.get(startNode).add(new Node(endNode,weight));
        nodes.get(endNode).add(new Node(startNode,weight));
    }

    public void addDirectedEdge(int startNode, int endNode, int weight){
        nodes.get(startNode).add(new Node(endNode,weight));
    }

    public List<Integer> depthFirstSearch(){
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(visited[i]){
                continue;
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            while (!stack.isEmpty()){
                int current = stack.pop();
                for(Node temp : nodes.get(current)){
                    if(visited[temp.index])
                        continue;
                    stack.push(temp.index);
                }
                if(!visited[current]){
                    result.add(current);
                    visited[current] = true;
                }
            }
        }
        return result;
    }

    public List<Integer> breathFirstSearch(){
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(visited[i]){
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()){
                int current = queue.poll();
                for(Node temp : nodes.get(current)){
                    if(visited[temp.index])
                        continue;
                    queue.add(temp.index);
                }
                if(!visited[current]){
                    result.add(current);
                    visited[current] = true;
                }
            }
        }
        return result;
    }



    public static void main(String[] args){
        Graph graph = new Graph(7);
        graph.addEdge(0,1,10);
        graph.addEdge(0,2,20);
        graph.addEdge(0,4,30);
        graph.addEdge(1,3,40);
        graph.addEdge(1,5,50);
        graph.addEdge(2,6,60);
        graph.addEdge(5,4,70);
        List<Integer> result1 = graph.breathFirstSearch();
        System.out.println(result1);
        List<Integer> result2 = graph.depthFirstSearch();
        System.out.println(result2);
    }
    
}
