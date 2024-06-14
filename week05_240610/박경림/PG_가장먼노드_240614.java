import java.util.*;

class Solution {
    private List<Integer>[] graph;
    private int[] dist;
    private int maxCnt;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        bfs();
        // System.out.println(Arrays.toString(dist));
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxCnt) answer++;
        }
        return answer;
    }
    
    private void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {1, 0});
        dist[1] = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int idx = temp[0];
            
            for (int i = 0; i < graph[idx].size(); i++) {
                int node = graph[idx].get(i);
                if (dist[node] > temp[1] + 1) {
                    dist[node] = temp[1] + 1;
                    q.add(new int[] {node, temp[1] + 1});
                    maxCnt = Math.max(maxCnt, temp[1] + 1);
                }
            }
        }
    }
}
