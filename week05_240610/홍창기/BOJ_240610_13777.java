import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240610_13777 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int low = 1;
            int high = 50;

            while (true) {
                int mid = (low + high) / 2;
                sb.append(mid).append(" ");

                if (n < mid) {
                    high = mid - 1;
                } else if (n > mid) {
                    low = mid + 1;
                } else {
                    break;
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
