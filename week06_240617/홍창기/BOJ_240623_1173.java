import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240623_1173 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int minM = Integer.parseInt(st.nextToken());
        int maxM = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        if (minM + t > maxM) {
            System.out.println(-1);
            return;
        }

        int m = minM;
        int cnt = 0;

        while (n > 0) {
            cnt++;

            if (m + t <= maxM) {
                m += t;
                n--;
            } else {
                m -= r;

                if (m < minM) {
                    m = minM;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

}
