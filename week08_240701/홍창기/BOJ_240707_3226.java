import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240707_3226 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int t = Integer.parseInt(line.substring(0, 2)) * 60 + Integer.parseInt(line.substring(3, 5));
            int d = Integer.parseInt(line.substring(6, 8));

            if (t >= 1140) {
                ans += d * 5;
            } else if (t + d >= 1140) {
                ans += (t + d - 1140) * 5 + (1140 - t) * 10;
            } else if (t >= 420) {
                ans += d * 10;
            } else if (t + d >= 420) {
                ans += (t + d - 420) * 10 + (420 - t) * 5;
            } else {
                ans += d * 5;
            }
        }

        System.out.println(ans);
        br.close();
    }

}
