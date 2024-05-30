import java.util.*;

public class Graph {

    private LinkedList<String> eString = new LinkedList<>();
    private LinkedList<String> vString = new LinkedList<>();
    private LinkedList<Integer> eInteger[];

    public void addEdge(String input) {
        eString.add(input);
    }

    public void getVertex() {
        for (int i = 0; i < eString.size(); i++) {

            String v1 = String.valueOf(eString.get(i).charAt(0));
            String v2 = String.valueOf(eString.get(i).charAt(2));

            if (vString.isEmpty()) {
                vString.add(v1);
                vString.add(v2);
            } else
                checkDuplicate(v1, v2);
        }
    }

    private void checkDuplicate(String v1, String v2) {
        boolean hasValue = false;
        if (vString.contains(v1) && vString.contains(v2))
            hasValue = true;

        if (!hasValue) {
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

    public void showGraph() {
        for (String list : eString)
            System.out.println(list);

        for (String list : vString)
            System.out.println(list);
    }

    public void convertEdges() {
        eInteger = new LinkedList[vString.size()];
        for (int i = 0; i < vString.size(); i++)
            eInteger[i] = new LinkedList<>();

        for (int i = 0; i < eString.size(); i++) {
            String u = String.valueOf(eString.get(i).charAt(0));
            String v = String.valueOf(eString.get(i).charAt(2));

            int v1 = 0;
            int v2 = 0;

            for (int j = 0; j < vString.size(); j++) {
                if (vString.get(j).equals(u))
                    v1 = j;
            }

            for (int j = 0; j < vString.size(); j++) {
                if (vString.get(j).equals(v))
                    v2 = j;
            }

            System.out.println(v1 + " " + v2);

            eInteger[v1].add(v2);
            eInteger[v2].add(v1);
        }
    }

    public void showIntGraph() {
        for (LinkedList<Integer> linkedList : eInteger)
            System.out.println(linkedList);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vString.size()];
        for (int i = 0; i < vString.size(); i++) {
            if (!visited[i]) {
                if (dfs(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (int i : eInteger[v]) {
            if (!visited[i]) {
                if (dfs(i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }
}
