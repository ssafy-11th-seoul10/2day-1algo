주어진 지점에서 주어진 목적지까지 최단 거리 : 다익스트라 - BFS + 우선순위 큐
모든 지점에서 모든 목적지까지 최단 거리 : 플로이드 워셜 - 3중 for 문


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static List<int[]>[] connectInfo;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        connectInfo = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            connectInfo[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            connectInfo[start].add(new int[]{end, value});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(letsGo(start, end));
    }

    private static int letsGo(int start, int end) {
        int answer = Integer.MAX_VALUE;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        //visited에 최솟값을 유지하면서 진행 -> 다익스트라
        q.add(new int[]{start, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == end) {
                return cur[1];
            }
            for (int i = 0; i < connectInfo[cur[0]].size(); i++) {
                int destination = connectInfo[cur[0]].get(i)[0];
                int weight = connectInfo[cur[0]].get(i)[1] + cur[1];
                if (visited[destination] > weight) {
                    visited[destination] = weight;
                    q.add(new int[]{destination, weight});
                }
            }
        }
        return -1;
    }
}
