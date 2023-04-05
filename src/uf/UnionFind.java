package uf;


import java.util.Arrays;

/*
    public class UF                                       - initialize N sites with integer names (0 to N-1)
    UF(int N)                                             - void union(int p, int q)add connection between p and q
    int find(int p)component identifier for p (0 to N-1)  - boolean connected(int p, int q) return true if p and q are in the same component
    int count()                                           - number of component
*/
public class UnionFind {

    int[] arr;
    int[] size;

    public UnionFind(int k) {
        this.arr = new int[k];
        this.size = new int[k];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = i;
            this.size[i] = 1;
        }
    }

    public void union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);

        if (p1 == p2) return;

        if (size[p1] < size[p2]) {
            arr[p1] = p2;
            size[p2] += size[p1];
        } else {
            arr[p2] = p1;
            size[p1] += size[p2];
        }
    }


    // Don't use this, java doesn't have tail recursion.
    public int findRecursive(int i) {
        return arr[i] == i ? arr[i] : findRecursive(arr[i]);
    }

    public boolean areConnected(int i, int j){
        return find(i) == find(j);
    }

    // Compression
    public int find(int i) {
        int j = i;
        while (arr[j] != j) {
            j = arr[j];
        }
        while (arr[i] != i) {
            arr[i] = j;
            i = arr[i];
        }
        return i;
    }

    @Override
    public String toString() {
        return "UnionFind{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {

        UnionFind uf = new UnionFind(5);
        System.out.println("0,1");
        uf.union(0, 1);
        System.out.println(uf);
        System.out.println("2, 1 are connected: " + uf.areConnected(2, 1));

        System.out.println("2,3");
        uf.union(2, 3);
        System.out.println(uf);
        System.out.println("2, 1 are connected: " + uf.areConnected(2, 1));

        System.out.println("2,1");
        uf.union(2, 1);
        System.out.println(uf);
        System.out.println("2, 1 are connected: " + uf.areConnected(2, 1));

    }
}
