package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ12891 {

    static Map<Character, Integer> dna = new HashMap<>();
    static Map<Character, Integer> currentCount = new HashMap<>();

    static boolean check() {
        for (char key : dna.keySet()) {
            if (currentCount.getOrDefault(key, 0) < dna.get(key)) {
                return false;
            }
        }
        return true;
    }

    static void update(char c, int cnt) {
        currentCount.put(c, currentCount.getOrDefault(c, 0) + cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        char[] characters = {'A', 'C', 'G', 'T'};

        st = new StringTokenizer(br.readLine());
        for (char c : characters) {
            dna.put(c, Integer.parseInt(st.nextToken()));
        }

        for (char c : characters) {
            currentCount.put(c, 0);
        }

        int front = 0;
        int back = P - 1;
        int answer = 0;

        for (int i = 0; i <= back; i++) {
            update(str.charAt(i), 1);
        }

        while (back < S) {
            if (check()) {
                answer += 1;
            }
            update(str.charAt(front), -1);
            front++;
            back++;
            if (back < S) {
                update(str.charAt(back), 1);
            }
        }
        System.out.println(answer);
    }
}
