import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4097_240518 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int maxSum = Integer.parseInt(br.readLine());
            int curSum = maxSum;

            for (int i = 1; i < n; i++) {
                int x = Integer.parseInt(br.readLine());
                curSum = (curSum < 0 ? 0 : curSum) + x;
                maxSum = curSum > maxSum ? curSum : maxSum;
            }

            sb.append(maxSum).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
