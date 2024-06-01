import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d, result = 987654321;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new boolean[f + 1];

        bfs();
        if (result == 987654321) System.out.println("use the stairs");
        else System.out.println(result);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s, 0});
        visited[s] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            if (temp[0] == g) {
                result = Math.min(result, temp[1]);
                continue;
            }

            if (temp[0] + u <= f && !visited[temp[0] + u]) {
                q.add(new int[]{temp[0] + u, temp[1] + 1});
                visited[temp[0] + u] = true;
            }
            if (temp[0] - d > 0 && !visited[temp[0] - d]) {
                q.add(new int[]{temp[0] - d, temp[1] + 1});
                visited[temp[0] - d] = true;
            }
        }
    }

}
