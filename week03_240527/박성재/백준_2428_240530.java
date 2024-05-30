import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2428_240530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 0.9F(j) <= F(i) <= F(j)

        Arrays.sort(arr);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            int max = i; // 자기 자신

            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] * 9 <= arr[i] * 10) {
                    max = mid; // 조건에 맞는거 부합하면 max 최신화
                    left = mid + 1;
                } else
                    right = mid - 1;
            }
            answer += (max - i); // 누적으로 더해주고
        }

        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}
