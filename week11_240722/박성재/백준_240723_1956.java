import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_240723_1956 {
    static int V;
    static int E;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int[][] dist = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[u][v] = w; // a, b 쌍이 같은 도로는 한번만 주어짐
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 1 - 1 - 1
        // 1 - 2 - 1
        // 1 - 3 - 1
        // ...
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, dist[i][i]);
        }

        if (answer == INF) {
            sb.append(-1).append("\n");
        } else
            sb.append(answer).append("\n");
        System.out.println(sb);
    }
}
