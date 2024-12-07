package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ6593 {

    static int L, R, C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dz = {-1,0,1};

    public static boolean inRange(int z, int x, int y) {
        return (0 <= z && z < L) && (0 <= x && x < R) && (0 <= y && y < C);
    }

    static char[][][] building;
    static boolean[][][] visited;

    public static int bfs(int sx, int sy, int sz) {

        int count = 0;
        visited[sz][sx][sy] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sz, sx, sy, 0});

        while (!queue.isEmpty()) {

            int[] curPos = queue.poll();
            int curZ = curPos[0]; int curX = curPos[1]; int curY = curPos[2];
            int cnt = curPos[3];
//            System.out.println("curPos : { " + curZ + ", " + curX + ", " + curY +" }");

            if(building[curZ][curX][curY] == 'E')
                return cnt;

            for(int z = 0; z < 3; z++) {
                int nz = curZ + dz[z];
                if(inRange(nz, curX, curY) && building[nz][curX][curY] != '#' && !visited[nz][curX][curY]) {
                    visited[nz][curX][curY] = true;
                    queue.add(new int[] {nz, curX, curY, cnt + 1});
                }
            }

            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i]; int ny = curY + dy[i];

                if(inRange(curZ, nx, ny) && building[curZ][nx][ny] != '#' && !visited[curZ][nx][ny]) {
                    visited[curZ][nx][ny] = true;
                    queue.add(new int[] {curZ, nx, ny, cnt + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0)
                break;

            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            int sx = 0; int sy = 0; int sz = 0;

            int leng = 0;
            int width = 0;

            while(leng < L) {
                String tmp = br.readLine();

                if(tmp.isEmpty()) {
                    leng++;
                    width = 0;
                    continue;
                }

                for(int j = 0; j < C; j++) {
                    building[leng][width][j] = tmp.charAt(j);

                    if (building[leng][width][j] == 'S') {
                        sz = leng; sx = width; sy = j;
                    }
                }
                width++;
            }

            int res = bfs(sx, sy, sz);

            if(res != -1)
                System.out.println("Escaped in " + res + " minute(s).");
            else
                System.out.println("Trapped!");
        }

    }
}
