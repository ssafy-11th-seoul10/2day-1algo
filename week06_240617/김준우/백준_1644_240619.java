import java.io.*;
import java.util.*;



class Main {
	static int N;
	static List<Integer> primes = new ArrayList<>();
	static long[] sum;
	static int large = 0, small = 0;
	
	
	public static void make_primes() {
		primes.add(2);
		int now = 3;
		re : while (now < 4_000_000) {
			for (Integer p : primes) {
				if (p * p > now) {
					primes.add(now);
					now++;
					continue re;
				}
				if (now % p == 0) {
					now++;
					continue re;
				}
			}
			primes.add(now);
			now++;
		}
	}
	
	public static void make_cumulative_sum() {
		sum = new long[primes.size()+1];
		sum[0] = 0;
		for (int i = 1; i < primes.size()+1; i++) {
			sum[i] = sum[i-1] + primes.get(i-1);
		}
	}
	
	public static void up() {
		while (large < primes.size() && sum[large] - sum[small] < N) {
			large++;
		}
	}
	
	public static void down() {
		while (small < primes.size() && sum[large] - sum[small] > N) {
			small++;
		}
	}
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		make_primes();
		make_cumulative_sum();
		int ans = 0;
		while (large < primes.size()) {
			up();
			if (sum[large] - sum[small] == N) {
				ans++; large++;
			}
			down();
			if (sum[large] - sum[small] == N) {
				ans++; large++;
			}
		}
		System.out.println(ans);
//		for(Integer p : primes) {
//			System.out.print(p +" ");
//		}
	}
}