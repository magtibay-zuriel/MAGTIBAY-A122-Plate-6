import java.util.*;

public class MatrixToGraph {

    private int vertex;
    private ArrayList<Integer> matrixGraph[][] = new ArrayList[vertex][vertex];

    private LinkedList<String> edges;

    public MatrixToGraph(int vertex, ArrayList<Integer>[][] matrixGraph) {
        this.vertex = vertex;
        this.matrixGraph = matrixGraph;

        for (int i = 0; i < vertex; i++)
            edges = new LinkedList<>();
    }

    public void showMatrix() {
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(matrixGraph[i][j]);
            }
            System.out.println();
        }
    }

    public void matrixToGraph() {
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++)
                if (matrixGraph[i][j].contains(1)) {
                    String u = String.valueOf(i);
                    String v = String.valueOf(j);

                    System.out.println(u + " " + v);

                    if(edges.isEmpty())
                        edges.add(u + " " + v);
                    
                    else {
                        if(edges.contains(u + " " + v) || edges.contains(v + " " + u))
                            continue;
                        else
                            edges.add(u + " " + v);
                    }   
                }
        }
    }

    public void showEdges() {
        for (String list : edges) {
            System.out.println(list);
        }
    }
}
