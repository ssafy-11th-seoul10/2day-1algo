import java.util.*;

class Solution {
    private int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 987654321;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1});
        maps[0][0] = -1;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == n-1 && temp[1] == m-1) {
                answer = Math.min(answer, temp[2]);
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || maps[nr][nc] != 1) 
                    continue;
                
                maps[nr][nc] = -1;
                q.add(new int[] {nr, nc, temp[2] + 1});
            }
        }
        
        if (answer == 987654321) answer = -1;
        return answer;
    }
}
