import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2412_240609 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        HashSet<Long> points = new HashSet<Long>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(x * 200000L + y);
        }

        ArrayDeque<Point> bfsQue = new ArrayDeque<Point>();
        bfsQue.offer(new Point(0, 0));
        boolean bfsFinished = false;
        int bfsDepth = 0;

        whileBfs: while (!bfsQue.isEmpty()) {
            int bfsIter = bfsQue.size();
            bfsDepth++;

            while (bfsIter-- > 0) {
                Point curPoint = bfsQue.poll();

                for (int dx = -2; dx <= 2; dx++) {
                    for (int dy = -2; dy <= 2; dy++) {
                        int nx = curPoint.x + dx;
                        int ny = curPoint.y + dy;

                        if (points.contains(nx * 200000L + ny)) {
                            if (ny == t) {
                                bfsFinished = true;
                                break whileBfs;
                            }

                            points.remove(nx * 200000L + ny);
                            bfsQue.offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }

        System.out.println(bfsFinished ? bfsDepth : -1);
        br.close();
    }

}
