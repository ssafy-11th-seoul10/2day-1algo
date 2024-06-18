import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_240618_22867 {

    static class BusInfo {
        int time;
        int state;

        BusInfo(int time, int state) {
            this.time = time;
            this.state = state;
        }
    }

    static int convertTimeToInt(String s, int beginIndex) {
        int hh = Integer.parseInt(s.substring(beginIndex, beginIndex + 2));
        int mm = Integer.parseInt(s.substring(beginIndex + 3, beginIndex + 5));
        int ss = Integer.parseInt(s.substring(beginIndex + 6, beginIndex + 8));
        int sss = Integer.parseInt(s.substring(beginIndex + 9, beginIndex + 12));

        return hh * 10000000 + mm * 100000 + ss * 1000 + sss;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BusInfo[] busInfos = new BusInfo[n * 2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int t1 = convertTimeToInt(s, 0);
            int t2 = convertTimeToInt(s, 13);
            busInfos[i * 2] = new BusInfo(t1, 1);
            busInfos[i * 2 + 1] = new BusInfo(t2, -1);
        }

        Arrays.sort(busInfos, new Comparator<BusInfo>() {

            @Override
            public int compare(BusInfo o1, BusInfo o2) {
                if (o1.time != o2.time) {
                    return o1.time - o2.time;
                }

                return o1.state - o2.state;
            }

        });

        int maxValue = 0;
        int curValue = 0;

        for (BusInfo busInfo : busInfos) {
            curValue += busInfo.state;

            if (curValue > maxValue) {
                maxValue = curValue;
            }
        }

        System.out.println(maxValue);
        br.close();
    }

}
