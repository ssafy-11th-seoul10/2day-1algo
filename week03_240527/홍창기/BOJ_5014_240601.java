import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_5014_240601 {

    static class Pair {
        int floor, cnt;

        Pair(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[f + 1];
        ArrayDeque<Pair> bfsQue = new ArrayDeque<Pair>();
        bfsQue.offer(new Pair(s, 0));
        visited[s] = true;
        int ansCnt = 0;

        if (s != g) {
            while (!bfsQue.isEmpty()) {
                Pair cur = bfsQue.poll();

                int nxtFloor = cur.floor + u;

                if (nxtFloor <= f && !visited[nxtFloor]) {
                    visited[nxtFloor] = true;

                    if (nxtFloor == g) {
                        ansCnt = cur.cnt + 1;
                        break;
                    }

                    bfsQue.offer(new Pair(nxtFloor, cur.cnt + 1));
                }

                nxtFloor = cur.floor - d;

                if (nxtFloor >= 1 && !visited[nxtFloor]) {
                    visited[nxtFloor] = true;

                    if (nxtFloor == g) {
                        ansCnt = cur.cnt + 1;
                        break;
                    }

                    bfsQue.offer(new Pair(nxtFloor, cur.cnt + 1));
                }
            }
        }

        if (visited[g]) {
            System.out.println(ansCnt);
        } else {
            System.out.println("use the stairs");
        }

        br.close();
    }

}
