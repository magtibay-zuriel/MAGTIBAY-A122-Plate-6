import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner in = new Scanner(new FileReader("input.txt"));

        Graph myGraph = new Graph();

        while(in.hasNextLine()) 
            myGraph.addEdge(in.nextLine());
        
        myGraph.getVertex();
        myGraph.showGraph();

        System.out.println();
        myGraph.convertEdges();
        myGraph.showIntGraph();

        if(myGraph.hasCycle())
            System.out.println("Has Circuit");
        else
            System.out.println("No Circuit");
    }
}