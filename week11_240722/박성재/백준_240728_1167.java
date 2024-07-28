import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_240728_1167 {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

    }

    static int N;
    static ArrayList<Edge>[] adjList;
    static boolean[] visited;
    static int answer;
    static int maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int b;
            while ((b = Integer.parseInt(st.nextToken())) != -1) {
                int c = Integer.parseInt(st.nextToken());
                adjList[num].add(new Edge(b, c));
                adjList[b].add(new Edge(num, c));
            }
        }

        visited = new boolean[N + 1];
        answer = 0;
        maxNode = 0;
        dfs(1, 0);

        visited = new boolean[N + 1];
        answer = 0;
        dfs(maxNode, 0);

        sb.append(answer).append("\n");
        System.out.println(sb);

    }

    static void dfs(int now, int sum) {
        if (visited[now])
            return;
        visited[now] = true;

        if (sum > answer) {
            answer = sum;
            maxNode = now;
        }
        for (int i = 0; i < adjList[now].size(); i++) {
            Edge next = adjList[now].get(i);

            dfs(next.to, sum + next.weight);
        }
    }
}
