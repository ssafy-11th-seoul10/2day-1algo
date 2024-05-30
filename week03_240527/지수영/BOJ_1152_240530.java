package ws0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		while(st.hasMoreTokens()) {
			if(st.nextToken().length()>0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
