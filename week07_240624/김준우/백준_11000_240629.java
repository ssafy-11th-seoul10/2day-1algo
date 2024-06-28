import java.io.*;
import java.util.*;



class Main {
	static int N, maxs = 0;
	static int[][] arr;
	static PriorityQueue<int[]> pq_desc = new PriorityQueue<int[]>((o1, o2) -> {
		if (o1[0] == o2[0]) return 0;
		return o1[0] - o2[0];
	});
	static PriorityQueue<Integer> pq_asc = new PriorityQueue<Integer>((o1, o2)-> {
		return o1 - o2;
	});

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			pq_desc.add(arr[i]);
		}
		
		while(!pq_desc.isEmpty()) {
			int[] sc = pq_desc.poll();
			if (!pq_asc.isEmpty() && pq_asc.peek() <= sc[0]) {
				pq_asc.poll();
			}
			pq_asc.add(sc[1]);
			if (pq_asc.size() > maxs) {
				maxs = pq_asc.size();
			}
		}
		System.out.println(maxs);
		
	}
}