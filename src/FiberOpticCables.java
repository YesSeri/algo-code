/*
    Exercise

    At the University of Algorithms there are N buildings (numbered 1, 2, ..., N).
    Josefine is responsible for ensuring they are all interconnected with the newest fiber optic cables.
    Two buildings Bi and Bj can be connected by a fiber optic cable for a certain price.
    Josefine has been given a list of M prices for pairwise connecting two buildings (buildings not in this list, cannot be directly connected).
    The buildings are said to be all interconnected if there for any pair of buildings
    is a path of fiber optic cables between the two buildings (not neccessarily direct cables).

    Given the list of prices, help Josefine determine the cheapest total price that ensures the buildings are all interconnected.
    You can assume the buildings can always be interconnected.

    Input format

    Line 1: The integers N and M (1≤N, M≤50.0001≤N, M≤50.000).
    Line 2..M+1: "Bi Bj PRICE" meaning building Bi and Bj can be connected for a price of PRICE.

    Output format

    Line 1: The cheapest total price for interconnecting all the buildings.

    Sample Test

    Samples01
    Input (stdin)

4 5

2 1 5
3 2 10
4 3 8
4 1 7
4 2 2


    Expected Output

    15
*/


import graphs.WeightedEdge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FiberOpticCables {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String test = "4 5\n" + "2 1 5\n" + "3 2 10\n" + "4 3 8\n" + "4 1 7\n" + "4 2 2\n";
//            Reader inputString = new StringReader(test);
//            BufferedReader br = new BufferedReader(inputString);


            int[] line1 = new int[2];
            String[] arr = br.readLine().split("\s");
            for (int i = 0; i < 2; i++) {
                line1[i] = Integer.parseInt(arr[i]);
            }


            // add cables
            List<List<WeightedEdge>> graph = new ArrayList<>();
            graph.add(null);
            for (int i = 0; i < line1[0]; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < line1[1]; i++) {

                String[] strings = br.readLine().split("\s");
                int[] values = new int[3];
                values[0] = Integer.parseInt(strings[0]);
                values[1] = Integer.parseInt(strings[1]);
                values[2] = Integer.parseInt(strings[2]);
                WeightedEdge we = new WeightedEdge(values[0], values[1], values[2]);
                graph.get(values[0]).add(we);
                graph.get(values[1]).add(we);
            }

            var finder = new PrimsAlgo(graph, line1[0]);
            System.out.println(finder.run());


//            int[] mst = new int[line1[0] - 1];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class PrimsAlgo {

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
            int n = e.get();
            int m = e.getOther(n);
            if (!(markedBuildings[n] && markedBuildings[m])) {
                mst.add(e);
            }
            if (!markedBuildings[n]) {
                visit(graph, n);
            }
            if (!markedBuildings[m]) {
                visit(graph, m);
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