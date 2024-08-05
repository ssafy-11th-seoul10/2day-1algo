import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int[] numberCnt = new int[222222];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            queue.add(x);
            numberCnt[x]++;
            while (numberCnt[x] > M) {
                numberCnt[queue.poll()]--;
            }
            answer = Math.max(answer, queue.size());
        }
        System.out.println(answer);
    }
}
