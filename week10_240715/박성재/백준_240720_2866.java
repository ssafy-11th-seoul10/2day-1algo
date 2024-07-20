import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 백준_240720_2866 {
    static int R;
    static int C;
    static char[][] board;
    static int answer;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        answer = 0;
        bs();
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void bs() {
        int left = 0;
        int right = R;

        while (left <= right) {
            int middle = (left + right) / 2;

            boolean flag = true;
            set = new HashSet<>();
            for (int i = 0; i < C; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = middle; j < R; j++) {
                    sb.append(board[j][i]);
                }

                if (!set.contains(sb.toString())) {
                    set.add(sb.toString());
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) { // 겹치는것 없음
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
    }
}
