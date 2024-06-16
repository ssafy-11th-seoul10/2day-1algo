import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240616_19563 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dist = Math.abs(a) + Math.abs(b);

        if (dist <= c && (dist & 1) == (c & 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        br.close();
    }

}
