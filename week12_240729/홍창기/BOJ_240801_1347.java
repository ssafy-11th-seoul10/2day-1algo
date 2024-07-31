import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240801_1347 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[101][101];

        for (int x = 0; x < 101; x++) {
            for (int y = 0; y < 101; y++) {
                board[x][y] = '#';
            }
        }

        String moving = br.readLine();
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };
        int d = 0;
        int px = 50;
        int py = 50;
        board[px][py] = '.';
        int minX = 50, maxX = 50;
        int minY = 50, maxY = 50;

        for (int i = 0; i < n; i++) {
            switch (moving.charAt(i)) {
                case 'L':
                    if (--d == -1) {
                        d = 3;
                    }

                    break;
                case 'R':
                    if (++d == 4) {
                        d = 0;
                    }

                    break;
                case 'F':
                    px += dx[d];
                    py += dy[d];
                    board[px][py] = '.';
                    minX = px < minX ? px : minX;
                    maxX = px > maxX ? px : maxX;
                    minY = py < minY ? py : minY;
                    maxY = py > maxY ? py : maxY;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                sb.append(board[x][y]);
            }

            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }

}
