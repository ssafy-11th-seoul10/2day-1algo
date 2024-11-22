package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_241122_7795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(stk.nextToken());
            }

            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(stk.nextToken());
            }

            int answer = 0;
            Arrays.sort(arr1);

            for (int i = 0; i < m; i++) {
                int now = arr2[i];
                int start = 0;
                int end = n;

                //Upper Bound
                while (start < end) {
                    int mid = (start + end) / 2;
                    int num = arr1[mid];

                    if (num <= now) {
                        start = mid+1;
                    } else {
                        end = mid;
                    }
                }
                int rightIdx = start;
                answer += n-rightIdx;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
