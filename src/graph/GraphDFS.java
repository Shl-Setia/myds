package graph;

import java.util.Stack;

public class GraphDFS {
    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,7);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(4,7);

        dfs(graph);


        System.out.println(graph);


    }

    static void dfs(Graph graph){
        Stack<Integer> stack = new Stack<>();
        graph.visited[0] = true;
        stack.push(0);

        while(!stack.empty()){
            // get adjacent vertex that is not visited
            int adjacentVertex = graph.getAdjacentVertex(stack.peek());
            if(adjacentVertex == -1){
                stack.pop(); // no edge or all edges visited, so backtrack
            }else {
                System.out.println(String.format("%d --> %d", stack.peek(), adjacentVertex));
                graph.visited[adjacentVertex] = true;
                stack.push(adjacentVertex);
            }


        }

    }




}
