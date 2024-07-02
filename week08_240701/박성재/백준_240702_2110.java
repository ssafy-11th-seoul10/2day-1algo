import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_240702_2110 {
    static int N;
    static int C;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // N : 2 ~ 200_000
        // C : 0 ~ 1_000_000_000
        Arrays.sort(arr);
        answer = 0;
        bs();
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void bs() {
        int left = 0;
        int right = arr[N - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            int now = arr[0];
            int count = 1;

            for (int i = 1; i < N; i++) {
                if (arr[i] - now >= mid) {
                    count += 1;
                    now = arr[i];
                }
            }

            if (count >= C) {
                answer = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
    }
}
