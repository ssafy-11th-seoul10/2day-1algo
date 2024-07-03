import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240703_16974 {

    static long recur(int n, long x) {
        if (n == 0) {
            return x >= 1 ? 1 : 0;
        }

        if (x <= 1) {
            return 0;
        }

        long half = (1L << (n + 1)) - 1;

        if (x < half - 1) {
            return recur(n - 1, x - 1);
        }

        if (x == half - 1) {
            return (1L << n) - 1;
        }

        if (x == half) {
            return (1L << n);
        }

        if (x < half * 2) {
            return (1L << n) + recur(n - 1, x - half);
        }

        return (1L << (n + 1)) - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        System.out.println(recur(n, x));
    }

}
