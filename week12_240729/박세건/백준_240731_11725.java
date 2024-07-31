import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        List<Integer>[] connInfo = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            connInfo[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            connInfo[x].add(y);
            connInfo[y].add(x);
        }
        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (queue.size() > 0) {
            Integer x = queue.poll();
            for (int i = 0; i < connInfo[x].size(); i++) {
                int next = connInfo[x].get(i);
                if (visited[next] == false) {
                    visited[next] = true;
                    parent[next] = x;
                    queue.add(next);
                }
            }
        }
        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }


}
