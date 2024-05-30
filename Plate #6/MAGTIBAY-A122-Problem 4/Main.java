import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Initialize new Scanner with the parameter FileReader to read txt file as an input
        Scanner in = new Scanner(new FileReader("input.txt"));

        // Initialize new object
        Graph myGraph = new Graph();


        // Take contents from the txt file as input and adds input to the object as a pair of vertecies
        while (in.hasNextLine()) 
            myGraph.addEdge(in.nextLine()); // Passes the input to the object method
        

        // Initiate object method to take vertecies from the given edges
        myGraph.getVertex();

        // Outputs the edges (pair of vertecies) and vertex
        myGraph.showGraph();

        // Checks every vertex of an edge in the graph and counts the number of degrees
        // Checks if the given graph has a circuit
        System.out.println();
        myGraph.getVertexDegree();   

    }
}