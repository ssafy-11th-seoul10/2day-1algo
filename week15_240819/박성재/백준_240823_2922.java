import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 백준_240823_2922 {
    static long answer;
    static Set<Character> moSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String s = st.nextToken();

        answer = 0;
        boolean lCheck = false;
        moSet = new HashSet<>();
        moSet.add('A');
        moSet.add('E');
        moSet.add('I');
        moSet.add('O');
        moSet.add('U');

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lCheck = true;
                break;
            }
        }

        dfs(s, 0, 0, 0, lCheck, 1);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void dfs(String s, int depth, int ja, int mo, boolean lCheck, long count) {
        if (ja >= 3 || mo >= 3)
            return;

        if (depth == s.length()) {
            if (lCheck)
                answer += count;
            return;
        }

        if (s.charAt(depth) == '_') { // 모음
            dfs(s, depth + 1, ja + 1, 0, lCheck, count * 20);
            dfs(s, depth + 1, 0, mo + 1, lCheck, count * 5);
            dfs(s, depth + 1, ja + 1, 0, true, count);
        } else {
            if (moSet.contains(s.charAt(depth))) {
                dfs(s, depth + 1, 0, mo + 1, lCheck, count);
            } else if (s.charAt(depth) == 'L') {
                dfs(s, depth + 1, ja + 1, 0, true, count);
            } else {
                dfs(s, depth + 1, ja + 1, 0, lCheck, count);
            }
        }
    }

}
