이분탐색
lower bound
  특정한 수가 해당 K값을 만족시킬 수 있는지
  B[K]= x => x이하의 값들을 최소 K개를 갖고있다
  하지만 이 K개를 만족시키는 수가 주어진 B배열에 존재하지 않을 수 있음
  때문에 K를 만족시키는 최소의 수를 뽑아내기 위한 lower bound
  mid값이 주어진 K값 보다 크거나 같다면 => end=mid
  mid값이 주어진 K값 보다 작다면 => start= mid + 1 
    -> start로 정답을 찾기위함 1을 증가시켰을때 while문을 탈출한다면 upper bound 값
  upper bound는?
  mid값이 주어진 K값 보다 크다면 => end=mid - 1
  mid값이 주어진 K값 보다 작거나 같다면 => start= mid 

-----

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, K;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long start = 1;
        long end = (long) N * N;
        while (start < end) {

            long mid = (start + end) / 2;
            long midCnt = getMidCnt(mid);
            System.out.println(start + " " + end + " " + mid + " " + midCnt);

            if (K <= midCnt) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }

    private static long getMidCnt(long mid) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.min(N, mid / i);
        }
        return sum;
    }


}
