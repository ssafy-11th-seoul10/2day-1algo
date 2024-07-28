package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1189 {

    private static int R,C,K;
    private static int answer = 0;
    private static boolean[][] visited;
    private static String[] board;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};

    private static void DFS(int x, int y, int depth){
        if(depth==K){
            if(x==0 && y==C-1) {
                answer += 1;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny] && !(board[nx].charAt(ny) =='T')){
                visited[nx][ny] = true;
                DFS(nx,ny,depth+1);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new String[R];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine();
        }
        visited = new boolean[R][C];
        visited[R-1][0] = true;
        DFS(R-1,0,1);
        System.out.println(answer);
    }

}
