class PG_전력망을둘로나누기_240820 {

    static void dfs(int node){

        for (int i = 1; i <=m ; i++) {
            if(edges[node][i]&&!visit[i]){
                visit[i] = true;
                count++;
                dfs(i);
            }
        }
    }

    static boolean[] visit;
    static boolean[][] edges;
    static int m, count;

    public int solution(int n, int[][] wires) {
        m = n;
        edges = new boolean[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            int first = wires[i][0];
            int second = wires[i][1];
            edges[first][second] = true;
            edges[second][first] = true;
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int first = wires[i][0];
            int second = wires[i][1];
            edges[first][second] = false;
            edges[second][first] = false;

            visit = new boolean[n + 1];
            visit[1] = true;
            count = 1;
            dfs(1);
            int count1 = count;
            count = 1;
            for (int j = 2; j <=n ; j++) {
                if(!visit[j]){
                    visit[j] = true;
                    dfs(j);
                    break;
                }
            }
            int count2 = count;

            answer = Math.min(answer, Math.abs(count1 - count2));

            edges[first][second] = true;
            edges[second][first] = true;

        }
        return answer;
    }
}