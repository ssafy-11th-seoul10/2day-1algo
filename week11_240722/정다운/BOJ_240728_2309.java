package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2309 {

    static int[] hobit;
    static int[] combi;
    static boolean isContinue = false;
    static int[] res;

    public static void dfs(int depth, int start) {
        if(depth == 7) {

            int sum = 0;
            for(int j = 0; j < 7; j++)
                sum += combi[j];

            if(sum == 100 && !isContinue) {
                res = Arrays.copyOf(combi, 7);
                isContinue = true;
            }
            return;
        }

        for(int i = start; i < 9; i++) {

            combi[depth] = hobit[i];
            if(!isContinue) {
                dfs(depth + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        hobit = new int[9];
        combi = new int[7]; res = new int[7];

        for(int i = 0; i < 9; i++)
            hobit[i] = Integer.parseInt(br.readLine());

        dfs(0, 0);

        Arrays.sort(res);

        for(int i = 0; i < 7; i++)
            System.out.println(res[i]);
    }
}
