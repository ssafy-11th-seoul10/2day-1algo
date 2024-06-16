import java.io.*;
import java.util.*;



class Main {
	static int T;
	static int N, K;
	static Node[] nodelist;
	
	static class Node {
		List<Integer> child;
		int time, max_time, parent_size;
		Node(int time) {
			this.child = new LinkedList<Integer>();
			this.parent_size = 0;
			this.time = time;
			this.max_time = time;
		}
	}

	public static void update(int num) {
//		System.out.println("update start : " + num);
//		System.out.println(nodelist[num].child.size());
		for(Integer ch : nodelist[num].child) {
			nodelist[ch].parent_size--;
			if (nodelist[ch].max_time < nodelist[num].max_time + nodelist[ch].time) {
				nodelist[ch].max_time = nodelist[num].max_time + nodelist[ch].time;
//				System.out.println("number : " + ch + ", max_time : " + nodelist[ch].max_time);
//				System.out.println("parent_size : " + nodelist[ch].parent_size);
			}
			if (nodelist[ch].parent_size == 0) {
				update(ch);
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 건물의 수
			K = Integer.parseInt(st.nextToken()); // 순서의 수
			st = new StringTokenizer(br.readLine());
			nodelist = new Node[N+1];
			for (int i = 1; i < N+1; i++) {
				nodelist[i] = new Node(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int before = Integer.parseInt(st.nextToken());
				int after = Integer.parseInt(st.nextToken());
				nodelist[before].child.add(after);
				nodelist[after].parent_size++;
			}
			int W = Integer.parseInt(br.readLine());
			
			for (int i = 1; i < N+1; i++) {
				if (nodelist[i].parent_size == 0) {
					update(i);
//					System.out.println("----");
				}
			}
			
			if (nodelist[W].max_time == 0) {
				sb.append(nodelist[W].time).append("\n");
			} else {
				sb.append(nodelist[W].max_time).append("\n");
			}
		}
		System.out.println(sb);
		
//		for (int i = 1; i < 1+N; i++) {
//			System.out.print(nodelist[i].max_time);
//			System.out.print(" ");
//		}
	}
}