import java.io.*;
import java.util.*;

public class Main {

    private static class Date implements Comparable<Date> {
        int startMonth;
        int startDay;
        int endMonth;
        int endDay;

        public Date(int startMonth, int startDay, int endMonth, int endDay) {
            this.startMonth = startMonth;
            this.startDay = startDay;
            this.endMonth = endMonth;
            this.endDay = endDay;
        }

        public int compareTo(Date o) {
            if (this.startMonth == o.startMonth) {
                return this.startDay - o.startDay;
            }
            return this.startMonth - o.startMonth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Date> dateList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dateList.add(new Date(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(dateList);

        int currMonth = 3;
        int currDay = 1;
        int maxMonth = 0;
        int maxDay = 0;
        int answer = 0;

        int i = 0;
        while (i < dateList.size() && (dateList.get(i).startMonth < currMonth ||
            (dateList.get(i).startMonth == currMonth && dateList.get(i).startDay <= currDay))) {
            if (dateList.get(i).endMonth > maxMonth ||
                (dateList.get(i).endMonth == maxMonth && dateList.get(i).endDay > maxDay)) {
                maxMonth = dateList.get(i).endMonth;
                maxDay = dateList.get(i).endDay;
            }
            i++;
        }

        if (maxMonth == 0 && maxDay == 0) {
            System.out.println(0);
            return;
        }

        answer++;
        currMonth = maxMonth;
        currDay = maxDay;

        while (currMonth < 12) {
            maxMonth = 0;
            maxDay = 0;
            while (i < dateList.size() && (dateList.get(i).startMonth < currMonth ||
                (dateList.get(i).startMonth == currMonth && dateList.get(i).startDay <= currDay))) {
                if (dateList.get(i).endMonth > maxMonth ||
                    (dateList.get(i).endMonth == maxMonth && dateList.get(i).endDay > maxDay)) {
                    maxMonth = dateList.get(i).endMonth;
                    maxDay = dateList.get(i).endDay;
                }
                i++;
            }

            if (maxMonth == 0 && maxDay == 0) {
                System.out.println(0);
                return;
            }

            answer++;
            currMonth = maxMonth;
            currDay = maxDay;
        }

        System.out.println(answer);
    }
}