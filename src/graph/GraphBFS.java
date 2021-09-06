package graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    public static void main(String[] args) {
        Graph2 graph2 = new Graph2();
        graph2.buildGraph();

        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[graph2.V];


        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()){

            graph2.adjList[queue.peek()].stream().forEach(e -> {
                if(!visited[e]){
                    System.out.println(String.format("%d --> %d", queue.peek(), e));
                    visited[e] = true;
                    queue.add(e);
                }

            });

            queue.poll();
        }

    }
}
