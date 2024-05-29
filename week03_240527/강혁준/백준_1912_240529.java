import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// process
		int max = arr[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i + 1] + arr[i] > arr[i]) {
				arr[i] = arr[i + 1] + arr[i];
			}
			max = Math.max(max, arr[i]);
		}

		// output
		System.out.println(max);
	}

}
