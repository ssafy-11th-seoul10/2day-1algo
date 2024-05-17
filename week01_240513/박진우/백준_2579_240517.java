package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] stair = new int[N+1];
		
		for(int i = 0; i<N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		int[] score = new int[N+1];
		if(N==1) {
			score[0] = stair[0];
		} else if(N==2) {
			score[1] = stair[1] + stair[0];
		} else {
			score[0] = stair[0];
			score[1] = stair[1] + stair[0];
			score[2] = Math.max(stair[0]+stair[2], stair[1] + stair[2]);
			
			for(int i = 3; i<N+1; i++) {
				score[i] = Math.max(score[i-3]+stair[i]+stair[i-1], score[i-2]+stair[i]);
			} 
		}
		System.out.println(score[N-1]);
	}
}
