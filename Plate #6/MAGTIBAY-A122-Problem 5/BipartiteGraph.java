import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        // Example usage: edges represented as a list of pairs
        List<int[]> edges = Arrays.asList(
            new int[]{0, 1},
            new int[]{0, 3},
            new int[]{1, 2},
            new int[]{2, 3},
            new int[]{3, 4},
            new int[]{4, 5},
            new int[]{5, 0}
        );

        System.out.println("The graph is bipartite: " + isBipartite(edges));
    }

    public static boolean isBipartite(List<int[]> edges) {
        // Find the maximum vertex index to determine the size of the graph
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }
        int n = maxVertex + 1;

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Color array, -1 means not colored, 0 and 1 are the two colors
        int[] color = new int[n];
        Arrays.fill(color, -1);

        // Check each component of the graph
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                // If the component hasn't been colored, perform BFS
                if (!bfsCheck(graph, color, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfsCheck(List<List<Integer>> graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0; // Start coloring with color 0

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == -1) {
                    // Color with the opposite color
                    color[neighbor] = 1 - color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    // If the neighbor has the same color, the graph is not bipartite
                    return false;
                }
            }
        }

        return true;
    }
}
