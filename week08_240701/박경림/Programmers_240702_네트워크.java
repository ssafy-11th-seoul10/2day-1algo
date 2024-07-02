class Solution {
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
    
    private void dfs(int n, int[][] computers) {
        visited[n] = true;
        
        for (int i = 0; i < computers[n].length; i++) {
            if (i == n) continue;
            if (computers[n][i] == 1 && visited[i] == false) {
                dfs(i, computers);
            }
        }
    }
}
