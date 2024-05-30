import java.util.*;

public class Graph {
    
    private LinkedList<String> eString = new LinkedList<>();
    private LinkedList<String> vString = new LinkedList<>();

    public void addEdge(String input) {
        eString.add(input);
    }

    public void showGraph() {
        System.out.println("Edges : ");
        for (String string : eString) 
            System.out.println(string);

        System.out.println("\nVertices : ");
        for (String string : vString)
            System.out.println(string);
    }

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

    private void checkDuplicate(String v1, String v2) {

        if (!vString.contains(v1) && !vString.contains(v2))
            if (vString.contains(v1) && !vString.contains(v2))
                vString.add(v2);

            else if (vString.contains(v2) && !vString.contains(v1))
                vString.add(v1);

            else {
                vString.add(v1);
                vString.add(v2);
            }
    }

    public void convertToMatrix() {

        for(int i = 0; i < vString.size(); i++) {
            for(int j = 0; j < eString.size(); j++) {
                if(eString.get(j).contains(vString.get(i)))
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");
            }
            System.out.println();
        }
    }

}
