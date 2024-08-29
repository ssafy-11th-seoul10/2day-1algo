import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M, L, K;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new int[]{x, y});
        }
        points.sort(Comparator.comparing(a -> a[0]));
        Queue<int[]> queue = new LinkedList<>();
        queue.add(points.get(0));
        for (int i = 1; i < points.size(); i++) {
            if (!queue.isEmpty() && points.get(i)[0] - queue.peek()[0] > L) {
                int maxCnt = getMaxCnt(queue);
                answer = Math.min(K - maxCnt, answer);
                while (!queue.isEmpty() && points.get(i)[0] - queue.peek()[0] > L) {
                    queue.poll();
                }
            }
            queue.add(points.get(i));
        }
        //마지막으로 쌓여있는 큐 확인
        int maxCnt = getMaxCnt(queue);
        answer = Math.min(K - maxCnt, answer);
        System.out.println(answer);
    }

    private static int getMaxCnt(Queue<int[]> values) {
        int sum = 0;
        for (int[] value1 : values) {
            int cnt = 0;
            for (int[] value2 : values) {
                if (0 <= value1[1] - value2[1] && value1[1] - value2[1] <= L) {
                    cnt++;
                }

            }
            sum = Math.max(sum, cnt);
        }
//        for (int[] value : values) {
//            System.out.println(value[0] + " " + value[1]);
//        }
//        System.out.println(sum);
        return sum;
    }
}
