import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240630_26170 {

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int minDist = 10000;

    static void recur(int x, int y, int appleCnt, int curDist) {
        if (appleCnt == 3) {
            minDist = curDist < minDist ? curDist : minDist;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx > 4 || ny < 0 || ny > 4 || board[nx][ny] == -1 || visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            recur(nx, ny, board[nx][ny] == 1 ? appleCnt + 1 : appleCnt, curDist + 1);
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[5][5];
        visited = new boolean[5][5];

        for (int x = 0; x < 5; x++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int y = 0; y < 5; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        String line = br.readLine();
        int r = line.charAt(0) - '0';
        int c = line.charAt(2) - '0';

        visited[r][c] = true;
        recur(r, c, board[r][c] == 1 ? 1 : 0, 0);
        visited[r][c] = false;

        System.out.println(minDist == 10000 ? -1 : minDist);
        br.close();
    }

}
