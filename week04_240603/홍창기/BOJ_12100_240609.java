import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100_240609 {

    static int n;
    static int maxBlockNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int y = 0; y < n; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, board);
        System.out.println(maxBlockNum);
        br.close();
    }

    static void recur(int depth, int[][] board) {
        if (depth == 5) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    maxBlockNum = board[x][y] > maxBlockNum ? board[x][y] : maxBlockNum;
                }
            }

            return;
        }

        int[][] newBoard = copyBoard(board);
        up2048(newBoard);
        recur(depth + 1, newBoard);

        newBoard = copyBoard(board);
        down2048(newBoard);
        recur(depth + 1, newBoard);

        newBoard = copyBoard(board);
        left2048(newBoard);
        recur(depth + 1, newBoard);

        newBoard = copyBoard(board);
        right2048(newBoard);
        recur(depth + 1, newBoard);
    }

    static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                newBoard[x][y] = board[x][y];
            }
        }

        return newBoard;
    }

    static void up2048(int[][] board) {
        gravityUp(board);
        mergeUp(board);
        gravityUp(board);
    }

    static void down2048(int[][] board) {
        gravityDown(board);
        mergeDown(board);
        gravityDown(board);
    }

    static void left2048(int[][] board) {
        gravityLeft(board);
        mergeLeft(board);
        gravityLeft(board);
    }

    static void right2048(int[][] board) {
        gravityRight(board);
        mergeRight(board);
        gravityRight(board);
    }

    static void gravityUp(int[][] board) {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n - 1; x++) {
                if (board[x][y] == 0) {
                    int xx = x;

                    while (++xx < n) {
                        if (board[xx][y] > 0) {
                            board[x][y] = board[xx][y];
                            board[xx][y] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void mergeUp(int[][] board) {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n - 1; x++) {
                if (board[x][y] == board[x + 1][y]) {
                    board[x][y] <<= 1;
                    board[x + 1][y] = 0;
                }
            }
        }
    }

    static void gravityDown(int[][] board) {
        for (int y = 0; y < n; y++) {
            for (int x = n - 1; x >= 1; x--) {
                if (board[x][y] == 0) {
                    int xx = x;

                    while (--xx >= 0) {
                        if (board[xx][y] > 0) {
                            board[x][y] = board[xx][y];
                            board[xx][y] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void mergeDown(int[][] board) {
        for (int y = 0; y < n; y++) {
            for (int x = n - 1; x >= 1; x--) {
                if (board[x][y] == board[x - 1][y]) {
                    board[x][y] <<= 1;
                    board[x - 1][y] = 0;
                }
            }
        }
    }

    static void gravityLeft(int[][] board) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n - 1; y++) {
                if (board[x][y] == 0) {
                    int yy = y;

                    while (++yy < n) {
                        if (board[x][yy] > 0) {
                            board[x][y] = board[x][yy];
                            board[x][yy] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void mergeLeft(int[][] board) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n - 1; y++) {
                if (board[x][y] == board[x][y + 1]) {
                    board[x][y] <<= 1;
                    board[x][y + 1] = 0;
                }
            }
        }
    }

    static void gravityRight(int[][] board) {
        for (int x = 0; x < n; x++) {
            for (int y = n - 1; y >= 1; y--) {
                if (board[x][y] == 0) {
                    int yy = y;

                    while (--yy >= 0) {
                        if (board[x][yy] > 0) {
                            board[x][y] = board[x][yy];
                            board[x][yy] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void mergeRight(int[][] board) {
        for (int x = 0; x < n; x++) {
            for (int y = n - 1; y >= 1; y--) {
                if (board[x][y] == board[x][y - 1]) {
                    board[x][y] <<= 1;
                    board[x][y - 1] = 0;
                }
            }
        }
    }

}
