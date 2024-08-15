import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;

    private static List<Integer> liquidList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        inputSetting();
        int start = 0;
        int end = N - 1;
        int[] answer = new int[]{Integer.MAX_VALUE, -1, -1};
        while (start < end) {
            int[] curAnswer = {Integer.MAX_VALUE, -1, -1};
            for (int i = end; i > start; i--) {
                int curSum = liquidList.get(start) + liquidList.get(i);
                if (curAnswer[0] > Math.abs(curSum)) {
                    curAnswer[0] = Math.abs(curSum);
                    curAnswer[1] = liquidList.get(start);
                    curAnswer[2] = liquidList.get(i);
//                    System.out.println(curAnswer[0] + " " + curAnswer[1] + " " + curAnswer[2]);
                    end = i;
                } else {
                    break;
                }
            }
            if (answer[0] > curAnswer[0]) {
                answer[0] = curAnswer[0];
                answer[1] = curAnswer[1];
                answer[2] = curAnswer[2];
            }
            start++;
        }
        System.out.println(answer[1] + " " + answer[2]);
    }

    private static void inputSetting() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquidList.add(Integer.valueOf(st.nextToken()));
        }
    }
}
