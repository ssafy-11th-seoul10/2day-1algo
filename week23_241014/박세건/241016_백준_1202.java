배열이나 리스트를 탐색할때 한번 탐색했던 경우를 다시 반복하지 않기 위해서 DP를 사용해서 해결할 수 있다.
때문에 배낭문제 분류를 DP로 해결하곤 한다.
하지만 한번 탐색했던 값들의 최대, 최소를 찾기위해서는 우선순위큐를 사용할 수 있다.
계속해서 최대값 or 최소값을 뽑아내야되는 경우 우선순위큐를 생각하자

---

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N, K;

    private static int[][] jewels;
    private static int[] bags;

    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        inputSetting();
        solution();
        System.out.println(answer);
    }

    private static void solution() {

        Arrays.sort(jewels, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return -(o1[1] - o2[1]);
            }
            return o1[0] - o2[0];
        }));
        Arrays.sort(bags);

        int jewelIdx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < K; i++) {
            while (jewelIdx < jewels.length && jewels[jewelIdx][0] <= bags[i]) {
                pq.add(jewels[jewelIdx][1]);
                jewelIdx++;
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
    }

    private static void inputSetting() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewels = new int[N][2];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i][0] = weight;
            jewels[i][1] = value;
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
    }

}
