import graphs.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class WayBetweenBuildings {
    public static void main(String[] args) throws IOException {

        String test = "4 3 1 2\n" + "1 3\n" + "2 4\n" + "3 4\n";
        Reader inputString = new StringReader(test);
        BufferedReader br = new BufferedReader(inputString);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line1 = new int[4];
        String[] arr = br.readLine().split("\s");
        for (int i = 0; i < 4; i++) {
            line1[i] = Integer.parseInt(arr[i]);
        }

        Graph graph = new Graph(line1[0]);
        for (int i = 0; i < line1[1]; i++) {
            String[] split = br.readLine().split(" ");
            int first = Integer.parseInt(split[0]);
            int other = Integer.parseInt(split[1]);
            graph.addNeighbour(first, other);
        }

        System.out.println(graph);


//        graph.addNeighbours(sb.toString());
//        String result = MarkedGraph.isWay(graph, Integer.valueOf(arr[2]), Integer.valueOf(arr[3])) ? "YES" : "NO";
//        System.out.println(result);
    }
}

//
//class MarkedGraph extends graphs.Graph {
//    public Map<Integer, Boolean> marked = new HashMap<>();
//
//    public MarkedGraph(int size) {
//        super(size);
//        for (int i = 1; i <= size; i++) {
//            this.marked.put(i, false);
//        }
//    }
//
//    public static boolean isWay(MarkedGraph g, Integer start, Integer end) {
//        g.mark(start);
//        var neighbours = (ArrayList<Integer>) g.vertices.get(start);
//        if (neighbours.contains(end)) {
//            return true;
//        }
//        for (Integer neighbour : neighbours) {
//            if (!g.isMarked(neighbour)) {
//                if (isWay(g, neighbour, end)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public void mark(Integer vertex) {
//        marked.put(vertex, true);
//    }
//
//    public boolean isMarked(Integer vertex) {
//        return marked.get(vertex);
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        vertices.forEach((k, v) -> {
//            String m = this.marked.get(k) ? "m" : "x";
//            s.append(m + " " + k + " " + v + "\n");
//        });
//        return s.toString();
//    }
//}

