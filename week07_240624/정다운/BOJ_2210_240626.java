import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ2210 {

    static char[][] board = new char[5][5];

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static boolean inRange(int x, int y) {
        return (0 <= x && x < 5) && (0 <= y && y < 5);
    }

    static Set<String> sixNumber = new HashSet<>();

    public static void dfs(int x, int y, int depth, char[] tmp) {
        if(depth == 5) {
            sixNumber.add(String.valueOf(tmp));
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i]; int ny = y + dy[i];

            if(inRange(nx, ny)) {

                tmp[depth + 1] = board[nx][ny];
                dfs(nx, ny, depth + 1, tmp);
                tmp[depth + 1] = '\u0000';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++)
                board[i][j] = st.nextToken().charAt(0);
        }

        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++) {
                char[] t = new char[6];
                t[0] = board[i][j];

                dfs(i, j, 0, t);
            }

        System.out.println(sixNumber.size());
    }
}
