import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Initialize new Scanner and using FileReader as the parameter
        // to read txt files

        Scanner in = new Scanner(new FileReader("graph.txt"));

        int edge = 0;
        int vertex = 0;

        // Reads the first line from graph.txt file which is the number of edges as an input
        while (in.hasNextLine()) {
            try {
                edge = in.nextInt();
            } 
            catch (InputMismatchException e) {
                break;
            }
        }

        // Initialize Linkedlist to store inputs from the graph.txt file
        LinkedList<String> eString = new LinkedList<>();
        LinkedList<String> vString = new LinkedList<>();

        // Reads the next line which are the pair of vertices in an edge
        while (in.hasNextLine()) {
            eString.add(in.nextLine());
        }

        // There is no input for number of vertices so I will get the vertex from the given edges
        // Get vertex from given edges
        for (int i = 0; i < edge; i++) {
            String v1 = String.valueOf(eString.get(i).charAt(0));
            String v2 = String.valueOf(eString.get(i).charAt(2));
            if (vString.isEmpty()) {
                vString.add(v1);
                vString.add(v2);
            } 

            else {
                boolean hasValue = false;
                if (vString.contains(v1) && vString.contains(v2))
                    hasValue = true;

                if (!hasValue)
                    if (vString.contains(v1) && !vString.contains(v2))
                        vString.add(v2);

                    else if (vString.contains(v2) && !vString.contains(v1))
                        vString.add(v1);
                        
                    else {
                        vString.add(v1);
                        vString.add(v2);
                    }
            }
        }

        // Outputs the vertices from the edges
        System.out.print("Vertices : ");
        for (String string : vString) {
            System.out.print(string + " ");
        }

        // Initialize int variable to store n vertices
        vertex = vString.size();
        System.out.println("\nVertex size : " + vertex);

        // Initialize new Object with the size of n vertices
        Graph graph = new Graph(vertex);

        System.out.println("\nEdges : ");
        for (String string : eString) {
            System.out.println(string);
        }

        System.out.println("\nEdges alphabet to numbers");
        // This loop converts the set of edges that are labeled using the alphabet to numbers
        for (int i = 0; i < edge; i++) {
            String u = String.valueOf(eString.get(i).charAt(0));
            String v = String.valueOf(eString.get(i).charAt(2));

            int index1 = 0;
            int index2 = 0;

            for (int j = 0; j < vString.size(); j++) {
                if (vString.get(j).equals(u))
                    index1 = j;
            }

            for (int j = 0; j < vString.size(); j++) {
                if (vString.get(j).equals(v))
                    index2 = j;
            }

            // Outputs the set of edges with numbers
            System.out.println(index1 + " " + index2);

            // Adds the converted edges to the object
            graph.addEdge(index1, index2);
        }

        // Determine weather the given graph is connected or disconnected
        boolean isConnected = graph.isConnected();

        // Counts the number of components on the given graph
        int count = graph.countConnectedComponents();

        System.out.println();
        if (isConnected) 
            System.out.println("Graph is Connected.");
        
        else {
            System.out.println("Graph is Disconnected.");
            System.out.println("Connected components: " + count);
        }

        in.close();
    }
}
