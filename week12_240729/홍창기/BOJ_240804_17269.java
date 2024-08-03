import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240804_17269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();

        int[] alphaToInt = { 3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
        int[] arr = new int[n + m];
        int i = 0;
        int k = 0;

        while (i < n && i < m) {
            arr[k++] = alphaToInt[a.charAt(i) - 'A'];
            arr[k++] = alphaToInt[b.charAt(i) - 'A'];
            i++;
        }

        while (i < n) {
            arr[k++] = alphaToInt[a.charAt(i) - 'A'];
            i++;
        }
        
        while (i < m) {
            arr[k++] = alphaToInt[b.charAt(i) - 'A'];
            i++;
        }

        while (k > 2) {
            for (int j = 1; j < k; j++) {
                arr[j - 1] += arr[j];

                if (arr[j - 1] >= 10) {
                    arr[j - 1] -= 10;
                }
            }

            k--;
        }

        int ans = arr[0] * 10 + arr[1];
        System.out.printf("%d%%%n", ans);
        br.close();
    }

}
