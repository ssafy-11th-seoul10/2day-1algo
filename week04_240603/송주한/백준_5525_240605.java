package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon5525 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		String str = in.readLine();
		
		int cnt =0;
		int num=0;
		for(int i=1;i<m-1;i++) {
			if(str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
				cnt++;
				if(cnt == n) {
                    if(str.charAt(i-(cnt*2-1)) == 'I')
                    	num++;
                    cnt--;
                }
				
				i++;
			}else {
				cnt=0;
			}
		}
		
		System.out.println(num);
	}
}
