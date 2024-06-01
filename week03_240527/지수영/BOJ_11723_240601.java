package ws0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11723 {
//	static List<Integer> total = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		List<Integer> total = new ArrayList<Integer>();
		int num;
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			if("add".equals(command)) {
				num = Integer.parseInt(st.nextToken());
				if(!total.contains(num)){
					total.add(num);
				}
			}else if("remove".equals(command)) {
				num = Integer.parseInt(st.nextToken());
				total.remove(Integer.valueOf(num));
			}else if("check".equals(command)) {
				num = Integer.parseInt(st.nextToken());
				if(total.contains(num)) {
					sb.append(1).append("\n");
				}else{
					sb.append(0).append("\n");
				}
			}else if("toggle".equals(command)) {
				num = Integer.parseInt(st.nextToken());
				if(total.contains(num)) {
					total.remove(Integer.valueOf(num));
				}else {
					total.add(num);
				}
			}else if("all".equals(command)) {
				total = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
			}else if("empty".equals(command)) {
				total.clear();;
			}
		}
		System.out.println(sb);
	}
	
}
