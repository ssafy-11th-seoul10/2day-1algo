import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        int visitedCnt = 0;
        int cur = M;
        sb.append("<");
        while (true) {
//            System.out.println(cur);
            visited[cur] = true;
            sb.append(cur).append(", ");
            visitedCnt++;
            if (visitedCnt == N) {
                break;
            }
            for (int i = 0; i < M; i++) {
//                System.out.println(cur);
                cur++;
                if (cur > N) {
                    cur = 1;
                }
                if (visited[cur]) {
                    i--;
                }
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }


}
