import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240716_14265 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long k = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if (k == 0) {
            System.out.println(b - a + 1);
            br.close();
            return;
        }

        long aa = k;
        long bb = k % 2 == 1 ? k : (k + 1);
        long cnt = 0;

        while (aa <= b) {
            long curCnt = Math.min(b, bb) - Math.max(a, aa) + 1;

            if (curCnt > 0) {
                cnt += curCnt;
            }

            aa = aa * 2;
            bb = bb * 2 + 1;
        }

        System.out.println(cnt);
        br.close();
    }

}
