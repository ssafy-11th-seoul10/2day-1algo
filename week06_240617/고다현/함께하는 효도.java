import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result = 0, answer = 0, ans = 0;
    static int [][] board = new int[21][21];
    static int [][] tempBoard = new int[21][21];
    static Pair[] friends = new Pair[4];

    static int[] list = new int[3];
    static boolean[] visited = new boolean[3];
    static Pair[] tempMove = new Pair[3];
    static Pair[] move = new Pair[3];

    static int a[] = {0, 0, 1, -1};
    static int b[] = {1, -1, 0, 0};

    static class Pair{
        int x,y;

        Pair(){}
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "[x : " + this.x + " , y: " + this.y + " ]\n";
        }
    }

    static boolean hasPlace(int x, int y){
        if(x>=0 && x<N && y>= 0 && y< N) return true;
        return false;
    }

    static void printBoard(){
        System.out.println("=====board=====");
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static void copyBoard(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                tempBoard[i][j] = board[i][j];
            }
        }
    }

    static void makeList(int c){
        if(c == M){
            int tempAnswer = answer;
            copyBoard();

            for(int i=0;i<M;i++){
                result = 0;
                letsMove(0, friends[list[i]].x, friends[list[i]].y, 0);

                // 이동한 칸 0으로 변경
                for(int j=0;j<3;j++){
                    tempBoard[move[j].x][move[j].y] = 0;
                }
                tempAnswer += result;
            }

            ans = Math.max(tempAnswer, ans);
            return;
        }

        for(int t=0;t<M;t++){
            if(visited[t]) continue;
            list[c] = t;
            visited[t] = true;
            makeList(c+1);
            visited[t] = false;
        }
    }

    static void letsMove(int c, int x, int y, int sum){
        if(c == 3){
            if(result < sum){
                for(int i=0;i<3;i++){
                    move[i].x = tempMove[i].x;
                    move[i].y = tempMove[i].y;
                }
                result = sum;
            }
            return;
        }

        for(int i=0;i<4;i++){
            int xx = x + a[i];
            int yy = y + b[i];
            if(!hasPlace(xx, yy)) continue;
            int temp = tempBoard[xx][yy];
            tempMove[c].x = xx;
            tempMove[c].y = yy;
            tempBoard[xx][yy] = 0;
            letsMove(c+1, xx, yy, sum + temp);
            tempBoard[xx][yy] = temp;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 열매 수확량
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 친구들 위치
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            friends[i] = new Pair(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
            answer += board[friends[i].x][friends[i].y];
            board[friends[i].x][friends[i].y] = 0;
        }

        // 이동 초기화
        for(int i=0;i<3;i++){
            tempMove[i] = new Pair();
            move[i] = new Pair();
            visited[i] = false;
        }

        // 친구 순서 정하기, 순서에 따라 값이 달라질 수 있음
        makeList(0);

        System.out.println(ans);
    }
}

/*
예외 case

4 2
1 1 1 1
2 200 1 1
2 8 1 1
1 8 4 1
4 1
4 3

 => 226
* */