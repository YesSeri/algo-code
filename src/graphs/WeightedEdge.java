package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeightedEdge implements Comparable<WeightedEdge> {

    private int weight;
    private int n;
    private int m;

    public WeightedEdge(int n, int m, int weight) {
        this.n = n;
        this.m = m;
        this.weight = weight;
    }


    public static void main(String[] args) {
        WeightedEdge e1 = new WeightedEdge(1, 2, 5);
        WeightedEdge e2 = new WeightedEdge(1, 2, 6);
        WeightedEdge e3 = new WeightedEdge(1, 2, 2);

        List<WeightedEdge> l = new ArrayList<>();
        l.add(e1);
        l.add(e2);
        l.add(e3);

        l.stream().map(el -> el.weight).forEach(System.out::println);
        Collections.sort(l);
        l.stream().map(el -> el.weight).forEach(System.out::println);
    }

    @Override
    public int compareTo(WeightedEdge that) {
        if (this.weight == that.weight) {
            return 0;
        }
        if (this.weight > that.weight) {
            return 1;
        }
        return -1;
    }

    public int other(int i) {
        if (i == n) {
            return m;
        }
        return n;
    }

    public int get() {
        return n;
    }

    public int getOther(int n) {
        return m;
    }

    public int getWeight() {
        return weight;
    }
}
