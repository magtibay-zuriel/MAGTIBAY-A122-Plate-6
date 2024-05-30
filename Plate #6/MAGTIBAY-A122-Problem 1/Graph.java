import java.util.*;

public class Graph {

    private int vertex;
    private LinkedList<Integer> edges[];

    // Constructor to set n vertex when initialized
    public Graph(int v) {
        this.vertex = v;
        edges = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) 
            edges[i] = new LinkedList<>();
    }

    // Passes the converted set of vertex of an edge
    public void addEdge(int u, int v) {
        edges[v].add(u);
        edges[u].add(v);
    }

    // Checks if the graph is connected
    public boolean isConnected() {
        boolean visited[] = new boolean[vertex];
        dfs(0, visited);
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) 
                return false;
        }
        return true;
    }

    public int countConnectedComponents() {
        boolean visited[] = new boolean[vertex];
        int count = 0;
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int u, boolean visited[]) {
        visited[u] = true;
        for (int v : edges[u]) {
            if (!visited[v]) 
                dfs(v, visited);
        }
    }    
}