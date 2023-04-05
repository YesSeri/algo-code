package algos;

import graphs.WeightedEdge;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {

    // Line 1, [0] is number of building/nodes
    // Line 1, [1] is number of cables/edges
    // Line 2..m, [0] is cable from building
    // Line 2..m, [1] is cable to building
    // Line 2..m, [2] is cable cost
    List<List<WeightedEdge>> graph;
    boolean[] markedBuildings;

    // Priority queue over all discovered edges.
    PriorityQueue<WeightedEdge> pq = new PriorityQueue<WeightedEdge>();
    ArrayDeque<WeightedEdge> mst = new ArrayDeque<>();

    PrimsAlgo(List<List<WeightedEdge>> graph, int k) {
        this.graph = graph;
        this.markedBuildings = new boolean[k + 1];
        for (int i = 1; i < markedBuildings.length; i++) {
            markedBuildings[i] = false;
        }
    }

    int run() {
        visit(graph, 1);
        while (!pq.isEmpty()) {
            WeightedEdge e = pq.remove();
            int first = e.get();
            int other = e.getOther(first);
            if (!(markedBuildings[first] && markedBuildings[other])) {
                mst.add(e);
            }
            if (!markedBuildings[first]) {
                visit(graph, first);
            }
            if (!markedBuildings[other]) {
                visit(graph, other);
            }
        }
        int totalWeight = 0;
        for (WeightedEdge el : mst) {
            int weight = el.getWeight();
            totalWeight = totalWeight + weight;
        }
        return totalWeight;
    }

    private void visit(List<List<WeightedEdge>> graph, int i) {
        markedBuildings[i] = true;
        for (WeightedEdge e : graph.get(i)) {
            if (!markedBuildings[e.other(i)] || !markedBuildings[i]) {
                pq.add(e);
            }
        }

    }
}
