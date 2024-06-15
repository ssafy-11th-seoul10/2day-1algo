import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정렬 후 투 포인터
 */
public class BOJ2467 {

    /**
     * 정렬 후 투 포인터
     * 만약 최소값을 갱신시키지 못했을 경우 f와 b의 절대값 비교
     * case1: f가 b보다 큰 경우 front 1 증가
     * case2: b가 f보다 큰 경우 back 1 감소
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int min = 2_000_000_001;
        int front = 0;
        int back = N-1;
        int answer1 = 0;
        int answer2 = N-1;
        while (back>front){
            int f = arr[front];
            int b = arr[back];
            int curr = Math.abs(f+b);
            if(min>curr){
                min = curr;
                answer1 = f;
                answer2 = b;
            }
            int af = Math.abs(f);
            int ab = Math.abs(b);
            if(af>ab){
                front++;
            }else{
                back--;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }

}
