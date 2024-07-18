문제 주의
  시작과 끝이 선택되지 않는다고 명확하게 써있지 않았음
  이동중에 N번째를 지나면 안된다는 말이 없었음


----------------------------------------------

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static List<int[]>[] connInfo;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        connInfo = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            connInfo[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            connInfo[a].add(new int[]{b, c});
            connInfo[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());
        System.out.println(findAnswer(target1, target2));

    }

    private static int findAnswer(int target1, int target2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        int[][][] visited = new int[N + 1][2][2];
        pq.add(new int[]{1, 0, (1 == target1) ? 1 : 0, (1 == target2) ? 1 : 0});
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        while (pq.size() > 0) {
//            for (int[] ints : pq) {
//                System.out.print(ints[0] + " " + ints[1] + " | ");
//            }
//            System.out.println();
            int[] cur = pq.poll();
//            System.out.println(Arrays.toString(cur));
            if (cur[0] == N) {
                if (cur[2] == 1 && cur[3] == 1) {
                    return cur[1];
                }
            }
            for (int i = 0; i < connInfo[cur[0]].size(); i++) {
                int[] next = connInfo[cur[0]].get(i);
                int nextVal = cur[1] + next[1];
                if (visited[next[0]][cur[2]][cur[3]] > nextVal) {
                    visited[next[0]][cur[2]][cur[3]] = nextVal;
                    int findTarget1 = (next[0] == target1) ? 1 : cur[2];
                    int findTarget2 = (next[0] == target2) ? 1 : cur[3];
                    pq.add(new int[]{next[0], nextVal, findTarget1, findTarget2});
                }

            }
        }
        return -1;
    }


}
