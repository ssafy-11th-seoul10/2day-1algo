'연속' 이라는 말이 붙으면 투포인터와 슬라이딩윈도우 생각

---

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;

    private static int[] arr;
    private static int[] numCnt;

    private static long answer = 0;

    public static void main(String[] args) throws IOException {

        inputSetting();
        numCnt = new int[111111];
        int start = 0;
        for (int i = 0; i < N; i++) {
            numCnt[arr[i]]++;
            while (numCnt[arr[i]] == 2) {
                answer += i - start;
                numCnt[arr[start]]--;
                start++;
            }
        }
        for (int i = start; i < N; i++) {
            answer += N - i;
        }
        System.out.println(answer);
    }


    private static void inputSetting() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
