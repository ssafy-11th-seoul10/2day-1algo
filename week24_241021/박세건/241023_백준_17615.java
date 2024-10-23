import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
//    private static Deque<Character> input = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        char[] inputArr = br.readLine().toCharArray();

        int answer = getResultByLeft(inputArr, 'B');
        answer = Math.min(answer, getResultByRight(inputArr, 'B'));
        answer = Math.min(answer, getResultByLeft(inputArr, 'R'));
        answer = Math.min(answer, getResultByRight(inputArr, 'R'));
        System.out.println(answer);
    }

    private static int getResultByLeft(char[] inputArr, char target) {
        boolean isDiff = false;
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (inputArr[i] == target) {
                if (isDiff) {
                    result++;
                }
            } else {
                isDiff = true;
            }
        }
//        System.out.println(result);
        return result;
    }

    private static int getResultByRight(char[] inputArr, char target) {
        boolean isDiff = false;
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (inputArr[i] == target) {
                if (isDiff) {
                    result++;
                }
            } else {
                isDiff = true;
            }
        }
//        System.out.println(result);

        return result;
    }

}
