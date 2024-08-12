import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int T;
    private static int N;

    private static String W;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            solve();
        }

    }

    private static void solve() throws IOException {
        Map<Character, List<Integer>> map = new HashMap<>();
        W = br.readLine();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < W.length(); i++) {
            char cur = W.charAt(i);
            if (map.containsKey(cur)) {
                map.get(cur).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(cur, list);
            }
        }
        int minAnswer = Integer.MAX_VALUE;
        int maxAnswer = 0;
        for (List<Integer> curList : map.values()) {
            minAnswer = getMaxAnswer(minAnswer, curList, false);
            maxAnswer = getMaxAnswer(maxAnswer, curList, true);
//            System.out.println(minAnswer + " " + maxAnswer);

        }
        if (minAnswer == Integer.MAX_VALUE || maxAnswer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minAnswer + " " + maxAnswer);
        }
    }

    private static int getMaxAnswer(int answer, List<Integer> curList, boolean isFindMax) {
        for (int i = 0; i + N - 1 < curList.size(); i++) {
            int start = curList.get(i);
            int end = curList.get(i + N - 1);
            if (isFindMax) answer = Math.max(answer, end - start + 1);
            else answer = Math.min(answer, end - start + 1);
        }
        return answer;
    }

}
