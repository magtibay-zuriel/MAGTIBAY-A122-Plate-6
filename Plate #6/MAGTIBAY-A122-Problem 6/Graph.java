import java.util.*;

public class Graph {

    private LinkedList<String> eString = new LinkedList<>();
    private LinkedList<String> vString = new LinkedList<>();

    // Adds a pair of vertices (edges) from input
    public void addEdge(String input) {
        eString.add(input);
    }

    // Outputs vertices from the graph
    public void showEdge() {
        for (String string : eString)
            System.out.println(string);
    }

    // Outputs vertices from the graph
    public void showVertex() {
        for (String string : vString) {
            System.out.println(string);
        }
    }

    // Gets vertices from the given edges
    public void getVertex() {
        for (int i = 0; i < eString.size(); i++) {

            String v1 = String.valueOf(eString.get(i).charAt(0));
            String v2 = String.valueOf(eString.get(i).charAt(2));

            if (vString.isEmpty()) {
                vString.add(v1);
                vString.add(v2);
            }

            else
                checkDuplicate(v1, v2);

        }
    }

    // Checks if the current vertices are already added to the list
    private void checkDuplicate(String v1, String v2) {
        boolean hasValue = false;
        if (vString.contains(v1) && vString.contains(v2))
            hasValue = true;

        // if (!vString.contains(v1) && !vString.contains(v2))
        if(!hasValue)
            if (vString.contains(v1) && !vString.contains(v2))
                vString.add(v2);

            else if (vString.contains(v2) && !vString.contains(v1))
                vString.add(v1);

            else {
                vString.add(v1);
                vString.add(v2);
            }
    }

    // Checks the current vertex has a pair
    private int CheckUnDirGraph(int index1, int index2) {

        String v1 = vString.get(index1);
        String v2 = vString.get(index2);
        int count = 0;

        for(int i = 0; i < eString.size(); i++) 
            if (eString.get(i).contains(v1 + " " + v2) || eString.get(i).contains(v2 + " " + v1))
                count++;
        
        return count;
    }

    // Converts the graph to ajacency matrix
    public void convertUndirectedToMatrix() {

        for (int i = 0; i < vString.size(); i++) {
            for (int j = 0; j < vString.size(); j++) 
                System.out.print(CheckUnDirGraph(i, j) + " ");
            
            System.out.println();
        }
    }

    private int checkDirGraph(int index1, int index2) {

        String v1 = vString.get(index1);
        String v2 = vString.get(index2);
        int count = 0;

        for(int i = 0; i < eString.size(); i++) 
            if(eString.get(i).contains(v1 + " " + v2))
                count++;
        

        return count;
    }

    public void convertDirectedToMatrix() {

        for (int i = 0; i < vString.size(); i++) {
            for (int j = 0; j < vString.size(); j++) 
                System.out.print(checkDirGraph(i, j) + " ");
            
            System.out.println();
        }
    }
}
