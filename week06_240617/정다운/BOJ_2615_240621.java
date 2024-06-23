package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2615 {

    static int[][] board;
    static boolean[][] visited;
    // // 5개 이상의 라인 -> 아예 제외 해야만 함
    // 안하면, 5개에 무조건 출력할 수 밖에 없음

    static int x, y, color;

    static int[] dx = {-1,0,1,1};
    static int[] dy = {1,1,1,0};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < 19) && (0 <= y && y < 19);
    }

    // 진행 방향 중, 사이에 낀 거
    public static boolean isNotHead(int x, int y, int dir, int color) {

        int head_x = 0; int head_y = 0;
        int tail_x = 0; int tail_y = 0;

        if(dir == 0) {
            head_x = x + 1; head_y = y - 1;
            tail_x = x - 1; tail_y = y + 1;
        }
        else if(dir == 1) {
            head_x = x; head_y = y - 1;
            tail_x = x; tail_y = y + 1;
        }
        else if (dir == 2) {
            head_x = x - 1; head_y = y - 1;
            tail_x = x + 1; tail_y = y + 1;
        }
        else {
            head_x = x - 1; head_y = y;
            tail_x = x + 1; tail_y = y;
        }

        if(inRange(head_x, head_y) && inRange(tail_x, tail_y) &&
                board[head_x][head_y] == color && board[tail_x][tail_y] == color)
            return false;

        return true;
    }

    public static boolean check(int x, int y, int color) {

        for(int i = 0; i < 4; i++) {

            int cnt = 1;
            // 사이에 낀 오목알은 그냥 제외 시키기
            if(!isNotHead(x, y, i, color))
                continue;

            int st_x = x; int st_y = y;
            int nx = st_x + dx[i]; int ny = st_y + dy[i];

            while(inRange(nx, ny) && board[nx][ny] == color) {
                cnt++;

                st_x = nx; st_y = ny;
                nx = st_x + dx[i]; ny = st_y + dy[i];
            }

            if(cnt == 5)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[19][19];
        visited = new boolean[19][19];

        for(int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 19; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        x = -1; y = -1; color = -1;
        boolean flag = false;

        outer : for(int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    //System.out.println((i+1) + " ++ " + (j+1));
                    if (check(i, j, board[i][j])) {
                        x = i + 1;
                        y = j + 1;
                        color = board[i][j];
                        flag = true;
                        break outer;
                    }
                }
            }
        }

        if(flag){
                System.out.println(color);
                System.out.println(x + " " + y);
            }
        else
            System.out.println(0);

    }
}
