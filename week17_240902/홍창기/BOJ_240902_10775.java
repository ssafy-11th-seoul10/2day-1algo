import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240902_10775 {

    static int[] parents;

    static void initParents(int n) {
        parents = new int[n + 1];

        for (int u = 0; u <= n; u++) {
            parents[u] = u;
        }
    }

    static int getParentOf(int u) {
        if (parents[u] == u) return u;
        return parents[u] = getParentOf(parents[u]);
    }

    static void unionParents(int u1, int u2) {
        int pu1 = getParentOf(u1);
        int pu2 = getParentOf(u2);

        if (pu1 != pu2) {
            if (pu1 < pu2) {
                parents[pu2] = pu1;
            } else {
                parents[pu1] = pu2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        initParents(g);
        int ans = 0;

        for (int pi = 0; pi < p; pi++) {
            int gi = Integer.parseInt(br.readLine());

            if (getParentOf(gi) == 0) break;

            unionParents(getParentOf(gi) - 1, getParentOf(gi));
            ans++;
        }

        System.out.println(ans);
        br.close();
    }

}
