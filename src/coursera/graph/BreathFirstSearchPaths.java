package coursera.graph;

import java.util.LinkedList;

public class BreathFirstSearchPaths {

    private boolean[] visited;
    private int[] edgeTo;

    public BreathFirstSearchPaths(GraphAdjacencyList G, int source) {
        visited = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for(int i =0; i< edgeTo.length; i++) { // def value of int is 0.
            edgeTo[i] = -1;
        }
    }

    public void bfs(GraphAdjacencyList G, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        if(G.V() == 0) {
            return;
        }

        queue.add(source);
        visited[source]= true;

        while (!queue.isEmpty()){

            int v = queue.getFirst();

            for(int w : G.getAdj(v)){
                if(!visited[w]){
                    visited[w] = true;
                    edgeTo[w]=v;
                    queue.add(w);
                }
            }

        }
    }
}
