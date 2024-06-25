import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_240625 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] way = new int[10002];
		
		way[0] = 0;
		way[1] = 1;
		way[2] = 2;
		way[3] = 3;
		
		for (int i = 4; i < 1002; i++) {
			way[i] = (way[i-1]+way[i-2])%10007;
		}
		
		System.out.println(way[n]);
		
	}

}
