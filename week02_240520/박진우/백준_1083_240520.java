package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1083 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N && 0<M; i++) {
			int max= -1;
			int idx = -1;
			for(int j = i; j<N && j<=i+M; j++) {
				if(max < arr[j]) {
					max = arr[j];
					idx = j;
				}
			}
			for(int j = idx; j>i; j--) {
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				M = M-1;
			}
		}
			
		
		for(int i = 0; i<N; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.print(sb);
	}
}
