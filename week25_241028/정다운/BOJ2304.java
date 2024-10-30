import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2304 {

    static int N;
    static int[][] taller;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        taller = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            taller[i][0] = Integer.parseInt(st.nextToken());
            taller[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(taller, (t1, t2) -> {
            return t1[0] - t2[0];
        });
        boolean[] visited = new boolean[taller.length];

        int rightLeng = taller[0][1];
        int rightCnt = taller[0][0] + 1;

        visited[0] = true;
        int rightWidth = rightLeng;
        int leftWidth = 0;

        for (int i = 1; i < taller.length; i++) {

            if (rightLeng <= taller[i][1]) {
                rightWidth += (((taller[i][0]) - rightCnt) * rightLeng);
                rightWidth += taller[i][1];

                rightLeng = taller[i][1];
                rightCnt = taller[i][0] + 1;
                visited[i] = true;
            }
        }

        boolean flag = visited[taller.length - 1];
        //System.out.println(flag);
        if (!flag) {
            int leftLeng = taller[taller.length - 1][1];
            int leftCnt = taller[taller.length - 1][0];
            leftWidth = leftLeng;
            for (int j = taller.length - 2; j > -1; j--) {

                if (leftLeng <= taller[j][1]) {
                    leftWidth += ((leftCnt - (taller[j][0] + 1)) * leftLeng);
                    // 가장 높은 지점에 도달 -> break
                    if (visited[j])
                        break;

                    leftWidth += taller[j][1];

                    leftLeng = taller[j][1];
                    leftCnt = taller[j][0];
                    visited[j] = true;
                }
            }
        }


        if (N == 1)
            System.out.println(rightWidth);
        else
            System.out.println(leftWidth + rightWidth);
    }

}
