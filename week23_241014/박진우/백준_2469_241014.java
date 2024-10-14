package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2469 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		String start = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		start = start.substring(0, K);
		
		String result =  br.readLine();
		
		char[] startc = start.toCharArray();
		char[] resc = result.toCharArray();
		
		String map[] = new String[N];
		
		int questionMark = 0;
		
		for(int i = 0; i<N; i++) {
			map[i] = br.readLine();
			if(map[i].charAt(0)=='?') { 
				questionMark = i;
			}
		}
		for(int i = 0; i<questionMark; i++) {
			for(int j = 0; j<K-1; j++) {
				if(map[i].charAt(j)=='-') {
					char temp = startc[j];
					startc[j]= startc[j+1];
					startc[j+1] = temp;
				}
			}
		}
		
		for(int i = N-1; i>questionMark; i--) {
			for(int j = 0; j<K-1; j++) {
				if(map[i].charAt(j)=='-') {
					char temp = resc[j];
					resc[j]= resc[j+1];
					resc[j+1] = temp;
				}
			}
		}
		
		char[] answer = new char[K];
		for(int i = 0; i<K-1; i++) {
			if(resc[i]!=startc[i]) {
				char temp = startc[i];
				startc[i] = startc[i+1];
				startc[i+1] = temp;
				answer[i] = '-';
			} else {
				answer[i] = '*';
			}
		}
		boolean isTrue = true;
		for(int i = 0; i<K; i++) {
			if(startc[i]!=resc[i]) {
				isTrue = false;
			}
		}
		
		for(int i = 0; i<K-2; i++) {
			if(answer[i]=='-'&&answer[i+1]=='-') {
				isTrue = false;
			}
		}
		if(!isTrue) {
			for(int i = 0; i<K-1; i++)
				System.out.print('x');
		} else 
			for(int i = 0; i<K-1; i++) {
				System.out.print(answer[i]);
			}
		
	}
}
