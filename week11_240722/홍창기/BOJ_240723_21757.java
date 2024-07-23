import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240723_21757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] prefixSum = new int[n];
        prefixSum[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            prefixSum[i] = Integer.parseInt(st.nextToken()) + prefixSum[i - 1];
        }

        long ans = 0;

        if (prefixSum[n - 1] == 0) {
            int zeroPointCnt = 0;

            for (int i = 0; i < n; i++) {
                if (prefixSum[i] == 0) {
                    zeroPointCnt++;
                }
            }

            ans = (long) (zeroPointCnt - 1) * (zeroPointCnt - 2) * (zeroPointCnt - 3) / 6;
        }
        else if (prefixSum[n - 1] % 4 == 0) {
            int partSum = prefixSum[n - 1] / 4;
            long[] cntDp = new long[4];
            cntDp[0] = 1;

            for (int i = 0; i < n; i++) {
                if (prefixSum[i] == partSum * 3) {
                    cntDp[3] += cntDp[2];
                }

                if (prefixSum[i] == partSum * 2) {
                    cntDp[2] += cntDp[1];
                }

                if (prefixSum[i] == partSum) {
                    cntDp[1] += cntDp[0];
                }
            }

            ans = cntDp[3];
        }

        System.out.println(ans);
        br.close();
    }

}
