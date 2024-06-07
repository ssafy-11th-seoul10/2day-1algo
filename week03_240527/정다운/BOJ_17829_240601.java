import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17829 {
    static int N;
    static int[][] board;

    public static void printBoard() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++)
                sb.append(board[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        // Setup
        int leng = N;
        int[][] simulBoard = new int[leng / 2][leng / 2];

        // Simulation
        while(leng > 1) {

            int temp = leng / 2;

            int simul_x = 0; int simul_y = 0;

            for(int i = 0; i < board.length; i = i + 2)
                for(int j = 0; j < board.length; j = j + 2) {
                    int st_x = i; int st_y = j;

                    int[] arr = new int[4];
                    int idx = 0;
                    // 4개 좌표 얻기
                    for(int x = 0; x < 2; x++)
                        for(int y = 0; y < 2; y++) {
                            arr[idx] = board[st_x + x][st_y + y];
                            idx++;
                        }
                    // sort -> 2번째로 큰 수 얻기
                    Arrays.sort(arr);
                    simulBoard[simul_x][simul_y] = arr[2];

                    if(simul_y < simulBoard.length - 1)
                        simul_y++;
                    else {
                        simul_y = 0;
                        simul_x++;
                    }
                    //System.out.println(i + " :: " + j);
                    //System.out.println(simul_x + " : " + simul_y);
                }

            // simulboard -> board
            leng = leng / 2;
            board = new int[leng][leng];

            for(int i = 0; i < leng; i++)
                for(int j = 0; j < leng; j++)
                    board[i][j] = simulBoard[i][j];

//            System.out.println("STEP");
//            printBoard();

            simulBoard = new int[simulBoard.length / 2][simulBoard.length / 2];
        }

        System.out.println(board[0][0]);
    }
}
