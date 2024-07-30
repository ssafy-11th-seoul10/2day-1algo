import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main { 
	static int[] numbers = new int[] {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
	
	
	public static int[] canCompose(int n) {
		int arr[] = new int[2];
		while(n >= 6) {
			n -= 6;
			arr[0]++;	
		}
		if (n <= arr[0]) {
			arr[0]-=n;
			arr[1]+=n;
		} else {
			return null;
		}
		return arr;
		
	}
	
	public static void main(String args[]) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			//작은 수
			if (a == 2) {
				sb.append("1");
			} else if (a == 3) {
				sb.append("7");
			} else if (a == 4) {
				sb.append("4");
			} else if (a == 5) {
				sb.append("2");
			} else if (a == 6) {
				sb.append("6");
			} else if (a == 7) {
				sb.append("8");
			} else {
				List<Integer> li = new ArrayList<Integer>();
				int sa = a;
				int eight = 0;
				while (sa >= 7) { 
					eight++;
					sa -= 7;
				}
				if (sa == 1) {
					eight--;
					li.add(1);
					li.add(0);
				} else if (sa == 2){
					li.add(1);
				} else if (sa == 3) {
					if (eight == 1) {
						li.add(2);li.add(2);
						eight--;
					} else {
						li.add(2);li.add(0); li.add(0);
						eight-=2;
					}
				} else if (sa == 4 ) {
					li.add(2);li.add(0);
					eight--;
				} else if (sa == 5) {
					li.add(2);
				} else if (sa == 6) {
					li.add(6);
				}
				for (int j = 0; j < eight; j++) {
					li.add(8);
				}
				Collections.sort(li);
								
				for (int j = 0; j < li.size(); j++) {
					if (li.get(j) > 0) {
						sb.append(li.get(j));
						li.remove(j);
						break;
					}
				}
				for (int j = 0; j < li.size(); j++) {
					sb.append(li.get(j));
				}
			}
			sb.append(" ");
			
			
			// 큰 수
			if (a % 2 == 0) {
				for (int j = 0; j < a / 2; j++) {
					sb.append("1");
				}
			} else { 
				sb.append("7");
				for (int j = 0; j < a / 2 - 1; j++) {
					sb.append("1");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}