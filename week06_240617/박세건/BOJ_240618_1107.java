import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int N, M;
    private static int answer;

    private static boolean[] isInvalid = new boolean[11];

    public static void main(String[] args) throws IOException {
        inputProcess();
        answer = Math.abs(100 - N);
        for (int i = 0; i <= 999999; i++) {
            if (isPossible(i)) {
                findMinValue(i);
            }
        }
        System.out.println(answer);
    }

    private static boolean isPossible(int value) {
        String valueToString = Integer.toString(value);
        for (int i = 0; i < valueToString.length(); i++) {
            if (isInvalid[valueToString.charAt(i) - '0']) {
                return false;
            }
        }
        return true;
    }

    private static void findMinValue(int value) {
        answer = Math.min(Math.abs(N - value) + Integer.toString(value).length(), answer);
    }

    private static void DFS(int cur) {
//        System.out.println(cur);
        if (Integer.toString(cur).length() - Integer.toString(N).length() > 1) {
            return;
        }
        if (Math.abs(Integer.toString(cur).length() - Integer.toString(N).length()) <= 1) {
//            System.out.println(cur + " " + Math.abs(N - cur) + Integer.toString(cur).length());
            answer = Math.min(answer, Math.abs(N - cur) + Integer.toString(cur).length());
        }
        for (int i = 0; i < 11; i++) {
            if (cur == 0 && i == 0) {
                continue;
            }
            if (!isInvalid[i]) {
                DFS(cur * 10 + i);
            }
        }
    }

    private static void inputProcess() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());
        if (M != 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i = 0; i < M; i++) {
                isInvalid[Integer.parseInt(stringTokenizer.nextToken())] = true;
            }
        }
    }
}
