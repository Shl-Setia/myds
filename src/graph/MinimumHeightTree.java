package graph;

import java.util.*;

public class MinimumHeightTree {
    public static void main(String[] args) {
        //https://leetcode.com/problems/minimum-height-trees/

        //https://www.geeksforgeeks.org/roots-tree-gives-minimum-height/

        // Traversal of graph(DFS) from any vertex will be a tree.

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        int v = 4;
        int e = 5;

        int [] degree = new int[v];


        for(int i =0; i< v; i++){
            graph.put(i, new ArrayList<>());
        }
        //addEdge(graph, 0, 3, degree);
        addEdge(graph, 1, 0, degree);
        addEdge(graph, 1, 2, degree);
        addEdge(graph, 1, 3, degree);
        //addEdge(graph, 5, 4, degree);


        Queue<Integer> queue = new LinkedList<>();
        boolean [] removed = new boolean[v];

        for(int i =0 ; i<v; i++){
            if(degree[i] == 1){ // leaf node
                queue.add(i);
            }
        }

        while(v > 2){
            for( int i = 0; i<= queue.size(); i++){
                int current = queue.poll();
                v--;

                int neighbour =  graph.get(current).get(0);
                degree[neighbour]--; // it is like removing the edge from current -> neighbour
                //removed[current] = true;
                if(degree[neighbour] == 1){
                    queue.add(neighbour);
                }
            }
        }



        System.out.println();




    }


    /*private static void DFS(Map<Integer, ArrayList<Integer>> graph, int vertex, int n){
        boolean [] visited = new boolean[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);

        while(!stack.isEmpty()){
            int v = stack.pop();
            System.out.print(v + "-> ");
            visited[v]= true;
            if(graph.get(v).size() > 0){

            }
            graph.get(v).forEach(u -> {
                if(!visited[u]){
                    stack.push(u);
                }
            });
        }



    }*/


    private static void addEdge(Map<Integer, ArrayList<Integer>> graph, int u, int v, int [] degree){
        graph.get(u).add(v);
        graph.get(v).add(u);
        degree[u]++;
        degree[v]++;
    }
}
