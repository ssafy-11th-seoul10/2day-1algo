import java.io.*;
import java.util.*;

public class Main {
    private static int start, end, cnt, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (end < n) {
            // cnt: 현재 윈도우 내에서 삭제한 홀수의 개수
            if (cnt > k) {
                if (arr[start++] % 2 == 1) {
                    cnt--;
                }
            } else {
                if (arr[end++] % 2 == 1) {
                    cnt++;
                }
                result = Math.max(result, end - start - cnt);
            }
        }

        System.out.println(result);
    }
}
