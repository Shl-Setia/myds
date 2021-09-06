package coursera.graph;

import java.util.Stack;

class DepthFirstPaths {

    private boolean[] visited;
    private int[] edgeTo;
    private int s; // source of start of path searching

    DepthFirstPaths(GraphAdjacencyList G, int source) {
        visited = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for(int i =0; i< edgeTo.length; i++) { // def value of int is 0.
            edgeTo[i] = -1;
        }
        s = source;
        dfsPath(G, source);
    }

    // DFS marks all vertices connected to source in time proportional to the sum of their degrees.
    private void dfsPath(GraphAdjacencyList G, int source) {
        visited[source] = true;

        for(int v : G.getAdj(source)) {
            if(!visited[v]) {
                edgeTo[v] = source;
                dfsPath(G, v);
            }
        }
    }


    public boolean hasPathTo(int v) { // from source

        return visited[v];
    }

    public void printPathTo(int v) { // from source

        if(!hasPathTo(v)) {
            return;
        }

        Stack<Integer> stack = new Stack<>();

        for(int x = v; x!= this.s; x= edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
