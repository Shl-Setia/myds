package coursera.graph;

public class TestClient {
    public static void main(String[] args) {
        GraphAdjacencyList G = new GraphAdjacencyList(13);
        G.addEdge(0,5);
        G.addEdge(4,3);
        G.addEdge(0,1);
        G.addEdge(9,12);
        G.addEdge(6,4);
        G.addEdge(5,4);
        G.addEdge(0,2);
        G.addEdge(11,12);
        G.addEdge(9,10);
        G.addEdge(0,6);
        G.addEdge(7,8);
        G.addEdge(9,11);
        G.addEdge(5,3);

        DepthFirstPaths dfs = new DepthFirstPaths(G, 0);
        dfs.printPathTo(4);
        dfs.printPathTo(6);
        dfs.printPathTo(2);

        ConnectedComponentsUsingDFS cc = new ConnectedComponentsUsingDFS(G);
        System.out.println("cc count: " + cc.getCount());
        System.out.println("id of 4: " + cc.getId(4));
        System.out.println("id of 7: " + cc.getId(7));
        System.out.println("id of 10: " + cc.getId(10));
    }
}
