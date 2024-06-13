import java.util.*;

class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;
    private int answer = 101, cnt1, cnt2;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) 
            graph[i] = new ArrayList<>();
        visited = new boolean[n + 1];
        
        for (int i = 0; i < wires.length; i++) {
            makeGraph(i, n, wires); // 하나씩 연결 끊고
            // debugPrint();
            cnt1 = 0; cnt2 = 0;
            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;
                dfs(j, n, false);
                break;
            }
            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;
                dfs(j, n, true);
                break;
            }
            // System.out.println(cnt1 + " " + cnt2);
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));
            // visited 초기화
            for (int j = 1; j <= n; j++)
                visited[j] = false;
        }
        
        return answer;
    }
    
    private void dfs(int idx, int n, boolean flag) {
        if (flag == false) cnt1++;
        else cnt2++;
        
        visited[idx] = true;
        for (int i = 0; i < graph[idx].size(); i++) {
            if (!visited[graph[idx].get(i)] ) {
                dfs(graph[idx].get(i), n, flag);
            }
        }
    }
    
    private void makeGraph(int idx, int n, int[][] wires) {
        for (int i = 1; i <= n; i++) 
            graph[i].clear();
        for (int i = 0; i < wires.length; i++) {
            if (i == idx) continue;
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
    }
    
    private void debugPrint() {
        for (int i = 1; i < graph.length; i++)
            System.out.println(graph[i]);
    }
}
