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


import algos.KruskalsAlgo;
import graphs.WeightedEdge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class FiberOpticCables {
    public static void main(String[] args) {

        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String test = "4 5\n" + "2 1 5\n" + "3 2 10\n" + "4 3 8\n" + "4 1 7\n" + "4 2 2\n";
            Reader inputString = new StringReader(test);
            BufferedReader br = new BufferedReader(inputString);


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
                int first = Integer.parseInt(strings[0]);
                int other = Integer.parseInt(strings[1]);
                int weight = Integer.parseInt(strings[2]);
                WeightedEdge we = new WeightedEdge(first, other, weight);
                graph.get(first).add(we);
                graph.get(other).add(we);
            }

            KruskalsAlgo finder = new KruskalsAlgo(graph, 5);
            System.out.println(finder.run());
//            algos.PrimsAlgo finder = new algos.PrimsAlgo(graph, line1[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

