package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241120_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        long z = y*100L / x;
        int start = 1;
        int end = 1_000_000_000;
        int answer = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start+end)/2;
            long now = (y+mid)*100L/(x+mid);
            if(now>z){
                answer = Math.min(answer, mid);
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        if(answer==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
}
