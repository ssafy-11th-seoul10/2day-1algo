import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] addNum = {1,3,7,9};

    static void sol(int depth) {
        if(depth == N) {
            if(isPrime(sb.toString())) {
                System.out.println(sb.toString());
            }
            return;
        }
        if(isPrime(sb.toString())) {
            for(int i : addNum) {
                sb.append(i);
                sol(depth+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    static boolean isPrime(String str) {
        int num = Integer.parseInt(str);
        if(num == 1) {
            return false;
        }
        if(num == 2) {
            return true;
        }
        int num2 = (int) Math.sqrt(num);
        for(int i=2; i<=num2+1; i+=1) {
            if(num%i==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=2; i<=9; i++) {
            sb.append(i);
            sol(1);
            sb.deleteCharAt(0);
        }

    }
}