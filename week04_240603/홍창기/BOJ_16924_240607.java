import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16924_240607 {

    static int n, m;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        char[][] newBoard = new char[n][m];

        for (int x = 0; x < n; x++) {
            String line = br.readLine();

            for (int y = 0; y < m; y++) {
                board[x][y] = line.charAt(y);
                newBoard[x][y] = '.';
            }
        }

        StringBuilder sb = new StringBuilder();
        int ansCnt = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[x][y] != '*') {
                    continue;
                }

                // *이 있는 곳을 십자가의 중심이라고 가정했을 때 해당 위치에서 십자가의 길이를 구한다.

                int minLen = 200;

                for (int d = 0; d < 4; d++) {
                    int curLen = 0;
                    int cx = x + dx[d];
                    int cy = y + dy[d];

                    while (cx >= 0 && cx < n && cy >= 0 && cy < m && board[cx][cy] == '*') {
                        curLen++;
                        cx += dx[d];
                        cy += dy[d];
                    }

                    minLen = curLen < minLen ? curLen : minLen;
                }

                if (minLen == 0) {
                    continue;
                }

                // 가능한 십자가의 길이라면 newBoard에도 반영해준다.

                newBoard[x][y] = '*';

                for (int d = 0; d < 4; d++) {
                    int cx = x;
                    int cy = y;

                    for (int i = 0; i < minLen; i++) {
                        cx += dx[d];
                        cy += dy[d];
                        newBoard[cx][cy] = '*';
                    }
                }

                ansCnt++;
                sb.append(x + 1).append(" ").append(y + 1).append(" ").append(minLen).append("\n");
            }
        }

        // board와 newBoard가 같지 않다면 십자가로 커버할 수 없는 위치가 존재한다는 것이므로 -1을 출력한다.

        if (isSameBoard(board, newBoard)) {
            System.out.println(ansCnt);
            System.out.print(sb);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    static boolean isSameBoard(char[][] board, char[][] newBoard) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[x][y] != newBoard[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }

}
