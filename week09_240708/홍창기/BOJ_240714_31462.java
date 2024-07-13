import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240714_31462 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 3 == 1) {
            System.out.println(0);
            br.close();
            return;
        }

        String[] choco = new String[n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            choco[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (visited[i][j]) {
                    continue;
                } else if (choco[i].charAt(j) == 'R') {
                    if (i + 1 < n && choco[i + 1].charAt(j) == 'R' && !visited[i + 1][j]
                            && choco[i + 1].charAt(j + 1) == 'R' && !visited[i + 1][j + 1]) {
                        visited[i][j] = true;
                        visited[i + 1][j] = true;
                        visited[i + 1][j + 1] = true;
                    } else {
                        System.out.println(0);
                        br.close();
                        return;
                    }
                } else {
                    if (i + 1 < n && j + 1 <= i && choco[i].charAt(j + 1) == 'B' && !visited[i][j + 1]
                            && choco[i + 1].charAt(j + 1) == 'B' && !visited[i + 1][j + 1]) {
                        visited[i][j] = true;
                        visited[i][j + 1] = true;
                        visited[i + 1][j + 1] = true;
                    } else {
                        System.out.println(0);
                        br.close();
                        return;
                    }
                }
            }
        }

        System.out.println(1);
        br.close();
    }

}
