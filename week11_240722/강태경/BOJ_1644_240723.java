import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1644_240723 {

    static void findPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(isPrime[i])
                for (int j = i*i; j <=n ; j+=i) {
                    isPrime[j] = false;
                }
        }
    }

    static int n;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {

        //투포인터
        //2부터 해당 수 까지 소수 확인
        //리스트 안에서 투 포인터
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isPrime = new boolean[n + 1];
        for (int i = 2; i <n+1 ; i++) {
            isPrime[i] = true;
        }
        findPrime(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < n+1; i++) {
            if(isPrime[i]) list.add(i);
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int answer = 0;
        while(true){
            if(sum<=n){
                if(sum==n) answer++;
                if(end==list.size()) break;
                sum+=list.get(end);
                end++;
            } else{
                sum -= list.get(start);
                start++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(answer);
    }
}
