package algos;

import graphs.WeightedEdge;
import uf.UnionFind;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalsAlgo {

    // Line 1, [0] is number of building/nodes
    // Line 1, [1] is number of cables/edges
    // Line 2..m, [0] is cable from building
    // Line 2..m, [1] is cable to building
    // Line 2..m, [2] is cable cost
    List<List<WeightedEdge>> graph;
    boolean[] marked;

    // Priority queue over all discovered edges.
    PriorityQueue<WeightedEdge> pq = new PriorityQueue<WeightedEdge>();
    ArrayDeque<WeightedEdge> mst = new ArrayDeque<>();
    UnionFind uf;

    public KruskalsAlgo(List<List<WeightedEdge>> graph, int k) {
        this.uf = new UnionFind(k);
        this.marked = new boolean[k];
    }

    public String run() {
        return "";
    }

}
