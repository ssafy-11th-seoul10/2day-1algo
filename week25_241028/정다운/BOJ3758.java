package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ3758 {

    static int TEST_CASE;
    static int N, K, T, M;
    static int[][][] team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TEST_CASE = Integer.parseInt(br.readLine());

        for(int t = 0; t < TEST_CASE; t++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            team = new int[N + 1][K + 1][3];
            int[][] scoreList = new int[N][4];

            for(int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());

                int id = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                team[id][problemNum][0] = Math.max(score, team[id][problemNum][0]);
                team[id][problemNum][1]++;
                team[id][problemNum][2] = j+1;
            }

            for(int i = 0; i < N; i++) {
                scoreList[i][3] = i+1;
                for(int j = 1; j <= K; j++) {
                    scoreList[i][0] += team[i+1][j][0];
                    scoreList[i][1] += team[i+1][j][1];
                    scoreList[i][2] = Math.max(scoreList[i][2], team[i+1][j][2]);
                }
            }

            Arrays.sort(scoreList, (int[] t1,int[] t2) -> {
                if(t1[0] == t2[0]) {
                    if(t1[1] == t2[1]) {
                        return t1[2] - t2[2];
                    }
                    return t1[1] - t2[1];
                }
                return t2[0] - t1[0];
            });

            for(int i = 0; i < N; i++) {
                System.out.println(scoreList[i][3] + " : score : " + scoreList[i][0] + ", cnt : " +
                        scoreList[i][1] + ", lastTime : " + scoreList[i][2]);
            }

            int answer = 0;

//            for(int i = 0; i < scoreList.length; i++) {
//                if(scoreList[i][3] == T) {
//                    answer = i;
//                    break;
//                }
//            }

            System.out.println(answer + 1);
        }
    }
}
