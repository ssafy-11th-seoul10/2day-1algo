import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_240728_21774 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        ArrayList<Long>[] logs = new ArrayList[7];

        for (int lv = 1; lv <= 6; lv++) {
            logs[lv] = new ArrayList<Long>();
        }

        for (int i = 0; i < n; i++) {
            String log = br.readLine();
            long t = Integer.parseInt(log.substring(0, 4)) * 10000000000L
                    + Integer.parseInt(log.substring(5, 7)) * 100000000L
                    + Integer.parseInt(log.substring(8, 10)) * 1000000
                    + Integer.parseInt(log.substring(11, 13)) * 10000
                    + Integer.parseInt(log.substring(14, 16)) * 100
                    + Integer.parseInt(log.substring(17, 19));
            int lv = Integer.parseInt(log.substring(20));
            logs[lv].add(t);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String query = br.readLine();
            long ts = Integer.parseInt(query.substring(0, 4)) * 10000000000L
                    + Integer.parseInt(query.substring(5, 7)) * 100000000L
                    + Integer.parseInt(query.substring(8, 10)) * 1000000
                    + Integer.parseInt(query.substring(11, 13)) * 10000
                    + Integer.parseInt(query.substring(14, 16)) * 100
                    + Integer.parseInt(query.substring(17, 19));
            long te = Integer.parseInt(query.substring(20, 24)) * 10000000000L
                    + Integer.parseInt(query.substring(25, 27)) * 100000000L
                    + Integer.parseInt(query.substring(28, 30)) * 1000000
                    + Integer.parseInt(query.substring(31, 33)) * 10000
                    + Integer.parseInt(query.substring(34, 36)) * 100
                    + Integer.parseInt(query.substring(37, 39));
            int lv = Integer.parseInt(query.substring(40));

            int cnt = 0;

            for (int v = lv; v <= 6; v++) {
                cnt += lowerBound(logs[v], te + 1) - lowerBound(logs[v], ts);
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    static int lowerBound(ArrayList<Long> arr, long key) {
        int low = -1;
        int high = arr.size();

        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) >= key) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

}
