2중 반복문을 사용한다면 시간초과가 발생할 것이라고 생각했지만 통과된다
현재 가능한 문자열을 저장해서 관리하는 것이아닌 인덱스만 저장시켜서 최적화 시킬 수 있음

-----

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static class StringIdx {
        String value;
        int idx;

        public StringIdx(String value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int K;
    private static int answer = 0;
    private static StringIdx answer1;
    private static StringIdx answer2;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        Map<String, StringIdx> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            if (i == 0) {
                answer1 = new StringIdx(tmp, i);
            } else if (i == 1) {
                answer2 = new StringIdx(tmp, i);
            }
            for (int j = 0; j < tmp.length(); j++) {
                String subString = tmp.substring(0, j + 1);
                if (map.containsKey(subString)) {
                    if (answer < subString.length()) {
                        answer1 = new StringIdx(map.get(subString).value, map.get(subString).idx);
                        answer2 = new StringIdx(tmp, i);
                        answer = subString.length();
                    } else if (answer == subString.length()) {
                        if (answer1.idx > map.get(subString).idx) {
                            answer1 = new StringIdx(map.get(subString).value, map.get(subString).idx);
                            answer2 = new StringIdx(tmp, i);
                            answer = subString.length();
                        } else if (answer1.idx == map.get(subString).idx) {
                            if (answer2.idx > i) {
                                answer1 = new StringIdx(map.get(subString).value, map.get(subString).idx);
                                answer2 = new StringIdx(tmp, i);
                                answer = subString.length();
                            }
                        }
                    }
                } else {
                    map.put(subString, new StringIdx(tmp, i));
                }
            }
        }
        System.out.println(answer1.value);
        System.out.println(answer2.value);
    }

}
