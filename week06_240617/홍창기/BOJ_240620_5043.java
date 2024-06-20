import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240620_5043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (n <= (1L << (b + 1)) - 1) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        br.close();
    }

}
