package graph;

// this graph uses adj matrix
public class Graph {
    boolean adjMatrix[][];
    int vertexCount;
    boolean [] visited;
    int filledVertex= 0;

    public Graph(int vertexCount) {
        this.adjMatrix = new boolean[vertexCount][vertexCount];
        this.vertexCount = vertexCount;
        this.visited = new boolean[vertexCount];
    }

    public void addEdge(int u, int v){
        if(u >=0 && u<vertexCount && v>=0 && v<vertexCount ){
            adjMatrix[u][v] = true;
            adjMatrix[v][u] = true;
        }
    }

    public void removeEdge(int u, int v){
        if(u >=0 && u<vertexCount && v>=0 && v<vertexCount ){
            adjMatrix[u][v] = false;
            adjMatrix[v][u] = false;
        }
    }

    public boolean isEdge(int u, int v){
        if(u >=0 && u<vertexCount && v>=0 && v<vertexCount ){
            return  adjMatrix[u][v];
        }else return false;
    }


    public int  getAdjacentVertex(int val){
        for(int i = 0; i < vertexCount; i++){
            if(adjMatrix[val][i] && !visited[i]){ // edge to present and not visited
                return i;
            }
        }
        return -1;
    }



}
