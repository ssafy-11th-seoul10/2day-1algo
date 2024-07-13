import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_240713_18769 {

    static class Edge {
        int y;
        int x;
        int w;

        public Edge(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }

    static int R;
    static int C;
    static List<Edge>[][] list;
    static PriorityQueue<Edge> pq;
    static boolean[][] visited;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(st.nextToken());

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            list = new ArrayList[R + 1][C + 1];
            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= C; k++) {
                    list[j][k] = new ArrayList<>();
                }
            }

            for (int j = 1; j <= R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= C - 1; k++) {
                    int num = Integer.parseInt(st.nextToken());

                    list[j][k].add(new Edge(j, k + 1, num));
                    list[j][k + 1].add(new Edge(j, k, num));
                }
            }

            for (int j = 1; j <= R - 1; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 1; k <= C; k++) {
                    int num = Integer.parseInt(st.nextToken());

                    list[j][k].add(new Edge(j + 1, k, num));
                    list[j + 1][k].add(new Edge(j, k, num));
                }
            }

            sb.append(prim(1, 1)).append("\n");
        }
        System.out.println(sb);
    }

    static int prim(int startY, int startX) {
        pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.w, o2.w);
        });
        pq.add(new Edge(startY, startX, 0));
        visited = new boolean[R + 1][C + 1];

        int answer = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.y][now.x])
                continue;
            visited[now.y][now.x] = true;
            answer += now.w;

            for (int i = 0; i < list[now.y][now.x].size(); i++) {
                Edge next = list[now.y][now.x].get(i);

                if (!visited[next.y][next.x]) {
                    pq.add(next);
                }
            }
        }

        return answer;

    }
}
