package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_241121_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr1 = new int[n];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(stk.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] arr2 = new int[m];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(arr1);

            for (int i = 0; i < m; i++) {
                int findNum = arr2[i];
                int start = 0;
                int end = n-1;
                boolean isExist = false;
                while (start <= end) {
                    int mid = (start+end)/2;
                    int now = arr1[mid];
                    if(now>findNum){
                        end = mid - 1;
                    } else if(now<findNum){
                        start = mid + 1;
                    } else {
                        isExist = true;
                        break;
                    }
                }
                if(isExist) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
