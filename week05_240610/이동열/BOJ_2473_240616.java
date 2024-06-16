import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long min = 4_000_000_001L;
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        for (int i = 0; i < N - 2; i++) { // N-2까지 반복
            int front = i + 1;
            int back = N - 1;
            while (front < back) {
                long sum = (long)arr[i] + arr[front] + arr[back];
                long absSum = Math.abs(sum);
                if (absSum < min) {
                    min = absSum;
                    answer1 = arr[i];
                    answer2 = arr[front];
                    answer3 = arr[back];
                }
                if (sum < 0) {
                    front++;
                } else {
                    back--;
                }
            }
        }
        int[] result = {answer1, answer2, answer3};
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}