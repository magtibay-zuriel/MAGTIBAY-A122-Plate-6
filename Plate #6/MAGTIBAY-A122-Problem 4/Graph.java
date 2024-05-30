import java.util.*;

public class Graph {

    private ArrayList<String> eString = new ArrayList<>();
    private ArrayList<String> vString = new ArrayList<>();
    private LinkedList<Integer> degree[];

    // Adds the passed string to the list
    public void addEdge(String input) {
        eString.add(input);
    }

    // Method for getting the vertecies from the given edge
    public void getVertex() {
        for (int i = 0; i < eString.size(); i++) {

            String v1 = String.valueOf(eString.get(i).charAt(0));
            String v2 = String.valueOf(eString.get(i).charAt(2));

            if (vString.isEmpty()) {
                vString.add(v1);
                vString.add(v2);
            }

            else 
                checkDuplicate(v1, v2); // Checks if the pair of vertex has shown twice
        }
    }

    // Method for checking if the pair of vertecies has already added to the list
    private void checkDuplicate(String v1, String v2) {
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

    // Method to show edges (vertex pair) and the vertecies
    public void showGraph() {
        System.out.println("Edges : ");
        for (String string : eString)
            System.out.println(string);

        System.out.println("\nVertices : ");
        for (String string : vString)
            System.out.println(string);
    }

    // Method for getting the degree for every vertex of the graph
    public void getVertexDegree() {
        degree = new LinkedList[vString.size()];

        for (int i = 0; i < vString.size(); i++) {
            int count = 0;
            for (int j = 0; j < eString.size(); j++) {
                String u = String.valueOf(eString.get(j).charAt(0));
                String v = String.valueOf(eString.get(j).charAt(2));

                if (vString.get(i).equals(u) || vString.get(i).equals(v))
                    count++;

            }
            System.out.println(vString.get(i) + " degree " + count);
        }
    }

}
