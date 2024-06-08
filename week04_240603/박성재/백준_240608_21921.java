import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_240608_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        max = sum;

        for (int i = x; i < n; i++) {
            sum -= arr[i - x];
            sum += arr[i];

            max = Math.max(max, sum);
        }

        if (max == 0) {
            sb.append("SAD").append("\n");
            System.out.println(sb);
            return;
        }

        int answer = 0;
        sum = 0;

        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        if (sum == max)
            answer++;

        for (int i = x; i < n; i++) {
            sum -= arr[i - x];
            sum += arr[i];

            if (max == sum)
                answer++;
        }

        sb.append(max).append("\n");
        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}
