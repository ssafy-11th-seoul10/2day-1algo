import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] buildings = new int[N];
        int[][] leftDp = new int[N][2];
        int[][] rightDp = new int[N][2];
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (buildings[i] < buildings[j]) {
                    leftDp[i][0] = leftDp[j][0] + 1;
                    leftDp[i][1] = j;
                    break;
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (buildings[i] < buildings[j]) {
                    rightDp[i][0] = rightDp[j][0] + 1;
                    rightDp[i][1] = j;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            int idx = -1;
//            System.out.println(leftDp[i][0] + " " + rightDp[i][0]);
            cnt = leftDp[i][0] + rightDp[i][0];
            leftDp[i][1] = (leftDp[i][0] == 0) ? leftDp[i][1] = Integer.MAX_VALUE : leftDp[i][1];
            rightDp[i][1] = (rightDp[i][0] == 0) ? rightDp[i][1] = Integer.MAX_VALUE : rightDp[i][1];

//            System.out.println(i + " " + leftDp[i][1] + " " + rightDp[i][1]);

            idx = (Math.abs(leftDp[i][1] - i) <= Math.abs(rightDp[i][1] - i)) ? leftDp[i][1] : rightDp[i][1];


            if (cnt == 0) {
                sb.append(cnt).append(" ");
            } else {
                sb.append(cnt).append(" ").append(idx + 1);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
