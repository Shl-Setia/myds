package graph;

//https://en.wikipedia.org/wiki/Topological_sorting

// Graph must not have cycle and be directed. (DAG)
public class TopologicalSort {
    public static void main(String[] args) {


        // graph is directed
        // find in-degree of each vertex
        // take a queue and add all vertex to it with in degree = 0
        // dequeue a vertex and mark it visited and decrease in-degree of all adjacent element by 1
        // if any of vertex in-degree become 0, add to queue.

        // time complexity : O(V + E). Linear time.
    }
}
