import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_240625_16401 {
    static int n;
    static int m;
    static int[] cookies;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        cookies = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(st.nextToken());
            cookies[i] = len;
        }
        Arrays.sort(cookies);

        answer = 0;
        bs();
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void bs() {
        int left = 1;
        int right = cookies[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 0; i < n; i++) {
                count += cookies[i] / mid;
            }

            if (count >= m) {
                left = mid + 1;
                answer = mid;
            } else
                right = mid - 1;
        }
    }
}
