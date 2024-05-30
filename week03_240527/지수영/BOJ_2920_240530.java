package ws0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Boolean a = true;
		Boolean d = true;
		
		int first = Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens()) {
			int next = Integer.parseInt(st.nextToken());
			if(first > next) {
				a = false;
			}else {
				d = false;
			}
			first = next;
		}
		
		if(a && !d) {
			System.out.println("ascending");
		}else if(!a && d) {
			System.out.println("descending");
		}else{
			System.out.println("mixed");
		}
	}

}
