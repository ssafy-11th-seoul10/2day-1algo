import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_240614_1043 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowPeopleCount = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수

        for (int i = 0; i < knowPeopleCount; i++) {
            int num = Integer.parseInt(st.nextToken());
            union(num, 0);
        }

        ArrayList<Integer>[] adjList = new ArrayList[m];

        for (int i = 0; i < m; i++) {
            adjList[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            int people = Integer.parseInt(st.nextToken()); // 파티 오는 사람 수

            int num = Integer.parseInt(st.nextToken());
            adjList[i].add(num);
            for (int j = 0; j < people - 1; j++) {
                int next = Integer.parseInt(st.nextToken());
                union(num, next);
                adjList[i].add(next);
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = false;
            ArrayList<Integer> list = adjList[i];

            for (int j = 0; j < list.size(); j++) {
                int num = list.get(j);

                if (find(num) == 0)
                    flag = true;
            }

            if (flag) {
                for (int j = 0; j < list.size(); j++) {
                    int num = list.get(j);
                    union(num, 0);
                }
            } else
                answer++;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x < y)
            parents[y] = x;
        else
            parents[x] = y;
    }

    static int find(int a) {
        if (parents[a] == a)
            return a;

        return parents[a] = find(parents[a]);
    }
}
