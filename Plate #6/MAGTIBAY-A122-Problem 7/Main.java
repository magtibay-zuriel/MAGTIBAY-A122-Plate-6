import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner in = new Scanner(new FileReader("input.txt"));

        Graph myGraph = new Graph();

        while(in.hasNextLine())
            myGraph.addEdge(in.nextLine());

        // Gets the vertices from the given graph
        myGraph.getVertex();

        // Shows the set of edges and vertices
        myGraph.showGraph();

        // Constructs a incidence matrix from the given graph
        System.out.println("\nIncidence Matrix");
        myGraph.convertToMatrix();
    }
}