import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_240725_5107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int ti = 1;; ti++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
            int[] mani = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String s = st.nextToken();
                String t = st.nextToken();
                int u;
                int v;

                if (hashMap.containsKey(s)) {
                    u = hashMap.get(s);
                } else {
                    u = hashMap.size();
                    hashMap.put(s, u);
                }

                if (hashMap.containsKey(t)) {
                    v = hashMap.get(t);
                } else {
                    v = hashMap.size();
                    hashMap.put(t, v);
                }

                mani[u] = v;
            }

            boolean[] visited = new boolean[n];
            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }

                ans++;
                visited[i] = true;

                for (int j = mani[i]; j != i; j = mani[j]) {
                    visited[j] = true;
                }
            }

            sb.append(ti).append(' ').append(ans).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

}
