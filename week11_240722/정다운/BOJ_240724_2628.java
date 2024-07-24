package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2628 {

    static int N, M;
    static List<int[]> position;

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N + 1) && (0 <= y && y < M + 1);
    }

    public static boolean check(int start_idx, int x, int y) {
        for(int i = 0; i < position.size(); i++) {
            if(i == start_idx)
                continue;

            if (position.get(i)[0] == x && position.get(i)[1] == y)
                return true;
        }
        return false;
    }

    static List<Integer> garo; static List<Integer> sero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        position = new ArrayList<>();

        garo = new ArrayList<>();
        garo.add(0); garo.add(M);
        sero = new ArrayList<>();
        sero.add(0); sero.add(N);

        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if(dir == 0)
                garo.add(pos);
            else
                sero.add(pos);
        }

        // 시작지점 모두 구하기
        for(int s : sero)
            for(int g : garo)
                position.add(new int[] {s, g});

        // 계산하기
        int width = 0;

        for(int i = 0; i < position.size(); i++) {

            int x = position.get(i)[0]; int y = position.get(i)[1];

            int gy = y;
            int gLen = 0;
            while (inRange(x, gy) && !check(i, x, gy)) {
                gy++;
                gLen++;
            }

            int sx = x;
            int sLen = 0;
            while (inRange(sx, y) && !check(i, sx, y)) {
                sx++;
                sLen++;
            }

            //System.out.println(x + " : " + y + " = " + gLen + " : " + sLen );

            width = Math.max(width, gLen * sLen);
        }

        System.out.println(width);
    }
}
