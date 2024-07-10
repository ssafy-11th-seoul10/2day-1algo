BFS구현
  구슬이 붙어있을때 예외 생각
  구슬이 같이 떨어졌을때 생각

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N,M;
    private static char[][] map;
    private static int rx,ry,bx,by,hx,hy;
    private static int[] dix = {-1, 0, 1, 0};
    private static int[] diy={0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        inputSetting();
        int answer=bfs();
        System.out.println((answer==987654321)?-1:answer);
    }

    private static int bfs() {
        boolean[][][][] visited=new boolean[N][M][N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by]=true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
//            System.out.println(cur[0] + " " + cur[1] + " | " + cur[2] + " " + cur[3] + " | " + cur[4]);
            if (cur[4] >= 10) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int[] next = moveBalls(cur.clone(), i);
                //next[4] 가 -1이면 파란공 들어감, -2면 빨간 공만 들어감을 의미
                //공이 들어갔거나 파란 공이 들어갔다면 continue;
                //빨간 공만 들어갔다면 cnt 최솟값 유지
                if (next[4] == -1) continue;
                if (next[4] == -2) {
                   return cur[4]+1;
                }
                if(visited[next[0]][next[1]][next[2]][next[3]])continue;
                queue.add(new int[]{next[0], next[1], next[2], next[3], cur[4] + 1});
                visited[next[0]][next[1]][next[2]][next[3]]=true;
            }
        }
        return -1;
    }

    private static int[] moveBalls(int[] next, int dir) {
        /*
         *   빨간공이동 -> 파란공 이동 -> 빨간공 이동
         * */
        moveBall(next, dir,0,1,2,3);
        moveBall(next, dir,2,3,0,1);
        moveBall(next, dir,0,1,2,3);
        return next;
    }

    private static void moveBall(int[] next, int dir,int idx1, int idx2,int idx3,int idx4) {
        while (true) {
            //공이 구멍에 들어갔다면
            if (map[next[idx1]+dix[dir]][next[idx2]+diy[dir]] == 'O') {
                next[idx1] += dix[dir];
                next[idx2]+= diy[dir];
                if(idx1==0){    //빨간공일때
                    if (next[4] != -1) {
                        next[4]=-2;
                    }
                }else{  //파란공일때
//                    System.out.println("파란공이 들어갔다네");
                    next[4]=-1;
                }
                break;
            }
            //공이 벽으로 향한다면
            if(map[next[idx1]+dix[dir]][next[idx2]+diy[dir]]=='#') break;
            //공이 다른 공과 만났다면
            if(next[idx1]+dix[dir]==next[idx3]&&next[idx2]+diy[dir]==next[idx4]) break;
            next[idx1] += dix[dir];
            next[idx2]+= diy[dir];
        }
    }

    private static void inputSetting() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j]=tmp.charAt(j);
                if (map[i][j] == 'R') {
                    rx=i;
                    ry=j;
                }else if(map[i][j] == 'B') {
                    bx=i;
                    by=j;
                }else if(map[i][j] == 'O') {
                    hx=i;
                    hy=j;
                }
            }
        }
    }
}
