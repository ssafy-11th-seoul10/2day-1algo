package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj26577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			System.out.println(eval(br.readLine()));
		}
		
	}
	public static int eval(String expression) {
        try {
            return(int) new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression);
        } catch (Exception e) {
            return 0;
        }
    }
}
