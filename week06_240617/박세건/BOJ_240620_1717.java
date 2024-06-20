find(int x) 부분
  {
    if(x==parent[x])
      return x;
    else
      return parent[x]=find(x);
      //parent[x]=find(x) 를 이용해서 find(x)로 최상위 root를 찾아낸후에 그 root까지 도달하기 위한 자식들의 parent값을 모두 최상위 root로 초기화 시킨다 => 경로 압축
      // 덕분에 다음에 다시 똑같은 행동을 취해도 바로 최상위 root 를 찾아낼 수 있다
  }

union(a,b) 부분 => a, b 둘의 최상위 root 를 크기 비교한 뒤에 작은 부분의 집합에 큰 부분의 집합을 합쳐준다.
  
  {
    a=find(a);
    b=find(b);
    if(a<b)
      parent[b]=a;
    else
      parent[a]=b;
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int N, M;

    private static int[] parentUnit;
    private static int answer = 1;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        parentUnit = new int[N + 1];
        settingParentUnit();
        M = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(stringTokenizer.nextToken());
            int firstUnit = Integer.parseInt(stringTokenizer.nextToken());
            int secondUnit = Integer.parseInt(stringTokenizer.nextToken());
            if (command == 0) {
                union(firstUnit, secondUnit);
            } else {
                System.out.println(find(firstUnit) == find(secondUnit) ? "YES" : "NO");
            }
        }
    }

    private static void settingParentUnit() {
        for (int i = 0; i <= N; i++) {
            parentUnit[i] = i;
        }
    }

    private static int find(int x) {
        if (x == parentUnit[x]) {
            return x;
        }
        return parentUnit[x] = find(parentUnit[x]);
    }

    private static void union(int firstUnit, int secondUnit) {
        firstUnit = find(firstUnit);
        secondUnit = find(secondUnit);
        if (firstUnit == secondUnit) {
            return;
        }
        if (firstUnit > secondUnit) {
            parentUnit[firstUnit] = secondUnit;
        } else {
            parentUnit[secondUnit] = firstUnit;
        }
    }
}
