import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_240725_9753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] sieve = new boolean[50001];
        ArrayList<Integer> primes = new ArrayList<Integer>();

        for (int i = 2; i <= 50000; i++) {
            if (!sieve[i]) {
                primes.add(i);

                for (int j = i + i; j <= 50000; j += i) {
                    sieve[j] = true;
                }
            }
        }

        ArrayList<Integer> primeProducts = new ArrayList<Integer>();

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                long primeProduct = (long) primes.get(i) * primes.get(j);

                if (primeProduct <= 100001L) {
                    primeProducts.add((int) primeProduct);
                }
            }
        }

        Collections.sort(primeProducts);
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(primeProducts.get(lowerBound(primeProducts, n))).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static int lowerBound(ArrayList<Integer> arr, int key) {
        int low = -1;
        int high = arr.size();

        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) >= key) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

}
