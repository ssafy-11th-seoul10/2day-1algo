import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10157 {

    static int C, R;
    static int number;
    static int[][] board;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < R) && (0 <= y && y < C);
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        number = Integer.parseInt(br.readLine());

        board = new int[R][C];

        int x = R - 1; int y = 0;
        int dir = 0;
        int num = 1;
        board[x][y] = num;

        // mapping snail search
        while (num < number) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!inRange(nx , ny) || board[nx][ny] != 0) {
                if(dir + 1 >= 4)
                    dir = 0;
                else
                    dir++;
                continue;
            }

            board[nx][ny] = ++num;
            x = nx; y = ny;

            int check = 0;
            for(int i = 0; i < 4; i++) {
                int sx = x + dx[i]; int sy = y + dy[i];
                if(inRange(sx, sy) && board[sx][sy] != 0)
                    check++;
            }
            if(check == 4)
                break;
        }

//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++)
//                sb.append(board[i][j]).append(" ");
//            sb.append("\n");
//        }
//        System.out.println(sb);

        // R * C, (R - 1,0) -> (0,0) ~ (0, C - 1) -> (R'-1,C'-1)
        // C' = C - 1 - X, R' = Y
        // (0,4) (sero,garo) -> (6,6) (garo,sero)

        int resX = (R-1) - x; int resY = y;
        if(!inRange(resX, resY) || (num < number))
            System.out.println(0);
        else
            System.out.println((resY + 1) + " " + (resX + 1));
    }
}
