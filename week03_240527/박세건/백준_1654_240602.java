import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static int N, K;
    private static List<Integer> inputList = new ArrayList<>();
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        K = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(bufferedReader.readLine());
            inputList.add(tmp);
            maxValue = Math.max(maxValue, inputList.get(i));
        }
        long begin = 1;
        long end = maxValue;
        while (begin <= end) {
            long mid = (begin + end) / 2;
//            System.out.println(begin + " " + mid + " " + end);

            if (mid >= 1 && isSolutionValue(mid)) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isSolutionValue(long mid) {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            cnt += (int) (inputList.get(i) / mid);
        }
        if (cnt >= N) {
            answer = (int) mid;
            return true;
        }
        return false;
    }
}
