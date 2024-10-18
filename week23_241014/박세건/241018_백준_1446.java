import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N, D;

    private static int answer;
    private static int[] distance;
    private static HashMap<Integer, List<int[]>> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        inputSetting();
        bfs();
//        List<int[]> connInfo = hashMap.get(0);
//        for (int[] tmp : connInfo) {
//            System.out.println(tmp[0] + " " + tmp[1]);
//        }
//        for (int i = 0; i <= D; i++) {
//            System.out.println(i + " " + distance[i]);
//        }
        System.out.println(distance[D]);
    }

    private static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{0, 0});
        distance[0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
//            System.out.println(cur[0] + " " + cur[1]);
            if (distance[cur[0]] < cur[1]) {
//                System.out.println("laskdjf");
                continue;
            }
            if (hashMap.containsKey(cur[0])) {
//                System.out.println(cur[0]);
                List<int[]> connInfo = hashMap.get(cur[0]);
                for (int i = 0; i < connInfo.size(); i++) {
                    int nextPoint = connInfo.get(i)[0];
                    int nextDistance = connInfo.get(i)[1];
                    int totalDistance = cur[1] + nextDistance;
//                    System.out.println("laksdjflkasjdf");
                    if (nextPoint <= D && distance[nextPoint] > totalDistance) {
                        distance[nextPoint] = totalDistance;
                        pq.add(new int[]{nextPoint, totalDistance});
                    }
                }
            }
            if (cur[0] + 1 <= D && distance[cur[0] + 1] >= cur[1] + 1) {
                distance[cur[0] + 1] = cur[1] + 1;
                pq.add(new int[]{cur[0] + 1, cur[1] + 1});
            }
        }
    }

    private static void inputSetting() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        distance = new int[D + 1];
        for (int i = 0; i < D + 1; i++) {
            distance[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (!hashMap.containsKey(s)) {
                hashMap.put(s, new ArrayList<>());
            }
            hashMap.get(s).add(new int[]{e, d});
        }
    }
}
