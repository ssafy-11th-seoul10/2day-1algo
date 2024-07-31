package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2910 {

    static int N, C;

    static Map<Integer, Integer> dataDict = new HashMap<>();
    static Map<Integer, Integer> seqDict = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            dataDict.merge(temp, 1, Integer::sum);
            // 두 번째 Map, 순서를 보장 하는 HashMap!
            if(seqDict.get(temp) == null )
                seqDict.put(temp, i+1);
        }

        List<Integer> keySet = new ArrayList<>(dataDict.keySet());

        keySet.sort((n1, n2) -> {
            // 만약 횟수가 같다면 -> 순서 지키기 ( 순서 작은 순 )
            if(dataDict.get(n2).equals(dataDict.get(n1)))
                return seqDict.get(n1) - seqDict.get(n2);
            // 큰 순서 대로..
            return dataDict.get(n2) - dataDict.get(n1);
        });

        StringBuilder sb = new StringBuilder();
        for(int key : keySet)
            for(int tmp = 0; tmp < dataDict.get(key); tmp++)
                sb.append(key).append(" ");

        System.out.println(sb);
    }
}
