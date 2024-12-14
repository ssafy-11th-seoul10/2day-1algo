import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int answer = 0;
    private static int N, D, K, C;
    private static List<Integer> susiBelt = new ArrayList<>();
    private static int[] susiCnt = new int[3333];

    public static void main(String[] args) throws IOException {
        /*
         *   입력
         * */
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            susiBelt.add(Integer.parseInt(br.readLine()));
        }
        /*
         *   회전을 확인하기위한 추가적인 K개 초밥 추가
         * */
        for (int i = 0; i < K; i++) {
            susiBelt.add(susiBelt.get(i));
        }
        /*
         *   투포인터 세팅
         * */
        int start = 0;
        int curSum = 0;
        for (int i = 0; i < K; i++) {
            if (susiCnt[susiBelt.get(i)] == 0) {
                curSum++;
            }
            susiCnt[susiBelt.get(i)]++;
        }
        if (susiCnt[C] == 0) {
            answer = Math.max(answer, curSum + 1);
        } else {
            answer = Math.max(answer, curSum);
        }
        /*
         *   투포인터 시작
         * */
        for (int i = K; i < susiBelt.size(); i++) {
            susiCnt[susiBelt.get(start)]--;
            if (susiCnt[susiBelt.get(start)] == 0) {
                curSum--;
            }
            start++;
            if (susiCnt[susiBelt.get(i)] == 0) {
                curSum++;
            }
            susiCnt[susiBelt.get(i)]++;
//            System.out.println(Arrays.toString(susiCnt));
            if (susiCnt[C] == 0) {
//                System.out.println("여기");
                answer = Math.max(answer, curSum + 1);
            } else {

                answer = Math.max(answer, curSum);
            }
        }
        System.out.println(answer);
    }

}
