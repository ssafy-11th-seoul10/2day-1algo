package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1976 {

    static int N, M;
    static int[][] cities;
    static boolean[] visited;

    static Set<Integer> trip_plan;
    static List<List<Integer>> groups;

    public static void bfs(int start) {

        List<Integer> plans = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(start);
        visited[start] = true;
        plans.add(start);

        while (!queue.isEmpty()) {

            int city = queue.poll();

            for(int next_city = 1; next_city < N + 1; next_city++) {

                int road = cities[city][next_city];

                if(road == 1 && !visited[next_city]) {
                    queue.add(next_city);
                    visited[next_city] = true;
                    plans.add(next_city);
                }
            }
        }
        groups.add(plans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // <= 200
        M = Integer.parseInt(br.readLine()); // <= 1000

        cities = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j < N + 1; j++)
                cities[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        trip_plan = new TreeSet<>();
        groups = new ArrayList<>();

        while (st.hasMoreTokens())
            trip_plan.add(Integer.parseInt(st.nextToken()));

        // STEP 2. make groups
        for(int city = 1; city < N + 1; city++) {
            if(!visited[city]) {
                bfs(city);
            }
        }

//        System.out.println("여행 계획 : " + trip_plan.toString());
//        for(Set group : groups)
//            System.out.println("그룹 출력 : " + group.toString());

        boolean flag = false;

        for(List group : groups) {
            if(group.containsAll(trip_plan)) {
                flag = true;
                break;
            }
        }

        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
