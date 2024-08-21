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
    private static int answer = 0;
    private static int totalPrice;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int start = 1;
        int end = 100000;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        totalPrice = Integer.parseInt(br.readLine());
        while (start <= end) {
//            System.out.println(start + " " + end);
            int mid = (start + end) / 2;
            int predictedValue = getPredictedValue(mid);
            if (predictedValue != -1) {
                start = mid + 1;
                answer = Math.max(answer, predictedValue);
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static int getPredictedValue(int mid) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= mid) {
                sum += arr[i];
                max = Math.max(max, arr[i]);
            } else {
                sum += mid;
                max = Math.max(max, mid);
            }
        }
        if (sum <= totalPrice) {
            return max;
        }
        return -1;
    }

}
