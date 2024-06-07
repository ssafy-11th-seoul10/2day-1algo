import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ1005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] cost = new int[N + 1];
            int[] order = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer>[] graph = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X].add(Y);
                order[Y]+=1;
            }
            int W = Integer.parseInt(br.readLine());

            int[] dist = new int[N+1];
            Deque<Integer> deq = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (order[i] == 0) {
                    dist[i] = cost[i];
                    deq.add(i);
                }
            }
            while (!deq.isEmpty()){
                int curr = deq.removeFirst();
                for (Integer X : graph[curr]) {
                    order[X]-=1;
                    dist[X] = Math.max(dist[X],dist[curr]+cost[X]);
                    if (order[X] == 0) {
                        deq.add(X);
                    }
                }
                if(curr == W){
                    break;
                }
            }
            sb.append(dist[W]).append("\n");
        }
        System.out.println(sb);
    }

}
