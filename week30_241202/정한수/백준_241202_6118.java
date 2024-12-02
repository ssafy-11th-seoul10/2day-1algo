import java.io.*;
import java.util.*;

public class Main {

    private static int[] bfs(List<Integer>[] adj){
        Deque<PriorityQueue<Integer>> pqs = new ArrayDeque<>();
        BitSet visited = new BitSet(adj.length);

        pqs.add(new PriorityQueue<>());
        pqs.getLast().add(1);
        visited.set(1);
        while (true){
            PriorityQueue<Integer> pq = pqs.getLast();
            PriorityQueue<Integer> nextPq = new PriorityQueue<>();

            pqs.add(nextPq);
            for (int cur : pq){
                for (int next : adj[cur]){
                    if (!visited.get(next)){
                        visited.set(next);
                        nextPq.add(next);
                    }
                }
            }

            if (nextPq.isEmpty()){
                return new int[]{pq.element(), pqs.size() - 2, pq.size()};
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] adj = new List[N + 1];

        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] result = bfs(adj);
        System.out.printf("%d %d %d\n", result[0], result[1], result[2]);
    }

}
