import java.io.*;
import java.util.*;

public class Main {

    private static final List<Integer> primes = new ArrayList<>(1300);
    static {
        boolean[] sieve = new boolean[100001];

        for (int i = 2; i <= 100000; i++){
            if (!sieve[i]){
                primes.add(i);
            }

            for (int j = i * 2; j <= 100000; j += i){
                sieve[j] = true;
            }
        }
    }

    private static boolean isPrime(int n){
        return Collections.binarySearch(primes, n) >= 0;
    }

    private static int getNumberOfCoprime(int n){
        int cnt = 0;

        for (int p : primes){
            while (n % p == 0){
                n /= p;
                cnt++;
            }
            if (n == 1) break;
        }
        return cnt;
    }

    private static int getNumberOfUnderPrime(int a, int b){
        int cnt = 0;

        for (int n = a; n <= b; n++){
            if (isPrime(getNumberOfCoprime(n))){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(getNumberOfUnderPrime(a, b));
    }

}
