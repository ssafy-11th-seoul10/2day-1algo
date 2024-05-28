import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class hepca {
	static class Info {
		String name;
		int date;
		int cost;
 
		public Info(String name, int date, int cost) {
			this.name = name;
			this.date = date;
			this.cost = cost;
		}
	}
 
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
 
		StringTokenizer st;
		
		boolean chk[] = new boolean[78];
 
		List<Info> info = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String s = st.nextToken();
			int w = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			w--;
			info.add(new Info(s, w * 7 + d, p));
		}
		
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(in.readLine());
			String s2 = st.nextToken();
			int p = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < n ; j ++) {
				if(info.get(j).name.equals(s2) && p >= info.get(j).cost) {
					chk[info.get(j).date] = true;
					break;
				}
			}
		}
		
		int cnt = 0 ;
		int ans = 0;
		for(int i = 0 ; i < 78; i ++) {
			if(chk[i] == true) {
				cnt ++;
			} else {
				ans = Math.max(ans, cnt);
				cnt = 0;
			}
		}
		System.out.println(ans);
	}
}
