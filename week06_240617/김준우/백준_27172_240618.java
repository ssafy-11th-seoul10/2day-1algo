import java.io.*;
import java.util.*;



class Main {
	static int N;
	static int[] cards, score, num2idx;
	
	public static void simulate(int num) {
		int cnt = 2;
		while (num * cnt < 1_000_001 ) {
			if (num2idx[num*cnt] > -1) {
				int big_index = num2idx[num*cnt];
				score[big_index] -= 1;

				int small_index = num2idx[num];
				score[small_index] += 1;
			}
			cnt++;
		}
	}
	
	
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		cards = new int[N];
		score = new int[N];
		num2idx = new int[1_000_001];
		Arrays.fill(num2idx, -1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			num2idx[cards[i]] = i;
		}
		Arrays.sort(cards);
		for (int i = 0; i < N; i++) {
			simulate(cards[i]);
		}
		for (int i = 0; i < N; i++) {
			sb.append(score[i]).append(" ");
		}
		System.out.println(sb);
	}
}