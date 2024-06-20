import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_240619_28070 {

    static class PeriodInfo {
        int yyyy;
        int mm;
        int inOut; // 0이면 in, 1이면 out

        PeriodInfo(int yyyy, int mm, int inOut) {
            this.yyyy = yyyy;
            this.mm = mm;
            this.inOut = inOut;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PeriodInfo[] periodInfos = new PeriodInfo[n * 2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            int yyyy = Integer.parseInt(s.substring(0, 4));
            int mm = Integer.parseInt(s.substring(5, 7));
            periodInfos[i * 2] = new PeriodInfo(yyyy, mm, 0);

            yyyy = Integer.parseInt(s.substring(8, 12));
            mm = Integer.parseInt(s.substring(13, 15));
            periodInfos[i * 2 + 1] = new PeriodInfo(yyyy, mm, 1);
        }

        Arrays.sort(periodInfos, new Comparator<PeriodInfo>() {

            @Override
            public int compare(PeriodInfo o1, PeriodInfo o2) {
                if (o1.yyyy != o2.yyyy) {
                    return o1.yyyy - o2.yyyy;
                }

                if (o1.mm != o2.mm) {
                    return o1.mm - o2.mm;
                }

                return o1.inOut - o2.inOut;
            }

        });

        int curCnt = 0;
        int maxCnt = 0;
        int maxYyyy = 0;
        int maxMm = 0;

        for (PeriodInfo periodInfo : periodInfos) {
            if (periodInfo.inOut == 0) {
                if (++curCnt > maxCnt) {
                    maxCnt = curCnt;
                    maxYyyy = periodInfo.yyyy;
                    maxMm = periodInfo.mm;
                }
            } else {
                curCnt--;
            }
        }

        System.out.printf("%04d-%02d", maxYyyy, maxMm);
        br.close();
    }

}
