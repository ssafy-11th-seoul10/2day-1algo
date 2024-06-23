import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_240622_10775 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int g = Integer.parseInt(br.readLine()); // 게이트 수
        int p = Integer.parseInt(br.readLine());

        parents = new int[g + 1];
        for (int i = 1; i <= g; i++) {
            parents[i] = i;
        }

        int[] gNumArr = new int[p];
        for (int i = 0; i < p; i++) {
            int gNum = Integer.parseInt(br.readLine());
            gNumArr[i] = gNum;
        }

        int answer = 0;
        for (int i = 0; i < p; i++) {
            int gNum = gNumArr[i];

            int findNum = find(gNum);
            if (findNum == 0)
                break;

            union(findNum, findNum - 1);
            answer++;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x < y)
            parents[y] = x;
        else
            parents[x] = y;
    }

    static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}
