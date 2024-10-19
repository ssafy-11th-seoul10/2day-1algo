import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_241014_1949 {

    static int[] people;
    static ArrayList<Integer>[] adj;

    static int[] dfs(int cur, int par) {
        int[] res = new int[2];
        res[1] = people[cur];

        for (int nxt : adj[cur]) {
            if (nxt == par) continue;

            int[] nxt_res = dfs(nxt, cur);
            res[0] += Math.max(nxt_res[0], nxt_res[1]);
            res[1] += nxt_res[0];
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        people = new int[n + 1];

        for (int u = 1; u <= n; u++) {
            people[u] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[n + 1];

        for (int u = 1; u <= n; u++) {
            adj[u] = new ArrayList<Integer>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        int[] ans = dfs(1, 0);

        System.out.println(Math.max(ans[0], ans[1]));
        br.close();
    }

}
