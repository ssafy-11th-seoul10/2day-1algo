package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2467 {

    static int N;
    static int result;
    static int[] liquid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        liquid = new int[N];

        for(int i = 0; i < N; i++)
            liquid[i] = Integer.parseInt(st.nextToken());


        int left = 0; int right = N - 1;
        int res1 = left; int res2 = right;

        result = Math.abs(liquid[left] + liquid[N - 1]);

        while (left < right) {

            int tmp = liquid[left] + liquid[right];

            if(Math.abs(tmp) < result) {
                result = Math.abs(tmp);
                res1 = left; res2 = right;
            }

            if(tmp > 0)
                right--;
            else if (tmp < 0)
                left++;
            else {
                res1 = left;
                res2 = right;
                break;
            }
        }

        System.out.println(liquid[res1] + " " + liquid[res2]);
    }
}
