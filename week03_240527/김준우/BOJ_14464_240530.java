import java.io.*;
import java.util.*;

import org.omg.CosNaming.NamingContextPackage.NotFoundReasonHelper;


class Main {
	static int C, N;
	static int[] chicken_arr;
	static int[][] cow_arr;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();


	public static void main(String args[]) throws IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		chicken_arr = new int[C];
		for (int i = 0; i < C; i++) {
			chicken_arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(chicken_arr);
		cow_arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			int[] cow = new int[2];
			st = new StringTokenizer(br.readLine());
			cow[0] = Integer.parseInt(st.nextToken());
			cow[1] = Integer.parseInt(st.nextToken());
			cow_arr[i] = cow;
		}
		Arrays.sort(cow_arr, (a, b) -> {
			if(a[0] == b[0]) {
				return 0;
			} else return a[0] - b[0];
		});
		
//		for (int i = 0; i < cow_arr.length; i++) {
//			System.out.println(cow_arr[i][0] + " " + cow_arr[i][1]);
//		}
		
		int ans = 0;
		int cow_idx = 0;
		for (int i = 0; i < C; i++) {
			while(cow_idx < N && cow_arr[cow_idx][1] < chicken_arr[i]) {cow_idx++;}
			while(cow_idx < N && cow_arr[cow_idx][0] <= chicken_arr[i] && cow_arr[cow_idx][1] >= chicken_arr[i]) {
				pq.add(cow_arr[cow_idx][1]);
				cow_idx++;
				while(cow_idx < N && cow_arr[cow_idx][1] < chicken_arr[i]) {cow_idx++;}
			}
			while(!pq.isEmpty() && pq.peek() < chicken_arr[i]) {
				pq.poll();
			}
			if(!pq.isEmpty()) {
//				System.out.println(chicken_arr[i]);
				pq.poll();
				ans++;
			}
		}
	
		System.out.println(ans);
	}
}