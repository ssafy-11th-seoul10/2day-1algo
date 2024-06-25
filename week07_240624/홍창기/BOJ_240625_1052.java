import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240625_1052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        while (k > 1 && n != 0) {
            if (n <= k) {
                System.out.println(0);
                br.close();
                return;
            }

            int x = 1;

            while (x <= n) {
                x <<= 1;
            }

            x >>= 1;
            n ^= x;
            k--;
        }

        if (n <= k) {
            System.out.println(0);
            br.close();
            return;
        }

        int x = 1;

        while (x < n) {
            x <<= 1;
        }

        System.out.println(x - n);
        br.close();
    }

}
