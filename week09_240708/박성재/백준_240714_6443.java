import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_240714_6443 {
    static StringBuilder sb;
    static HashSet<String> set;
    static List<String> list;
    static int[] visited;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            s = st.nextToken();
            list = new ArrayList<>();
            visited = new int['z' - 'a' + 1];
            set = new HashSet<>();

            for (int j = 0; j < s.length(); j++) {
                visited[s.charAt(j) - 'a']++;
            }

            backtrack(s.length(), new StringBuilder());
            print();
        }

        System.out.println(sb);
    }

    static void print() {
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
    }

    static void backtrack(int len, StringBuilder now) {
        if (now.length() == len) {
            if (!set.contains(now.toString())) {
                list.add(now.toString());
                set.add(now.toString());
            }
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] > 0) {
                visited[i] -= 1;
                char c = (char) ('a' + i);
                now.append(c);
                backtrack(len, now);
                now.deleteCharAt(now.length() - 1);
                visited[i] += 1;
            }

        }
    }
}
