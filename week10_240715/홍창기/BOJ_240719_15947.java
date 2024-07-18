import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240719_15947 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        n--;
        int q = n / 14;
        int r = n % 14;

        if (r % 4 == 2 || r % 4 == 3) {
            int k = q + (r % 4 == 2 ? 2 : 1);

            if (k == 1) {
                System.out.println("turu");
            } else if (k == 2) {
                System.out.println("tururu");
            } else if (k == 3) {
                System.out.println("turururu");
            } else if (k == 4) {
                System.out.println("tururururu");
            } else {
                System.out.print("tu+ru*");
                System.out.println(k);
            }
        } else if (r == 0 || r == 12) {
            System.out.println("baby");
        } else if (r == 1 || r == 13) {
            System.out.println("sukhwan");
        } else if (r == 4) {
            System.out.println("very");
        } else if (r == 5) {
            System.out.println("cute");
        } else if (r == 8) {
            System.out.println("in");
        } else if (r == 9) {
            System.out.println("bed");
        }

        br.close();
    }

}
