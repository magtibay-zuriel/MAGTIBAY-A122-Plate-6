import java.util.Arrays;

public class GraphIsomorphism {

    public static void main(String[] args) {
        int[][] graph1 = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 3}
        };

        int[][] graph2 = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 3}
        };

        if (graph1.length == graph2.length) {
            int edgeCount = graph1.length;
            int sameEdgeCount = 0;

            for (int x = 0; x < edgeCount; x++) {
                int[] edge1 = graph1[x];
                int[] invertedEdge1 = new int[]{edge1[1], edge1[0]};

                for (int y = 0; y < edgeCount; y++) {
                    int[] edge2 = graph2[y];
                    int[] invertedEdge2 = new int[]{edge2[1], edge2[0]};

                    if (Arrays.equals(edge1, edge2) || Arrays.equals(edge1, invertedEdge2) || Arrays.equals(invertedEdge1, edge2)) {
                        sameEdgeCount++;
                        break;
                    }
                }
            }

            if (edgeCount == sameEdgeCount) {
                System.out.println("Isomorphic");
            } else {
                System.out.println("Not isomorphic");
            }
        } else {
            System.out.println("Not Isomorphic");
        }
    }
}



