package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_241122_3020 {

    static int countWall(int[] arr, int findNum) {
        int start = 0;
        int end = arr.length;

        // Lower Bound
        while (start < end) {
            int mid = (start+end)/2;
            int num = arr[mid];

            if (num >= findNum) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr.length - start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());
        int[] down = new int[n/2];
        int[] up = new int[n/2];
        for (int i = 0; i < n/2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int answer = 200000;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            int now = countWall(down, i) + countWall(up, h-i+1);
            if(now<answer){
                answer = now;
                cnt = 1;
            } else if (now == answer) {
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append(" ").append(cnt);
        System.out.println(sb);
    }
}
