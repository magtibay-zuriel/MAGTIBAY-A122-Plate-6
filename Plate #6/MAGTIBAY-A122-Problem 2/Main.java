import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //Initialize new scanner with new FileReader as a parameter to read contents from a txt.file as an input
        Scanner in = new Scanner(new FileReader("input.txt"));

        //gets the first text from the txt file which is the length
        int vertex = in.nextInt();

        // Initialize 2D arrayList length [n][n]
        ArrayList<Integer> matrixGraph[][] = new ArrayList[vertex][vertex];

        // Changes values to every index from null to matrix graph from the input
        while(in.hasNextLine()) {
            for(int i = 0; i < vertex; i++) 
                for(int j = 0; j < vertex; j++) {
                    matrixGraph[i][j] = new ArrayList();
                    matrixGraph[i][j].add(in.nextInt());
                }
        }

        // Initialize new an Object with the parameter of number of vertex and the ArrayList matrix graph
        MatrixToGraph newGraph = new MatrixToGraph(vertex, matrixGraph);

        // Outputs the adjacency matrix from the input
        System.out.println("Given Matrix : ");
        newGraph.showMatrix();
        System.out.println();

        // Outputs the set of edges (vertex pair) showed on the adjacency matrix
        System.out.println("Edges from matrix showed : ");
        newGraph.matrixToGraph();
        System.out.println();

        // Outputs the all the edges removing the duplicate edges from the adjacency matrix
        System.out.println("Edges : ");
        newGraph.showEdges();
    }
}