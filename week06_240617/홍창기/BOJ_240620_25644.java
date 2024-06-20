import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240620_25644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int minVal = 1000000000;
        int maxIncr = 0;

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (val < minVal) {
                minVal = val;
            }

            if (val - minVal > maxIncr) {
                maxIncr = val - minVal;
            }
        }

        System.out.println(maxIncr);
        br.close();
    }

}
