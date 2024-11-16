import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int r, c, answer;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        r = land.length;
        c = land[0].length;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (land[i][j] == 1) {
                    bfs(land, i, j);
                }
            }
        }        
        
        for (List<Integer> list : map.values()) {
            int size = 0;
            for (Integer i : list) {
                size += i;
            }
            answer = Math.max(answer, size);
        }
        
        return answer;
    }
    
    void bfs(int[][] land, int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        land[x][y] = 0;
        q.add(new int[] {x, y});
        int result = 1;
        Set<Integer> col = new HashSet<>();
        col.add(y);
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];
                
                if (nr < 0 || nr >= r || nc < 0 || nc >= c || land[nr][nc] == 0) 
                    continue;
                
                q.add(new int[] {nr, nc});
                land[nr][nc] = 0;
                col.add(nc);
                result++;
            }
        }
        
        for (Integer c : col) {
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(result);
        }
    }
}
