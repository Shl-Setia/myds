package coursera.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyList {

    private int V;

    private List<Integer> adj[];

    public GraphAdjacencyList(int v) {
        V = v;
        adj = (ArrayList<Integer> []) new ArrayList[V]; // create empty graph with V vertices

        for(int i=0; i< V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int v1, int v2) {

        // undirected graph has two way link
        // v1 -> v2 and v2 -> v1
        adj[v1].add(v2);
        adj[v2].add(v1);
    }

    void addEdgeDiGraph(int v1, int v2) {

        // directed graph has one way link
        // v1 -> v2
        adj[v1].add(v2);
    }


    public List<Integer> getAdj(int v) {
        return adj[v]; // vertices adjacent to v
    }

    //  degree of v
    public static int degree(GraphAdjacencyList G, int v) {
        return G.adj[v].size();
    }

    public int V() {
        return V;
    }
}
