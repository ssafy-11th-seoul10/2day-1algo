g-h를 탐색했을때에 flag를 설정해서 저장하도록 구현한 방식 => 메모리 초과
해당 방식은 g-h를 지나서 최단경로를 만들어낸 경로와 지나지 않고 최단경로를 만들어낸 경로의 길이가 일치하는 경우를 확인하기 위해
distance를 업데이트 시켜주는 코드를 distance에 저장된 정보와 길이가 같은 경우도 pq에 저장되도록 풀어줘야한다(원래는 distance에 저장된 길이보다 작은 경우만 업데이트 가능)
때문에 distance에 저장된 길이와 같은 경로가 pq에 계속해서 저장되기때문에 메모리 초과 or 시간초과 발생

---

s->g + g->h + h->t 방식으로 해결  

  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int T, n, m, t, s, g, h;

    private static List<int[]>[] connInfo;

    private static Set<Integer> destinations;

    private static List<Integer> answers;

    private static int[] distanceS;
    private static int[] distanceG;
    private static int[] distanceH;

    private static int distanceGH;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            testCase();
        }
        System.out.println(sb.toString());
    }

    private static void testCase() throws IOException {
        inputSetting();
        dijkstra(s, distanceS);
        dijkstra(g, distanceG);
        dijkstra(h, distanceH);
//        System.out.println(Arrays.toString(distanceS));
//        System.out.println(Arrays.toString(distanceG));
//        System.out.println(Arrays.toString(distanceH));
//        System.out.println();
        for (int destination : destinations) {
//            System.out.println(destination);
            if (distanceS[destination] == distanceS[g] + distanceGH + distanceH[destination]) {
                answers.add(destination);
            }
            if (distanceS[destination] == distanceS[h] + distanceGH + distanceG[destination]) {
                answers.add(destination);
            }
        }
        Collections.sort(answers);

        for (Integer answer : answers) {
            sb.append(answer).append(" ");
        }
        sb.append("\n");
    }


    private static void dijkstra(int start, int[] distance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((o) -> o[1]));
        pq.add(new int[]{start, 0}); //[시작점, 총 길이, 특정 도로를 지났는지 여부]
        distance[start] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
//            if (distance[cur[0]] < cur[1]) {
//                continue;
//            }
            for (int i = 0; i < connInfo[cur[0]].size(); i++) {
                int[] next = connInfo[cur[0]].get(i);
                int totalDistance = cur[1] + next[1];
                if (distance[next[0]] > totalDistance) {
                    distance[next[0]] = totalDistance;
                    pq.add(new int[]{next[0], totalDistance});
                }
            }
        }
    }

    private static void inputSetting() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        distanceS = new int[n + 1];
        distanceG = new int[n + 1];
        distanceH = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            distanceS[i] = Integer.MAX_VALUE;
            distanceG[i] = Integer.MAX_VALUE;
            distanceH[i] = Integer.MAX_VALUE;
        }
        connInfo = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            connInfo[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            connInfo[a].add(new int[]{b, d});
            connInfo[b].add(new int[]{a, d});
            if ((a == g && b == h) || (a == h && b == g)) {
                distanceGH = d;
            }
        }
        destinations = new HashSet<>();
        for (int i = 0; i < t; i++) {
            destinations.add(Integer.parseInt(br.readLine()));
        }
        answers = new ArrayList<>();
    }

}
