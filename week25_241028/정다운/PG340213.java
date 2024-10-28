package programmers;

public class PG340213 {

    static int endOfVideo = 0;
    static int startOpPos = 0;
    static int endOpPos = 0;

    public static int convertInt(String data) {
        // sec 기준
        int i = 0;

        String[] tmp = data.split(":");
        int idx = 0;

        for(String t : tmp) {
            if(idx == 0)
                i += (60 * Integer.parseInt(t));
            else
                i += (Integer.parseInt(t));
            idx++;
        }

        return i;
    }

    public static String IntToDate(int time) {

        StringBuilder sb = new StringBuilder();

        int min = time / 60;
        if(0 <= min && min <= 9)
            sb.append("0");
        sb.append(String.valueOf(min));

        sb.append(":");

        int sec = time % 60;
        if(0 <= sec && sec <= 9)
            sb.append("0");
        sb.append(String.valueOf(sec));

        return sb.toString();
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        endOfVideo = convertInt(video_len);
        startOpPos = convertInt(op_start);
        endOpPos = convertInt(op_end);

        int curTime = convertInt(pos);

        for(String c : commands) {

            if(startOpPos <= curTime && curTime <= endOpPos)
                curTime = endOpPos;

            if(c.equals("next")) {
                curTime = curTime + 10 >= endOfVideo ? endOfVideo : curTime + 10;
            }
            else if(c.equals("prev")) {
                curTime = curTime - 10 <= 0 ? 0 : curTime - 10;
            }
        }

        if(startOpPos <= curTime && curTime <= endOpPos)
            curTime = endOpPos;

        return IntToDate(curTime);
    }
}