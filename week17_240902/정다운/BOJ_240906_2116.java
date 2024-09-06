package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2116 {

    static int N;
    static int[][] daiso;
    static int result = 0;

    static int[][] build;
    static int[][] rotate;

    // 주사위 밑면 - 윗면 매칭, 밑면을 토대로 윗면을 정하는 함수
    public static int matching(int bottom) {
        if(bottom == 0) return 5;
        if(bottom == 1) return 3;
        if(bottom == 2) return 4;

        if(bottom == 3) return 1;
        if(bottom == 4) return 2;
        if(bottom == 5) return 0;

        return -1;
    }

    // 주사위를 다 쌓았다면, 옆면의 max 값을 계속 더해서 정답값을 구하는 함수
    public static int calc() {

        int res = 0;

        for(int i = 0; i < N; i++) {
            int tmp = 0;
            for(int j = 0; j < 4; j++)
                tmp = Math.max(tmp, rotate[i][j]);
            res += tmp;
        }

        return res;
    }

    // 주사위를 쌓는 함수
    public static void buildDaiso(int idx, int prevDaiso) {
        // idx는 현재 쌓을 주사위고, prevDaiso는 꼭대기 주사위의 윗면 idx!!

        // 1. 현재 주사위의 밑면 & 윗면 결정 (IDX)
        int currDaisoBottom = 0; int currDaisoTop = 0;

        for(int i = 0; i < 6; i++) {
            if(daiso[idx-1][prevDaiso] == daiso[idx][i]) {
                currDaisoBottom = i;
                currDaisoTop = matching(i);
                break;
            }
        }

        build[idx][0] = daiso[idx][currDaisoBottom];
        build[idx][1] = daiso[idx][currDaisoTop];

        // 2. 주사위 옆면 기록하기
        int rotateIdx = 0;
        for(int j = 0; j < 6; j++) {
            if(j != currDaisoBottom && j != currDaisoTop) {
                rotate[idx][rotateIdx] = daiso[idx][j];
                rotateIdx++;
            }
        }

        if(idx == N - 1) {
            result = Math.max(result, calc());
            return;
        }

        buildDaiso(idx+1, currDaisoTop);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        daiso = new int[N][6];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 6; j++)
                daiso[i][j] = Integer.parseInt(st.nextToken());
        }

        // Implement
        // 가장 밑의 주사위에 대해..
        for(int i = 0; i < 6; i++) {

            build = new int[N][2];
            rotate = new int[N][4];

            int bottom = i;
            int top = matching(bottom);

            build[0][0] = bottom; build[0][1] = top;

            int oneDaisoRotateIdx = 0;
            for(int j = 0; j < 6; j++) {
                if(j != bottom && j != top) {
                    rotate[0][oneDaisoRotateIdx] = daiso[0][j];
                    oneDaisoRotateIdx++;
                }
            }

            buildDaiso(1, top);
        }

        // 출력하기
        System.out.println(result);
    }
}
