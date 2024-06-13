import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_240613_15886 {
    static int n;
    static ArrayList<Integer>[] adjList;
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                adjList[i].add(i + 1);
                adjList[i + 1].add(i);
            } else if (s.charAt(i) == 'W') {
                adjList[i].add(i - 1);
                adjList[i - 1].add(i);
            }
        }

        answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void bfs(int start) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        visited[start] = true;
        deque.addLast(start);

        while (!deque.isEmpty()) {
            int now = deque.pollFirst();

            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    deque.addLast(next);
                }
            }
        }
    }
}
