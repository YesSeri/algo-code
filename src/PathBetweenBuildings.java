//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Queue;
//
//public class PathBetweenBuildings {
//
//    public static void main(String[] args) {
//
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int[] line1 = new int[4];
//            String[] arr = br.readLine().split("\s");
//            for (int i = 0; i < 4; i++) {
//                line1[i] = Integer.parseInt(arr[i]);
//            }
//            ArrayList<Vertice> adjacentList = new ArrayList<>();
//            adjacentList.add(new Vertice()); // Zero is empty, because it doesn't really exist in our graph
//            for (int i = 0; i < line1[0]; i++) {
//                adjacentList.add(new Vertice());
//            }
//
//            for (int i = 0; i < line1[1]; i++) {
//                String[] neighbours = br.readLine().split("\s");
//                int n0 = Integer.parseInt(neighbours[0]);
//                int n1 = Integer.parseInt(neighbours[1]);
//                adjacentList.get(n0).addNeighbour(n1);
//                adjacentList.get(n1).addNeighbour(n0);
//            }
//            boolean result = bfs_iter(adjacentList, Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
//            System.out.println(result ? "YES" : "NO");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    // While queue not empty
//    // Dequeue node
//    // If node equals goal, return true
//    // Add neighbours to queue and mark visited
//    // after while, return false.
//    public static boolean bfs_iter(ArrayList<Vertice> vertices, int start, int end) {
//        Queue<Integer> queue = new ArrayDeque();
//        queue.add(start);
//
//        while (!queue.isEmpty()) {
//            Integer curr = queue.remove();
//            if (end == curr.intValue()) {
//                return true;
//            }
//            Vertice currVert = vertices.get(curr);
//            for (Integer v : currVert.neighbours) {
//                Vertice neighbour = vertices.get(v);
//                if (!neighbour.visited) {
//                    queue.add(v);
//                    neighbour.visited = true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    public static boolean bfs(ArrayList<Vertice> vertices, int start, int end) {
//        vertices.get(start).visited = true;
//        for (int i = 0; i < vertices.get(start).neighbours.size(); i++) {
//            int neighbour = vertices.get(start).neighbours.get(i);
//            if (neighbour == end) {
//                return true;
//            }
//            if (!vertices.get(neighbour).visited) {
//                if (bfs(vertices, neighbour, end)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//}
//

public class PathBetweenBuildings {

}