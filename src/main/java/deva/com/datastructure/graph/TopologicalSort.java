package deva.com.datastructure.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addDirectedEdge(0,1,10);
        graph.addDirectedEdge(0,2,20);
        graph.addDirectedEdge(0,4,30);
        graph.addDirectedEdge(1,3,40);
        graph.addDirectedEdge(1,5,50);
        graph.addDirectedEdge(2,6,60);
        graph.addDirectedEdge(5,4,70);
        TopologicalSort ts = new TopologicalSort();
        ts.topologicalSort2(graph.nodes,7);
        System.out.println();
        ts.topologicalSort1(graph.nodes,7);
    }

    private void topologicalSort1(List<List<Node>> nodes, int v) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                stack.push(i);
                while(!stack.isEmpty()){
                    int current = stack.pop();
                    if(!visited[current]){
                        visited[current] = true;
                        for(Node temp : nodes.get(current)){
                            if(!visited[temp.index]){
                                stack.push(temp.index);
                            }
                        }
                    }
                    result.push(current);
                }
            }
        }
        System.out.println();
        while(!result.isEmpty()){
            System.out.print(result.pop()+" ");
        }
    }

    void topologicalSort2(List<List<Node>> nodes, int v)
    {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++)
            visited[i] = false;

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < v; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack, nodes);

        // Print contents of stack
        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack, List<List<Node>> adj) {
        // Mark the current node as visited.
        visited[v] = true;
        Node i;

        // Recur for all the vertices adjacent
        // to thisvertex
        Iterator<Node> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i.index])
                topologicalSortUtil(i.index, visited, stack, adj);
        }

        // Push current vertex to stack
        // which stores result
        stack.push(new Integer(v));
    }
}
