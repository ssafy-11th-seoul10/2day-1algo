package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ11559 {

    static char[][] board;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static boolean inRange(int x, int y) {
        return (0 <= x && x <12) && (0 <= y && y < 6);
    }

    // 모든 뿌요를 밑으로 내리기
    public static void downPuyo() {

        for(int x = 10; x > -1; x--) {

            for(int y = 0; y < 6; y++) {
                if (board[x][y] != '.') {

                    char color = board[x][y];
                    board[x][y] = '.';
                    int nx = x;

                    while (inRange(nx + 1, y) && board[nx + 1][y] == '.')
                        nx += 1;

                    board[nx][y] = color;
                }
            }

        }
    }

    // 뿌요 부수기
    public static boolean destoryPuyo(int x, int y, char color) {

        Queue<int[]> queue = new ArrayDeque<>();

        visited[x][y] = true;
        queue.add(new int[]{x, y});

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{x, y});
        int cnt = 1;

        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curX = cur[0]; int curY = cur[1];


            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i]; int ny = curY + dy[i];

                if(inRange(nx, ny) && board[nx][ny] == color && !visited[nx][ny]) {

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    list.add(new int[]{nx, ny});
                    cnt++;
                }
            }
        }

        if(cnt >= 4) {
            for(int[] pos : list)
                board[pos[0]][pos[1]] = '.';

            return true;
        }

        return false;
    }

    public static void printBoard() {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 6; j++)
                sb.append(board[i][j]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[12][6];

        for(int i = 0; i < 12; i++) {
            String s = br.readLine();

            for(int j = 0; j < 6; j++)
                board[i][j] = s.charAt(j);
        }

        int result = 0;

        while (true) {

            boolean isContinue = false;
            visited = new boolean[12][6];

//            System.out.println("Before");
//            printBoard();

            for(int i = 0; i < 12; i++)
                for(int j = 0; j < 6; j++)
                    if(board[i][j] != '.' && !visited[i][j]) {
                        boolean tmp = destoryPuyo(i, j, board[i][j]);

                        if(tmp)
                            isContinue = true;
                    }

//            System.out.println("After");
//            printBoard();

            if(isContinue) {
                result++;
                downPuyo();
            }
            else
                break;
        }

        System.out.println(result);
    }
}
