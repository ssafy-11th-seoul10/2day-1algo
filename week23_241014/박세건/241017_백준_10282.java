방문처리를 통과했다는 그 즉시 visited=true 처리를 해준다


---

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int T, N, D, C;

    private static List<int[]>[] connInfo;
    //    private static int[][] connInfo;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            inputSetting();
            bfs();
            int answerCnt = 0;
            int answerTime = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] != Integer.MAX_VALUE) {
                    answerCnt++;
                    answerTime = Math.max(answerTime, visited[i]);
                }
            }
            System.out.println(answerCnt + " " + answerTime);
        }
    }

    private static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        visited[C] = 0;
        pq.add(new int[]{C, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            visited[cur[0]] = Math.min(visited[cur[0]], cur[1]);
            for (int i = 0; i < connInfo[cur[0]].size(); i++) {
                int[] next = connInfo[cur[0]].get(i);
                if (visited[next[0]] <= next[1] + cur[1]) {
                    continue;
                }

                pq.add(new int[]{next[0], next[1] + cur[1]});
            }
        }
    }

    private static void inputSetting() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        connInfo = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            connInfo[i] = new ArrayList<int[]>();
        }
//        connInfo = new int[D][3];
        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            connInfo[b].add(new int[]{a, s});
        }
    }

}
