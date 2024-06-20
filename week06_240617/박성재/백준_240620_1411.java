import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 백준_240620_1411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            arr[i] = s;
        }

        int answer = 0;
        Map<Character, Character> map;
        boolean[] used;
        for (int i = 0; i < n - 1; i++) {
            String s1 = arr[i];
            loop: for (int j = i + 1; j < n; j++) {
                String s2 = arr[j];
                map = new HashMap<>();
                used = new boolean[26];
                for (int k = 0; k < s1.length(); k++) {
                    if (!map.containsKey(s1.charAt(k))) {
                        if (used[s2.charAt(k) - 'a'])
                            continue loop;
                        map.put(s1.charAt(k), s2.charAt(k));
                        used[s2.charAt(k) - 'a'] = true;
                    } else {
                        if (map.get(s1.charAt(k)) != s2.charAt(k)) {
                            continue loop;
                        }
                    }
                }

                answer++;
            }
        }
        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}
