import java.util.ArrayList;
import java.util.List;

class MyGraph {
    public List<List<Integer>> vertices = new ArrayList();

    public MyGraph(int size) {
        this.vertices.add(null);
        for (int i = 1; i <= size; i++) {
            this.vertices.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        MyGraph g = new MyGraph(5);
        g.addNeighbour(3, 2);
        g.addNeighbour(4, 5);
        g.addNeighbour(5, 2);

        System.out.println(g);
    }

    public void addNeighbour(int i, int j) {
        ArrayList l0 = (ArrayList) vertices.get(i);
        l0.add(j);
        ArrayList l1 = (ArrayList) vertices.get(j);
        l1.add(i);
//        s.lines().forEach((line) -> {
//            ArrayList<Integer> nums = (ArrayList<Integer>) Arrays.stream(line.split("\s")).map(Integer::valueOf).collect(Collectors.toList());
//            // We add neighbour in both directions, to make it bidirectional.
//            ArrayList l0 = (ArrayList) vertices.get(nums.get(0));
//            l0.add(nums.get(1));
//            ArrayList l1 = (ArrayList) vertices.get(nums.get(1));
//            l1.add(nums.get(0));
//        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < vertices.size(); i++) {
            List<Integer> list = vertices.get(i);
            sb.append(i + " -> ");
            for (Integer j : list) {
                sb.append(j.intValue());
                sb.append(",");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
