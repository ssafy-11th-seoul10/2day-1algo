import java.io.*;
import java.util.*;



class Main {
	static int N;
	static int arrows[][];
	static boolean arrows_valid[][];
	static int[] total_receive;
	static int ttl = 0;
	static Set<Integer> ans_set = new HashSet<Integer>();

	public static boolean dfs(int start_node, int now_node) {
		if (arrows_valid[now_node][0] == false && arrows_valid[now_node][1] == false) {
			if (start_node == now_node) {
				// finish
				return true;
			} else {
				// reset
				return false;
			}
		}
		
		if (arrows_valid[now_node][0]) {
			arrows_valid[now_node][0] = false;
			if(dfs(start_node, arrows[now_node][0])) {
				ttl++;
				ans_set.add(now_node);
				return true;
			} else {
				arrows_valid[now_node][0] = true;
				return false;
			}
		} else if (arrows_valid[now_node][1]) {
			arrows_valid[now_node][1] = false;
			if (dfs(start_node, arrows[now_node][1])) { 
				ttl++;
				ans_set.add(now_node);
				return true;
			} else {
				arrows_valid[now_node][1] = true;
				return false;
			}
		}
		return false;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arrows_valid = new boolean[N+1][2];
		arrows = new int[N+1][2];
		total_receive = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arrows[i][0] = Integer.parseInt(st.nextToken());
			total_receive[arrows[i][0]]++;
			arrows[i][1] = Integer.parseInt(st.nextToken());
			total_receive[arrows[i][1]]++;
			Arrays.fill(arrows_valid[i], true);
		}
		for (int i = 1; i < N+1; i++) {
			if (total_receive[i] < 2) {
				arrows_valid[i][0] = false;
				arrows_valid[i][1] = false;
			}
		}
		
		
		
		for (int i = 1; i < N+1; i++) {
//			Stack<Integer> stack = new Stack<Integer>();
//			stack.add(i);
			dfs(i, i);
		}
		System.out.println(ttl / 2);
		List<Integer> li = new ArrayList<Integer>(ans_set);
		Collections.sort(li);
		StringBuilder sb = new StringBuilder();
		for(Integer a : li) sb.append(a).append(" ");
		System.out.println(sb);
	}
}