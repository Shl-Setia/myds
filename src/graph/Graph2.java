package graph;

import java.util.LinkedList;

// This graph is represented using adjacent linked-list
public class Graph2 {
    int V = 8;
    LinkedList<Integer> adjList[];

    public void buildGraph(){
        adjList = new LinkedList[V];

        for (int i = 0; i < V; i++)
            adjList[i] = new LinkedList<Integer>();

        // Adding edges one by one
        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 7);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 2, 4);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 4, 6);
        addEdge(adjList, 4, 7);

        System.out.println(adjList);
    }

    void addEdge(LinkedList<Integer> adjList[],
                        int u, int v)
    {
        adjList[u].add(v);
        adjList[v].add(u);
    }

}
