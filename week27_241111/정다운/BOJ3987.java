package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ3987 {

    static int N, M;
    static char[][] board;

    static int settle_x, settle_y;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[] myDir = {'U', 'R', 'D', 'L'};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }

    public static int[] planet(int x, int y, int dir) {

        if(board[x][y] == '\\')  {
//            System.out.println("hello to " + x + " : " + y + ", " + dir);
            if(dir == 0)
                return new int[] {x, y-1, 3};
            if(dir == 1)
                return new int[] {x+1, y, 2};
            if(dir == 2)
                return new int[] {x, y+1, 1};
            else
                return new int[] {x-1, y, 0};
        }

        if(board[x][y] == '/')  {
//            System.out.println("hello to " + x + " : " + y + ", " + dir);
            if(dir == 0)
                return new int[] {x, y+1, 1};
            if(dir == 1)
                return new int[] {x-1, y, 0};
            if(dir == 2)
                return new int[] {x, y-1, 3};
            else
                return new int[] {x+1, y, 2};
        }

        return new int[]{x, y, -1};
    }

    public static int bfs(int x, int y, int dir) {

        int[][][] visited = new int[N][M][4];
        visited[x][y][dir] = 1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y, dir, 1});

        int cnt = 1;

        while(!queue.isEmpty()) {

            int[] curPos = queue.poll();

            int curX = curPos[0], curY = curPos[1];
            int curDir = curPos[2]; int curCnt = curPos[3];

            if(!inRange(curX, curY) || board[curX][curY] == 'C')  {
                cnt = curCnt;
                break;
            }

            if(visited[curX][curY][curDir] == 0)
                visited[curX][curY][curDir] = 1;
            else {
                // 첫 시작이 아닌 경우 -> 중간에서 visited -> cycle!
                if(curCnt != 1 && board[curX][curY] == '.') {
                    cnt = Integer.MAX_VALUE;
                    break;
                }
            }

            if(board[curX][curY] == '\\' || board[curX][curY] == '/') {
                int[] changePos = planet(curX, curY, curDir);

                int[] nextPos = new int[4];
                nextPos[3] = curCnt + 1;
                for(int i = 0; i < 3; i++)
                    nextPos[i] = changePos[i];

                queue.add(nextPos);
            }
            else {
                int nx = curX + dx[curDir];
                int ny = curY + dy[curDir];

                queue.add(new int[] {nx, ny, curDir, curCnt + 1});
            }

        }

        return cnt;
    }

    public static void print(boolean[][] vis) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                sb.append(vis[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for(int j = 0; j < M; j++)
                board[i][j] = line.charAt(j);
        }

        st = new StringTokenizer(br.readLine());
        settle_x = Integer.parseInt(st.nextToken());
        settle_y = Integer.parseInt(st.nextToken());
        settle_x--; settle_y--;

        // Implementation
        int cnt = 0; char getDir = '_';

        for(int i = 0; i < 4; i++) {
            int checkRadar = bfs(settle_x, settle_y, i);

            if(cnt < checkRadar) {
                cnt = checkRadar;
                getDir = myDir[i];
            }
        }

        System.out.println(getDir);
        if(cnt == Integer.MAX_VALUE)
            System.out.println("Voyager");
        else
            System.out.println(cnt - 1);
    }
}
