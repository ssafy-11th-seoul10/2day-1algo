import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://propercoding.tistory.com/318
// 숫자 String 연결 -> 메모리 초과, 자릿수 규칙으로 idx를 값에 매핑하는 문제!
// 이런 유형에 조금 약한듯? 연습해 보기

public class BOJ1790 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        // (1~9) : 9개, (10~99) : 90 * 2 자리수 = 180
        // (100~999) : 900 * 3 자리수 = 2700, (1000~9999) : 9000 * 4 = 36000 ...
        // 이 규칙을 통해, K번째 숫자가 속한 자릿수를 구하고 -> 그 범위에서 K에 해당하는 숫자값 찾기

        // STEP 1. find range
        long numLen = 1; // 1자리수, 2자리수, 3자리수 ...
        long numCnt = 9; // 1자리 : 9개, 2자리 : 90개, ...

        while( K > numCnt * numLen ) { // K가 현재 자리수 범위를 넘는 곳에 위치한 경우
            K -= (numLen * numCnt); // 해당 범위의 숫자를 빼 준다.
            numLen++; // 자리수 증가
            numCnt *= 10; // 해당 자리수의 숫자 개수 증가
        }
        K -= 1; // K = idx, idx = 0 ~ Leng - 1

        // STEP 2. get number[K] using K val & numLen
        // number = (실제 자리수 => 10, 100, 1000 ... ) + (K를 자리수로 나눈 값)
        // 자리수 만큼의 길이를 가진 String append -> 자리수로 나눈 몫만큼 K++ 하여 이동하는 구조!
        long number = (long) Math.pow(10, (numLen - 1)) + (K / numLen);

        if(number > N)
            System.out.println(-1);
        else // 찾은 숫자에 알맞은 digit 출력!
            System.out.println(String.valueOf(number).charAt((int)(K % numLen)));

    }
}
