모든 정점을 연결하는 간선들의 모음(신장트리)의 최소(최소신장트리)
크루스칼 알고리즘 + 유니온 파인드
크루스칼 : 간선중심
  그리디
  가중치가 작은 간선끼리 연결
  사이클 발생 X
유니온 파인드 : 사이클이 형성되었는지 확인
  DP적으로 구현
  간선을 선택했을때 그 간선의 양방향의 정점들이 하나의 그래프에 속해있는지 확인
  dp배열에는 루트 정점을 저장
  find 메서드를 통해 루트 정점을 가져옴
    추가적으로 return 과정을 거치며 dp에 저장하는 방식을 사용해서 경로 압축
  union메서드를 통해 병합
    작은 쪽으로 저장하는 것을 추천(기준이 있어야 효율적)
    두 정점의 dp 값을 비교해서 확인
    더 작은 루트 정점의 dp 값을 수정


-----------------------------------------

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static List<int[]> connInfo = new ArrayList<>();
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            connInfo.add(new int[]{a, b, c});
        }
        connInfo.sort(Comparator.comparingInt(x -> x[2]));
        int cnt = 0;
        long sum = 0;
        for (int i = 0; i < M; i++) {
            if (findTop(connInfo.get(i)[0]) != findTop(connInfo.get(i)[1])) {
//                System.out.println(connInfo.get(i)[0] + " " + connInfo.get(i)[1] + " " + connInfo.get(i)[2]);
                union(connInfo.get(i)[0], connInfo.get(i)[1]);
//                System.out.println(Arrays.toString(dp));

                cnt++;
                sum += connInfo.get(i)[2];
            }
            if (cnt == N - 1) {
                break;
            }
        }
        System.out.println(sum);
    }

    private static int findTop(int x) {
        if (dp[x] == x) {
            return x;
        }
        return dp[x] = findTop(dp[x]);

    }

    private static void union(int x1, int x2) {
        int parentX1 = findTop(x1);
        int parentX2 = findTop(x2);
        if (parentX1 < parentX2) {
            dp[parentX2] = parentX1;
        } else {
            dp[parentX1] = parentX2;
        }
    }


}
