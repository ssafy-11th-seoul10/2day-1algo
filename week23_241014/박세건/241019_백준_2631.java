import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    private static long answer = 0;
    private static int[] arr;
    private static int N;

    private static int[] dp;

    public static void main(String[] args) throws IOException {
        inputSetting();
        for (int i = 0; i < N; i++) {
            /*
             *   dp배열을 탐색하면서 현재 값이 어디에 들어가야하는지 확인
             * */
            setDp(arr[i]);
        }
        for (int i = 1; i < N + 1; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                System.out.println(N - i + 1);
                break;
            }
        }

    }

    private static void setDp(int value) {
        int start = 0;
        int end = N;
        while (start < end) {
//            System.out.println(start + " " + end);
            int mid = (start + end) / 2;
            if (value < dp[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        dp[end] = Math.min(value, dp[end]);
    }

    private static void inputSetting() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

    }
}
