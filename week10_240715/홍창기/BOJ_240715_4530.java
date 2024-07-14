import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_240715_4530 {

    public static void main(String[] args) throws IOException {
        int[] sieve = new int[1000001];

        // 1. 소수
        sieve[1] = 1;

        for (int i = 2; i <= 1000000; i++) {
            if (sieve[i] == 1) {
                continue;
            }

            for (int ii = i * 2; ii <= 1000000; ii += i) {
                sieve[ii] = 1;
            }
        }

        for (int i = 1; i <= 1000000; i++) {
            sieve[i] ^= 1;

            // 5. 합배수
            int d = 0;
            int ii = i;

            while (ii > 0) {
                d += ii % 10;
                ii /= 10;
            }

            if (i % d == 0) {
                sieve[i]++;
            }

            // 6. 곱배수
            d = 1;
            ii = i;

            while (ii > 0) {
                d *= ii % 10;
                ii /= 10;
            }

            if (d != 0 && i % d == 0) {
                sieve[i]++;
            }
        }

        for (int i = 1; i <= 1000; i++) {
            // 2. 제곱수
            int i2 = i * i;
            sieve[i2]++;

            if (i <= 100) {
                // 3. 세제곱수
                int i3 = i2 * i;
                sieve[i3]++;

                // 4. 네제곱수
                int i4 = i2 * i2;

                if (i4 <= 1000000) {
                    sieve[i4]++;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int ti = 1; ti <= t; ti++) {
            int n = Integer.parseInt(br.readLine());
            int[] numbers = new int[n];
            int[] sieve2 = new int[1000001];

            for (int ni = 0; ni < n; ni++) {
                int x = Integer.parseInt(br.readLine());
                numbers[ni] = x;

                // 7. 약수
                for (int i = 2, ie = (int) Math.sqrt(x); i <= ie; i++) {
                    if (x % i == 0) {
                        sieve2[i] |= 1;
                        sieve2[x / i] |= 1;
                    }
                }

                if (x != 1) {
                    sieve2[1] |= 1;
                }

                // 8. 배수
                for (int xx = x * 2; xx <= 1000000; xx += x) {
                    sieve2[xx] |= 2;
                }

                // 9. 사과제곱수
                if (x != 1 && x <= 1000) {
                    int x2 = x * x;
                    sieve2[x2] |= 4;

                    // 10. 사과세제곱수
                    if (x <= 100) {
                        int x3 = x2 * x;
                        sieve2[x3] |= 8;

                        // 11. 사과네제곱수
                        int x4 = x2 * x2;

                        if (x4 <= 1000000) {
                            sieve2[x4] |= 16;
                        }
                    }
                }

                // 12. 사과합배수
                int d = 0;
                int xx = x;

                while (xx > 0) {
                    d += xx % 10;
                    xx /= 10;
                }

                for (int dd = d * 2; dd <= 1000000; dd += d) {
                    if (dd != x) {
                        sieve2[dd] |= 32;
                    }
                }

                // 13. 사과곱배수
                d = 1;
                xx = x;

                while (xx > 0) {
                    d *= xx % 10;
                    xx /= 10;
                }

                if (d != 0) {
                    for (int dd = d * 2; dd <= 1000000; dd += d) {
                        if (dd != x) {
                            sieve2[dd] |= 64;
                        }
                    }
                }
            }

            int maxInteresting = 0;
            ArrayList<Integer> answers = new ArrayList<Integer>();

            for (int num : numbers) {
                int interesting = sieve[num] + (sieve2[num] & 1) + ((sieve2[num] & 2) >> 1) + ((sieve2[num] & 4) >> 2) + ((sieve2[num] & 8) >> 3) + ((sieve2[num] & 16) >> 4) + ((sieve2[num] & 32) >> 5) + ((sieve2[num] & 64) >> 6);

                if (interesting > maxInteresting) {
                    answers.clear();
                    answers.add(num);
                    maxInteresting = interesting;
                } else if (interesting == maxInteresting) {
                    answers.add(num);
                }
            }

            Collections.sort(answers);
            sb.append("DATA SET #").append(ti).append("\n");

            for (int ans : answers) {
                sb.append(ans).append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

}
