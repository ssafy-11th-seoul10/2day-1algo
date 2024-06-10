import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            String functionString = bufferedReader.readLine();
            int N = Integer.parseInt(bufferedReader.readLine());
            String inputString = bufferedReader.readLine();
            inputString = (N == 0) ? "" : inputString.substring(1, inputString.length() - 1);
            String[] inputArr = inputString.split(",");
            Deque<Integer> deque = new LinkedList<>();
            for (String tmp : inputArr) {
                if (!tmp.isEmpty()) {
                    deque.add(Integer.parseInt(tmp));
                }
            }
            boolean isPopFirst = true;
            boolean isError = false;
            for (int j = 0; j < functionString.length(); j++) {
                char tmp = functionString.charAt(j);
                if (tmp == 'R') {
                    isPopFirst = !isPopFirst;
                } else if (tmp == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isPopFirst) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }
            if (isError) {
                stringBuilder.append("error").append("\n");
            } else {
                stringBuilder.append("[");
                while (!deque.isEmpty()) {
                    if (deque.size() == 1) {
                        stringBuilder.append(pollByFlag(deque, isPopFirst));
                    } else {
                        stringBuilder.append(pollByFlag(deque, isPopFirst)).append(",");
                    }
                }
                stringBuilder.append("]").append("\n");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private static int pollByFlag(Deque<Integer> deque, boolean isPopFirst) {
        if (deque.isEmpty()) {
            return -1;
        }
        if (isPopFirst) {
            return deque.pollFirst();
        }
        return deque.pollLast();

    }
}
