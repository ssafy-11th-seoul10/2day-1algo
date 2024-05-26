import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		N = Integer.parseInt(br.readLine());

		// process
		hanoi(N, 1, 2, 3);

		// output
		sb.insert(0, count + "\n");
		System.out.println(sb);
	}

	public static void hanoi(int n, int from, int tmp, int to) {
		if (n == 1) {
			sb.append(from).append(' ').append(to).append('\n');
			count++;
			return;
		}

		// 가장 밑에 있는 원판을 제외한 나머지 원판을 모두 tmp로 옮긴다
		hanoi(n - 1, from, to, tmp);

		// from에 남아있는 가장 마지막 원판을 to로 옮긴다
		sb.append(from).append(' ').append(to).append('\n');
		count++;

		// tmp에 남아있는 모든 원판을 to로 옮긴다
		hanoi(n - 1, tmp, from, to);
	}

}
