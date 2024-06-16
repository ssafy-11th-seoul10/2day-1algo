import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240613_1268 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] info = new int[n][6];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= 5; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int j = 1; j <= 5; j++) {
                    if (info[a][j] == info[b][j]) {
                        info[a][0]++;
                        info[b][0]++;
                        break;
                    }
                }
            }
        }

        int maxScore = 0;
        int maxStudent = 1;

        for (int i = 0; i < n; i++) {
            if (info[i][0] > maxScore) {
                maxScore = info[i][0];
                maxStudent = i + 1;
            }
        }

        System.out.println(maxStudent);
        br.close();
    }

}
