import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // New Scanner with parameter FileReader to read contents on txt file
        Scanner in = new Scanner(new FileReader("input.txt"));
        Scanner scan = new Scanner(System.in);

        // Initialize new Object
        Graph myGraph = new Graph();

        System.out.println("a. undirected graph");
        System.out.println("b. directed graph");

        char input = scan.next().charAt(0);

        // Reads contents from txt file as input
        // Input accepts pairs of strings as edge
        while (in.hasNextLine())
            myGraph.addEdge(in.nextLine());

        // Gets the vertex from the given edges
        myGraph.getVertex();

        // Outputs the vertecies
        // myGraph.showVertex();

        switch (input) {
            case 'a':

                System.out.println("\nEdges : ");
                myGraph.showEdge();
                System.out.println();

                System.out.println("Vertices : ");
                myGraph.showVertex();
                System.out.println();

                // Converts the graph to ajacency matrix
                myGraph.convertUndirectedToMatrix();
                break;

            case 'b':
                System.out.println("\nEdges : ");
                myGraph.showEdge();
                // System.out.println();

                System.out.println("\nVertices : ");
                myGraph.showVertex();
                System.out.println();
                // Converts the graph to ajacency matrix
                myGraph.convertDirectedToMatrix();
                break;

            default:
                System.out.println("invalid input");
        }
        in.close();
        scan.close();
    }
}