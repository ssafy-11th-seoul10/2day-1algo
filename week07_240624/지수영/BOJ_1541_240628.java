import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541_240628 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] minus = br.readLine().split("-");

		int answer = 0;
		boolean startMinus = false;
		
		for (int i = 0; i < minus.length; i++) {
			if(minus[i] == "") {
				startMinus = true;
				continue;
			}else {				
				String[] plus = minus[i].split("\\+");
				int temp = 0;
				for(int p = 0; p < plus.length; p++) {
					temp += Integer.parseInt(plus[p]);
				}
				if(i == 0 && !startMinus) {
					answer += temp;
				}else {
					answer -= temp;
				}
			}
		}
		System.out.println(answer);
	}

}
