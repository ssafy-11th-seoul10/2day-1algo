import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727_240626 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] W = new int[1001];
		
		W[0] = 0;
		W[1] = 1;
		W[2] = 3;
		W[3] = 5;
		
		for (int i = 4; i < 1001; i++) {
			W[i] = (W[i-1]+W[i-2]*2)%10007;
		}
		
		System.out.println(W[n]);
	}
}
