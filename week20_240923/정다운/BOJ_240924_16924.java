package baekjoon;

import java.util.*;
import java.io.*;

// 성능을 고칠 수 있는 방법?
// 모든 "*"을 모아서, size를 1씩 늘려가며 가능한 십자가를 모두 만들어 보기

// 십자가 => dx, dy로 일일히 파악보다는 아래 방법 쓰기!
//      -> for k = 1 ~ k <= size : pos[i+k][j] & pos[i][j+k] & pos[i-k][j] & pos[i][j-k]

public class BOJ16924 {

    static int N, M;

    static char[][] board;
    static char[][] getBoard;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    static List<int[]> result = new ArrayList<>();

    public static boolean check() {

        for(int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if(getBoard[i][j] != board[i][j])
                    return false;
            }

        return true;
    }

    public static boolean insertCross(int x, int y, int size) {

        if(board[x][y] == '.') {
            return false;
        }

        List<int[]> cross = new ArrayList<>();
        cross.add(new int[]{x,y});

        for(int i = 0; i < 4; i++) {

            int nx = x; int ny = y;

            for(int j = size; j > 0; j--) {
                nx = nx + dx[i]; ny = ny + dy[i];

                if(!inRange(nx, ny) || board[nx][ny] == '.')
                    return false;

                cross.add(new int[]{nx, ny});
            }
        }

        for(int[] pos : cross)
            getBoard[pos[0]][pos[1]] = '*';

//        System.out.println("insert cross : " + x + " : " + y + " : size : " + size);
//        print();
//        System.out.println();
        return true;
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(getBoard[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M]; getBoard = new char[N][M];
        boolean isSame = false;

        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();

            for(int j = 0; j < M; j++) {
                board[i][j] = tmp.charAt(j);
                getBoard[i][j] = '.';
            }
        }

        // STEP 1. 가장 큰 십자가 설정
        int maxSize = Math.max(N, M);

        // STEP 2. simulation
        for(int size = 1; size < maxSize; size++) {

            for(int x = 0; x < N; x++)
                for(int y = 0; y < M; y++) {
                    if(board[x][y] == '*') {
                        boolean flag = insertCross(x, y, size);

                        if(flag)
                            result.add(new int[]{x + 1, y + 1, size});
                    }
                    if(check()) {
                        isSame = true;
                        break;
                    }
                }
        }

        // STEP 3. print
        if(!isSame)
            System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();

            sb.append(result.size()).append('\n');
            for(int[] pos : result)
                sb.append(pos[0]).append(" ").append(pos[1]).append(" ").append(pos[2]).append('\n');

            System.out.println(sb);
        }
    }
}
