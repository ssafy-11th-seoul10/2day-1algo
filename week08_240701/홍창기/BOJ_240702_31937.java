import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_240702_31937 {

    static class Log {
        int t, from, to;

        Log(int t, int from, int to) {
            this.t = t;
            this.from = from;
            this.to = to;
        }
    }

    static class LogComparator implements Comparator<Log> {

        @Override
        public int compare(Log o1, Log o2) {
            return o1.t - o2.t;
        }

    }

    static LogComparator logComparator = new LogComparator();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] infected = new boolean[n + 1];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(st.nextToken());
            infected[x] = true;
        }

        Log[] logs = new Log[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            logs[i] = new Log(t, from, to);
        }

        Arrays.sort(logs, logComparator);
        int ans = -1;

        for (int x = 1; x <= n; x++) {
            boolean[] curInfected = new boolean[n + 1];
            curInfected[x] = true;

            for (Log log : logs) {
                if (curInfected[log.from]) {
                    curInfected[log.to] = true;
                }
            }

            boolean sameInfected = true;

            for (int xx = 1; xx <= n; xx++) {
                if (infected[xx] != curInfected[xx]) {
                    sameInfected = false;
                    break;
                }
            }

            if (sameInfected) {
                ans = x;
                break;
            }
        }

        System.out.println(ans);
    }

}
