import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_31869_240525 {

    static class Bob {
        int d, p;

        Bob(int w, int d, int p) {
            this.d = w * 7 + d;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Bob> bobs = new HashMap<String, Bob>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            int w = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            bobs.put(s, new Bob(w, d, p));
        }

        boolean[] checked = new boolean[77];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            int m = Integer.parseInt(st.nextToken());

            Bob bob = bobs.get(s);

            if (bob.p <= m) {
                checked[bob.d] = true;
            }
        }

        int maxLen = 0;
        int curLen = 0;

        for (int i = 0; i < 77; i++) {
            if (checked[i]) {
                curLen++;
                maxLen = curLen > maxLen ? curLen : maxLen;
            } else {
                curLen = 0;
            }
        }
        
        System.out.println(maxLen);
        br.close();
    }

}
