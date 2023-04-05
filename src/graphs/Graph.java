package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {
    public HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public Graph(int size) {
        for (int i = 1; i <= size; i++) {
            this.adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addNeighbour(int first, int other) {
        List l1 = adjacencyList.get(first);
        l1.add(other);

        List l2 = adjacencyList.get(other);
        l2.add(first);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();


        adjacencyList.forEach((key, list) -> {
            String values = list.stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
            sb.append(key + " -> ");
            sb.append(values + "\n");
        });
        return sb.toString();
    }

}
