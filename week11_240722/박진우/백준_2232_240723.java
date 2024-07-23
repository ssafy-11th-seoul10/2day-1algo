package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj2232 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int mine[] = new int[N];
		int index[][] = new int[N][2];
		for(int i = 0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			mine[i] = n;
			index[i][0] = n;
			index[i][1] = i;
		}
		
		ArrayList<Integer> AL = new ArrayList<>();
		
		Arrays.sort(index, (o1, o2) -> {
			return o2[0]-o1[0];
		});

		for(int i = 0; i<N; i++) {
			if(mine[index[i][1]]!=0) {
				AL.add(index[i][1]+1);
				int left = index[i][1];
				int right = index[i][1];
				int power = mine[left];
				while(left>0) {
					left--;
					if(mine[left]>=power) {
						break;
					} else {
						power = mine[left];
						mine[left] = 0;
					}
				}
				power = mine[right];
				while(right<N-1) {
					right++;
					if(mine[right]>=power) {
						break;
					} else {
						power = mine[right];
						mine[right] = 0;
					}
				}
				mine[index[i][1]] = 0;
			}
		}
		int al[] = new int[AL.size()];
		for(int i = 0; i<AL.size(); i++) {
			al[i] = AL.get(i);
		}
		Arrays.sort(al);
		for(int i = 0; i<AL.size(); i++) {
			sb.append(al[i]).append("\n");
		}
		System.out.print(sb);
	}
}
