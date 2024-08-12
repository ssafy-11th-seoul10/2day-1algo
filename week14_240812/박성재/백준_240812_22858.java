import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_240812_22858 {
    static int n;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            arr = shuffle(arr);
        }

        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    static int[] shuffle(int[] arr) {
        int[] newArr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = d[i];
            newArr[num] = arr[i];
        }

        return newArr;
    }
}
