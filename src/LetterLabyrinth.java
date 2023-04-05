import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LetterLabyrinth {
    // A = red
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        char[][] labArr = new char[size][size];
        for (int i = 0; i < size; i++) {
            char[] row = br.readLine().toCharArray();
            labArr[i] = row;
        }

        findLabyrinthLength(labArr);
    }


    private static void findLabyrinthLength(char[][] labArr) {
        int max = labArr.length - 1;
        boolean[][] visited = new boolean[max + 1][max + 1];
        visited[0][0] = true;

        Queue<Point> queue = new ArrayDeque();
        Point current = new Point(0, 0, labArr[0][0], 1);

        while (!(current.x == max && current.y == max)) {
            // AAABA
            // BBBBB
            // ABAAA
            // ABBBB
            // AAAAA
            // north
            if (current.y > 0 && !visited[current.y - 1][current.x]) {
                Point np = new Point(current.x, current.y - 1, labArr[current.y - 1][current.x], current.steps + 1);
                if (np.c != current.c) {
                    queue.add(np);
                    visited[np.y][np.x] = true;
                }
            }
            //south
            if (current.y < max && !visited[current.y + 1][current.x]) {
                Point np = new Point(current.x, current.y + 1, labArr[current.y + 1][current.x], current.steps + 1);
                if (np.c != current.c) {
                    queue.add(np);
                    visited[np.y][np.x] = true;
                }

            }

            //west
            if (current.x > 0 && !visited[current.y][current.x - 1]) {
                Point np = new Point(current.x - 1, current.y, labArr[current.y][current.x - 1], current.steps + 1);
                if (np.c != current.c) {
                    queue.add(np);
                    visited[np.y][np.x] = true;
                }

            }
            //east
            if (current.x < max && !visited[current.y][current.x + 1]) {
                Point np = new Point(current.x + 1, current.y, labArr[current.y][current.x + 1], current.steps + 1);
                if (np.c != current.c) {
                    queue.add(np);
                    visited[np.y][np.x] = true;
                }

            }
            current = queue.remove();
        }
        System.out.println(current.steps);
    }

    static class Point {
        int x;
        int y;
        char c;
        int steps;

        Point(int x, int y, char c, int steps) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.steps = steps;
        }
    }
}