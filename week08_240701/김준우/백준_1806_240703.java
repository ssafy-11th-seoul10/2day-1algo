import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, S, mini;
	static int[] arr, cumul;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N+1]; cumul = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cumul[i] = cumul[i-1] + arr[i];
		}
		int start = 0;
		int end = 1;
		mini = N+1;
		for (int i = 0; i < N; i++) {
			while(end < N+1 && cumul[end] - cumul[start] < S) {
				end++;
			}
			if (end == N+1) { 
				break;
			} else if (mini > end - start) { 
				mini = end - start;
			}
			start++;
		}
		if (mini == N+1) { 
			System.out.println(0);
		} else {
			System.out.println(mini);
		}
	}
}




