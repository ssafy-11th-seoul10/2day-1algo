package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2503 {

    static int N;

    static int[] numbers;
    static int[][] game;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        game = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            numbers[i] = Integer.parseInt(st.nextToken());

            game[i][0] = Integer.parseInt(st.nextToken());
            game[i][1] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for(int one = 1; one < 10; one++)
            for(int two = 1; two < 10; two++)
                for(int three = 1; three < 10; three++) {

                if(one != two && two != three && one != three) {
                    boolean flag = true;
                    // 해당 숫자 <-> number와 비교
                    for (int i = 0; i < N; i++) {

                        // 계산
                        int strike = 0;
                        int ball = 0;

                        int[] tmp = new int[3];

                        String strNum = String.valueOf(numbers[i]);
                        int[] number = new int[3];

                        for (int k = 0; k < 3; k++)
                            number[k] = strNum.charAt(k) - '0';

                        tmp[0] = one;
                        tmp[1] = two;
                        tmp[2] = three;
                        boolean[] visited = new boolean[3];

                        for (int idx = 0; idx < 3; idx++)
                            for (int jdx = 0; jdx < 3; jdx++) {
                                if (!visited[jdx]) {
                                    if (tmp[idx] == number[jdx]) {
                                        if (idx == jdx)
                                            strike++;
                                        else
                                            ball++;

                                        visited[jdx] = true;
                                    }

                                }
                            }

                        // 해당 strike & ball 과 같으면 continue
                        if (strike != game[i][0] || ball != game[i][1]) {
                            flag = false;
                            break;
                        }

                    }

                    if (flag)
                        count++;

                    }
                }

        System.out.println(count);
    }
}
