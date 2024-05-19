package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().trim().toCharArray();
		int arr[] = new int[c.length];
		arr[0] = 1;
		boolean isTrue = false;
		if(c[0]=='0') {
			System.out.println(0);
		} else {
			for(int i = 1; i<c.length; i++) {
				if(c[i]>'0') {
					arr[i] = arr[i-1]%1000000;
				}
				if(c[i-1]=='1' || (c[i-1]=='2' && c[i]<='6')) {
					if(isTrue)
						arr[i] = arr[i] + arr[i-2];
					else
						arr[i] = arr[i] + arr[i-1];
					isTrue = true;
				} else
					isTrue = false;
			}
			System.out.println(arr[c.length-1]%1000000);
		}
		
		
	}
}
