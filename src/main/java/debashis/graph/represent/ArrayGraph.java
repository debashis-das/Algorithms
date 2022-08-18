package debashis.graph.represent;

// Java code to demonstrate Graph representation
// using ArrayList in Java

import java.util.*;

public class ArrayGraph {

    int noOfNodes;
    int[][] adj;

    public int[][] getAdj() {
        return adj;
    }

    public ArrayGraph(int noOfNodes) {
        this.noOfNodes = noOfNodes;
        this.adj = new int[noOfNodes][noOfNodes];
        for (int i = 0; i < noOfNodes; i++)
            adj[i] = new int[noOfNodes];
    }

    public void addEdge(int u, int v)
    {
        adj[u][v] = 1;
    }

    public void printGraph()
    {
        for (int i = 0; i < noOfNodes; i++) {
            for (int j = 0; j < noOfNodes; j++) {
                System.out.printf(" %s ",adj[i][j]);
            }
            System.out.println();
        }
    }
}

