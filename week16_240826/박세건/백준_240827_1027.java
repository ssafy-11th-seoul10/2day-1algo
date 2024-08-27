import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, K;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            double incline = Double.MAX_VALUE;
            for (int j = i - 1; j >= 1; j--) {
                double curIncline = (double) (arr[i] - arr[j]) / Math.abs(i - j);
                if (incline > curIncline) {
//                    System.out.print(curIncline + " ");
                    incline = curIncline;
                    cnt++;
                }
            }
            incline = Double.MAX_VALUE;
            for (int j = i + 1; j <= N; j++) {
                double curIncline = (double) (arr[i] - arr[j]) / Math.abs(i - j);
//                System.out.print(curIncline + " ");
                if (incline > curIncline) {
                    incline = curIncline;
                    cnt++;
                }
            }
//            System.out.println();
//            System.out.println(cnt);
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

}
