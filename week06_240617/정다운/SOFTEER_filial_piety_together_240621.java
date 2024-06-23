package Softeer;

import java.io.*;
import java.util.*;

public class filial_piety_together {

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }

    static int[][] friend;
    static int[] friend_value;

    static int result = 0;

    // BackTracking 문제, 방문 체크 & 해제 로직이 핵심 포인트!
    // 친구 1명에 대한 재귀 함수
        // 끝의 친구까지 도달 하면 계산 로직 수행
        // 아니면, 현재 친구에 위치에서 길이 4만큼의 가능한 dfs 경우의 수 계산 함수 호출
    public static void select_friend(int depth) {

        if(depth == M) {

            int val = 0;
            for(int i = 0; i < M; i++)
                val += friend_value[i];

            result = Math.max(result, val);
            return;
        }

        int[] f = friend[depth];
        int fx = f[0]; int fy = f[1];

        if(!visited[fx][fy]) {
            visited[fx][fy] = true;
            dfs(fx, fy, 0, board[fx][fy], depth);
            visited[fx][fy] = false;
        }
    }

    // 현재 위치에서 4방 방향으로 이동 시키는 재귀 함수
    // 위치 & 현재 친구 번호를 정보로 가지며, 길이가 4면 다음 친구로 넘어 가도록 하는 로직을 가진다.
        // 길이 4만큼 성공적으로 하나의 경우 계산 하면, 다음 친구로 넘어가도록 한다.
    // 가능한 모든 경우를 탐색 -> visited 방문 & 해제 로직이 필요 하다. ( 단순 dfs가 아니다! )
    public static void dfs(int x, int y, int cnt, int val, int f_num) {

        if(cnt == 3) {
            friend_value[f_num] = val;

            if(f_num < M)
                select_friend(f_num + 1);
            return;
        }

        for(int i = 0; i < 4; i++){

            int nx = x + dx[i]; int ny = y + dy[i];

                if(inRange(nx, ny) && !visited[nx][ny]) {

                    visited[nx][ny] = true;

                    dfs(nx, ny, cnt + 1, val + board[nx][ny], f_num);

                    visited[nx][ny] = false;
                }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        friend = new int[M][2];
        friend_value = new int[M];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            friend[i][0] = x - 1; friend[i][1] = y - 1;
        }

        // Simulation
        select_friend(0);

        System.out.println(result);
    }
}
