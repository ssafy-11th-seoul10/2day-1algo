import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] numberCnt = new int[10];
        while (N != 0) {
            int x = N % 10;
            if (x == 9) {
                numberCnt[6]++;
            } else {
                numberCnt[x]++;
            }
            N /= 10;
        }
        if (numberCnt[6] % 2 == 0) {
            numberCnt[6] /= 2;
        } else {
            numberCnt[6] /= 2;
            numberCnt[6]++;
        }
        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, numberCnt[i]);
        }

        System.out.println(max);
    }

}
