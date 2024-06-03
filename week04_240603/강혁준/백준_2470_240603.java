import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		Arrays.sort(arr);
		int left = 0;
		int right = N - 1;
		int savedLeft = arr[left];
		int savedRight = arr[right];

		while (left < right) {
			int sum = arr[left] + arr[right];
			if (Math.abs(savedLeft + savedRight) > Math.abs(arr[left] + arr[right])) {
				savedLeft = arr[left];
				savedRight = arr[right];
			}

			if (sum > 0) {
				right--;
			} else if (sum < 0) {
				left++;
			} else {
				// 바로 종료
				break;
			}
		}

		// output
		System.out.println(savedLeft + " " + savedRight);
	}

}
