package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241022_2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int max = 0;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n ; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            max += arr[i];
        }

        int tc = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int num = Integer.parseInt(stk.nextToken());
            boolean[] d = new boolean[40001];
            d[0] = true;
            for (int i = 1; i <= n; i++) {
                int now = arr[i];
                //추 무게가 큰 쪽에 합하는 경우
                for (int j = max; j >=0 ; j--) {
                    if(d[j]) d[j+now] = true;
                }
                //추 무게가 작은 쪽에 합하는 경우
                for (int j = 0; j <= max; j++) {
                    if(d[j]) d[Math.abs(j-now)] = true;
                }
            }
            if(d[num]) sb.append("Y ");
            else sb.append("N ");
        }
        System.out.println(sb);
    }
}
