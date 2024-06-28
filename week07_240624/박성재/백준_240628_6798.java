import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_240628_6798 {
    static int[] dy = { 2, 2, 1, 1, -1, -1, -2, -2 };
    static int[] dx = { -1, 1, -2, 2, -2, 2, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        sb.append(bfs(startX, startY, endX, endY)).append("\n");
        System.out.println(sb);
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[9][9];

        deque.add(new int[] { startX, startY, 0 });
        visited[startX][startY] = true;

        while (!deque.isEmpty()) {
            int[] now = deque.pollFirst();
            int nx = now[0];
            int ny = now[1];
            int d = now[2];

            if (nx == endX && ny == endY)
                return d;
            for (int i = 0; i < 8; i++) {
                int c = now[0] + dx[i];
                int r = now[1] + dy[i];

                if (c < 1 || r < 1 || c > 8 || r > 8)
                    continue;

                if (visited[c][r])
                    continue;
                visited[c][r] = true;
                deque.addLast(new int[] { c, r, d + 1 });
            }
        }

        return -1;
    }

}
