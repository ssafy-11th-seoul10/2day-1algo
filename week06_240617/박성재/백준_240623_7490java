import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_7490_2 {
    static char[] expression = {'-', '+', ' '};
    static int tc;
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        Arrays.sort(expression);

        tc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            dfs(1, "1");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, String s){
        if(depth == n){
            String s1 = s.replaceAll(" ", "");
            StringTokenizer divideS1 = new StringTokenizer(s1, "-|+", true);
            int sum = Integer.parseInt(divideS1.nextToken());

            while(divideS1.hasMoreTokens()){
                String op = divideS1.nextToken();

                if(op.equals("+")){
                    sum += Integer.parseInt(divideS1.nextToken());
                }else{
                    sum -= Integer.parseInt(divideS1.nextToken());
                }

            }

            if(sum == 0) sb.append(s).append("\n");

            return;
        }

        for (int i = 0; i < 3; i++) {
            dfs(depth + 1, s + expression[i] + (depth + 1));
        }

    }
}
