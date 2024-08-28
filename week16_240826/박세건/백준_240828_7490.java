import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class StringIdx {
        String value;
        int idx;

        public StringIdx(String value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int K;
    private static char[] arr;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N - 1];

            makeZero(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void makeZero(int cnt) {
        if (cnt >= N - 1) {
            if (isZero()) {
                printAnswer();
            }
            return;
        }

        arr[cnt] = ' ';
        makeZero(cnt + 1);
        arr[cnt] = '+';
        makeZero(cnt + 1);
        arr[cnt] = '-';
        makeZero(cnt + 1);

    }

    private static void printAnswer() {
        sb.append(1);
        for (int i = 0; i < N - 1; i++) {
            sb.append(arr[i]).append(i + 2);
        }
        sb.append("\n");
    }

    private static boolean isZero() {
        char beforeOperator = '+';
        int answer = 0;
        int beforeVal = 1;
        boolean isPossible = false;
        for (int i = 0; i < N - 1; i++) {
            int curVal;
            if (arr[i] != ' ') {
                isPossible = true;
                if (beforeOperator == '+') {
                    answer += beforeVal;
                } else if (beforeOperator == '-') {
                    answer -= beforeVal;
                }
                curVal = i + 2;
                beforeOperator = arr[i];
            } else {
                curVal = beforeVal * 10 + i + 2;
            }
            beforeVal = curVal;
        }
        if (beforeOperator == '+') {
            answer += beforeVal;
        } else if (beforeOperator == '-') {
            answer -= beforeVal;
        }
        if (answer == 0 && isPossible) {
            return true;
        }
        return false;
    }
}
