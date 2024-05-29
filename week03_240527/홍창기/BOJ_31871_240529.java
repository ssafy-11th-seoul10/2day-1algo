import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_31871_240529 {

    static int n;
    static int[][] adj;
    static boolean[] visited;
    static int maxDist = -1;

    static void recur(int depth, int curPos, int curDist) {
        if (depth == n) {
            if (adj[curPos][0] == -1) {
                return;
            }

            curDist += adj[curPos][0];
            maxDist = curDist > maxDist ? curDist : maxDist;
            return;
        }

        for (int nxtPos = 1; nxtPos <= n; nxtPos++) {
            if (visited[nxtPos] || adj[curPos][nxtPos] == -1) {
                continue;
            }

            visited[nxtPos] = true;
            recur(depth + 1, nxtPos, curDist + adj[curPos][nxtPos]);
            visited[nxtPos] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        adj = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int u = 0; u <= n; u++) {
            for (int v = 0; v <= n; v++) {
                adj[u][v] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (adj[u][v] == -1) {
                adj[u][v] = d;
            } else {
                adj[u][v] = d > adj[u][v] ? d : adj[u][v];
            }
        }

        recur(0, 0, 0);
        System.out.println(maxDist);
        br.close();
    }

}
