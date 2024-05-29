import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 1_000_000_000;
    private static int[][] adj;

    private static void floydWarshall(){
        int N = adj.length - 1;
        for (int k = 1; k <= N; k++){
            for (int i = 1; i <= N; i++){
                for (int j = 1; j <= N; j++){
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        adj = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++){
            for (int j = 0; j <= N; j++){
                adj[i][j] = (i == j ? 0 : INF);
            }
        }

        for (int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a][b] = adj[b][a] = c;
        }

        floydWarshall();

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(adj[a][b]).append('\n');
        }

        System.out.println(sb);
    }

}
