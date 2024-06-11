import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();


    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());
        System.out.println(findRemainder(A, B, C));
    }

    private static long findRemainder(int A, int B, int C) {
        long tmp = 1;
        for (int i = 1; i <= B; i++) {
            tmp *= A;
            if (tmp > C) {
                return findRemainder((int) (tmp % C), B / i, C) * (int) Math.pow(A, B % i) % C;
            }
        }
        return tmp % C;
    }

}
