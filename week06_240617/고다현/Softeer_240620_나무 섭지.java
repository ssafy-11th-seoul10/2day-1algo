import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board = new int[1001][1001];
    static boolean[][] visited = new boolean[1001][1001];
    static List<Pair> ghost = new ArrayList<>();
    static Pair Nam, end;
    static boolean isOut = false;

    static int a[] = {1, -1, 0 , 0};
    static int b[] = {0 , 0, 1, -1};

    static class Pair{
        int x, y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "[x : " + this.x + " , y : " + this.y + " ]";
        }
    }

    static class Tuple{
        int x, y, t;

        Tuple(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static boolean check(int x, int y){
        if(x >= 0 && x < N && y>= 0 && y < M) return true;
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                char now = str.charAt(j);
                visited[i][j] = false;

                if(now == 'G'){
                    ghost.add(new Pair(i, j));
                }
                else if(now == 'N'){
                    Nam = new Pair(i, j);
                }
                else if(now == '#'){ // 벽
                    board[i][j] = -1;
                    continue;
                }
                else if(now == 'D'){
                    board[i][j] = 1;
                    end = new Pair(i, j);
                    continue;
                }
                board[i][j] = 0; //이동 가능
            }
        }

        // 유령이 도착지에 먼저 도착
        int ghostTempMove  = 100000;
        for(int i=0;i<ghost.size();i++){
            ghostTempMove = Math.min(Math.abs(end.x - ghost.get(i).x) + Math.abs(end.y - ghost.get(i).y), ghostTempMove);
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(Nam.x, Nam.y, 0));

        int namMove = -1;
        while(!q.isEmpty()){
            Tuple now = q.poll();

            if(board[now.x][now.y] == 1){
                namMove = now.t;
                break;
            }

            if(visited[now.x][now.y]) continue;
            visited[now.x][now.y] = true;

            for(int i=0;i<4;i++){
                int xx = now.x + a[i];
                int yy = now.y + b[i];

                if(check(xx, yy) && !visited[xx][yy] && board[xx][yy] != -1 ){
                    q.add(new Tuple(xx, yy, now.t + 1));
                }
            }
        }

        if(namMove == -1)  isOut = false;
        else if(namMove >= ghostTempMove) isOut = false;
        else isOut = true;

        if(isOut) System.out.println("Yes");
        else System.out.println("No");
    }
}
