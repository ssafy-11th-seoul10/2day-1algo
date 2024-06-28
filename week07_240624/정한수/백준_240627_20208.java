import java.io.*;
import java.util.*;

public class Main {

    private static class Point{
        int i, j, idx;

        public Point(int i, int j, int idx) {
            this.i = i;
            this.j = j;
            this.idx = idx;
        }

        public static int distanceOf(Point p1, Point p2){
            return Math.abs(p1.i - p2.i) + Math.abs(p1.j - p2.j);
        }
    }

    private static final LinkedList<Point> points = new LinkedList<>();
    private static int[][] distances;
    private static int N, M, H, maxMilk;

    private static int readInt() throws IOException {
        int c, n = 0;

        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    private static void dfs(Point curPos, int visited, int curHP, int totalMilk){
        if (totalMilk > 0 && curPos.idx == 0){
            maxMilk = Math.max(maxMilk, totalMilk - 1);
            return;
        }

        for (Point p : points){
            if (p == curPos) continue;

            int dist = distances[curPos.idx][p.idx];
            if (dist <= curHP && (visited & (1 << p.idx)) == 0){
                dfs(p, visited | (1 << p.idx), curHP - dist + H, totalMilk + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int idx = 1;

        N = readInt();
        M = readInt();
        H = readInt();

        //parse field
        int[][] field = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                field[i][j] = readInt();
                if (field[i][j] == 1){
                    points.addFirst(new Point(i, j, 0));
                } else if (field[i][j] == 2){
                    points.addLast(new Point(i, j, idx++));
                }
            }
        }

        //preprocess distances
        int size = points.size();
        distances = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j < size; j++){
                distances[i][j] = distances[j][i] = Point.distanceOf(points.get(i), points.get(j));
            }
        }

        dfs(points.getFirst(), 0, M, 0);
        System.out.println(maxMilk);
    }

}
