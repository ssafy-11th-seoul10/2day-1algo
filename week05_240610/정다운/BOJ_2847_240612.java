package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2847 {

    static int N;
    static int[] level_score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        level_score = new int[N];

        for(int i = 0; i < N; i++)
            level_score[i] = Integer.parseInt(br.readLine());

        //Greedy
        int value = 0;
        int temp = -1;

        for(int i = N - 1; i > -1; i--) {
            if(i == N - 1)
                temp = level_score[N-1];

            else {
                // 항상 답이 존재하는 경우만 주어짐 -> p, p+1, ... p + N - 1
                // 맨 뒤에서 탐색하면서 오름차순으로 만드는 것이 최적해를 보장한다. = Greedy
                if(temp <= level_score[i]) {
                    int tmp = (level_score[i] + 1) - temp;

                    //System.out.println(i + "st temp : " + temp + ", score : " + level_score[i] + " - " + tmp);
                    value += tmp;

                    level_score[i] -= tmp;
                }
                temp = level_score[i];
            }
        }
        //System.out.println(Arrays.toString(level_score));
        System.out.println( value);
    }
}
