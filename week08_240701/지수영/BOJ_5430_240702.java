import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5430_240702 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			boolean isError = false;
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			List<Integer> x = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			
			for(int i=0; i<n; i++) {
				x.add(Integer.parseInt(st.nextToken()));
			}
			
			int rCnt = 0;
			
			// R은순서를 뒤집는 함수, D는 첫번째 수를 버리는 함수
			for(int ac = 0; ac < p.length; ac++) {
				if(p[ac] == 'R') {
					rCnt++;
				}else if(p[ac]== 'D') {
					if(x.size()>0) {
						if(rCnt%2 == 0) {							
							x.remove(0);
						}else {
							x.remove(x.size()-1);
						}
					}else {
						// 배열이 비어있는데 D를 사용하면 에러 발생
						if(!isError) {
							sb.append("error").append("\n");
							isError = true;
						}
					}
				}
			}
			if(!isError) {
				sb.append("[");
				
				if(rCnt%2 == 1) {
					Collections.reverse(x);
				}
				for(int num:x) {
					sb.append(num).append(",");
				}
				if(x.size()>0){					
					sb.deleteCharAt(sb.length()-1);
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb);
	}

}
