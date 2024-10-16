import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int answer = Integer.MAX_VALUE;
    private static List<Integer> down = new ArrayList<>();
    private static List<Integer> up = new ArrayList<>();


    private static int resultDiff = Integer.MAX_VALUE;
    private static int resultUpVal = -1;
    private static int resultDownVal = -1;

    public static void main(String[] args) throws IOException {
        inputSetting();
        Collections.sort(down);
        Collections.sort(up);
        /*
         *   용액이 양쪽에 존재해도 한 용액만 사용하는 엣지케이스 존재
         * */
        if (up.size() >= 2 && Math.abs(up.get(0) + up.get(1)) < resultDiff) {
            resultDiff = Math.abs(up.get(0) + up.get(1));
            resultDownVal = up.get(0);
            resultUpVal = up.get(1);
        }
        if (down.size() >= 2 && Math.abs(down.get(down.size() - 1) + down.get(down.size() - 2)) < resultDiff) {
            resultDiff = Math.abs(down.get(down.size() - 1) + down.get(down.size() - 2));
            resultDownVal = down.get(down.size() - 2);
            resultUpVal = down.get(down.size() - 1);
        }
        findEach();
    }

    private static void findEach() {


        for (int i = 0; i < up.size(); i++) {
            int upVal = up.get(i);
            int start = 0;
            int end = down.size() - 1;
            while (start <= end) {
//                System.out.println(start + " " + end);
                int mid = (start + end) / 2;
                int curDiff = upVal + down.get(mid);
                if (curDiff <= 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
//                System.out.println("resultDiff : " + resultDiff);
//                System.out.println("Math.abs(curDiff) : " + Math.abs(curDiff));
//                System.out.println("up.get(i) : " + up.get(i));
//                System.out.println("down.get(mid) : " + down.get(mid));
//                System.out.println();
                if (resultDiff > Math.abs(curDiff)) {
                    resultDiff = Math.abs(curDiff);
                    resultUpVal = up.get(i);
                    resultDownVal = down.get(mid);
                }
            }
        }
        System.out.println(resultDownVal + " " + resultUpVal);
    }

    private static void inputSetting() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp < 0) {
                down.add(tmp);
            } else {
                up.add(tmp);
            }
        }
    }


}
