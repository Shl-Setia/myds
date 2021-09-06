package coursera.graph;

public class ConnectedComponentsUsingDFS {

    private boolean [] visited;
    private int [] id;
    private int count;

    public ConnectedComponentsUsingDFS(GraphAdjacencyList G) {
        visited = new boolean[G.V()];
        id = new int[G.V()];
        for(int vertex=0; vertex < G.V(); vertex++){
            if(!visited[vertex]){
                dfs(G, vertex);
                count++;
            }
        }
    }

    private void dfs(GraphAdjacencyList G, int source){
        visited[source] = true;
        id[source] = count;
        for(int w : G.getAdj(source)){
            if(!visited[w]){
                dfs(G,w);
            }
        }
    }

    public int getCount() {
        return count;
    }

    public int getId(int v)
    {  return id[v];  }
}
