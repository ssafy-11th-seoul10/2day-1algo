// https://stritegdc.tistory.com/363
// 해당 예제의 첫번째 접근과 비슷하게 하려 함 -> 시초 100%!
// 역방향 간선 그래프 아이디어!

// https://develop247.tistory.com/592
// start -> end graph // end -> start graph 2개를 생성
// 더 쉬운 예제 -> start 경로 정점 && end 경로 정점
package Softeer;

import java.io.*;
import java.util.*;

public class commute_way {

    static int N, M;
    static List<Integer>[] graph;
    static List<Integer>[] reverse_graph;

    static int home, company;

    // graph_traversal
    public static void dfs(int vertex, List<Integer>[] g, boolean[] visited) {

        visited[vertex] = true;

        for(int nextCity : g[vertex])
            if(!visited[nextCity])
                dfs(nextCity, g, visited);
    }

    public static void main(String[] args) throws IOException {
        // STEP 1. Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverse_graph = new ArrayList[N+1];

        for(int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            reverse_graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int str_idx = Integer.parseInt(st.nextToken());
            int end_idx = Integer.parseInt(st.nextToken());

            // ※ 아이디어 : 출근길, 퇴근길의 경로에서 모두 방문 하는 노드는 결국 양방향으로 이루어져 있어야 한다.
            graph[str_idx].add(end_idx);
            // ※ 테크닉 : 역방향 그래프
            // 역방향 그래프에서 t가 어떤 정점에 도달할 수 있다 == 해당 정점에서 t에 도달할 수 있다.
            // 목적지 -> 정점 -> 목적지로 되돌아 올 수 있는 정점을 구할 때 사용한다.
            reverse_graph[end_idx].add(str_idx);
        }

        st = new StringTokenizer(br.readLine());
        home = Integer.parseInt(st.nextToken());
        company = Integer.parseInt(st.nextToken());

        // STEP 2. 출근길 Set
        boolean[] v1 = new boolean[N + 1];
        v1[company] = true; // 목적지는 방문표시 -> 막아놓기
        dfs(home, graph, v1);

        // STEP 3. 퇴근길 Set
        boolean[] v2 = new boolean[N + 1];
        v2[home] = true; // 목적지는 방문표시 -> 막아놓기
        dfs(company, graph, v2);

        // STEP 4. 역방향 그래프 Set
        boolean[] v3 = new boolean[N + 1];
        dfs(home, reverse_graph, v3);

        boolean[] v4 = new boolean[N + 1];
        dfs(company, reverse_graph, v4);

        // STEP 5. 출 퇴근 공통 요소 count
        int count = 0;

        for(int i = 1; i < N + 1; i++)
            if(v1[i] && v2[i] && v3[i] && v4[i]) {
                //System.out.println(i);
                count++;
            }
        // home, company 는 빼기
        System.out.println(count - 2);
    }
}
