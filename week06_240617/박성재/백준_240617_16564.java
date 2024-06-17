import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_240617_16564 {
    static int n;
    static int k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
        }

        Arrays.sort(arr);

        sb.append(BS());
        System.out.println(sb);
    }

    static int BS() {
        int left = arr[0];
        int right = left + k;
        int answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] < mid)
                    sum += (mid - arr[i]);
            }

            if (sum <= k) {
                answer = (int) mid;
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }

        return answer;
    }
}
