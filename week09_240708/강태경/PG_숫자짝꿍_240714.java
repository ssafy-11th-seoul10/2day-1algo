import java.util.*;

class PG_숫자짝꿍_240714 {
    public String solution(String X, String Y) {
        Map<Integer, Integer> mapX = new TreeMap<>();
        Map<Integer, Integer> mapY = new TreeMap<>();
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < 10; i++) {
            mapX.put(i, 0);
            mapY.put(i, 0);
        }

        for (int i = 0; i < X.length(); i++) {
            int now = X.charAt(i) - '0';
            mapX.put(now, mapX.get(now) + 1);
        }

        for (int i = 0; i < Y.length(); i++) {
            int now = Y.charAt(i) - '0';
            mapY.put(now, mapY.get(now) + 1);
        }

        for (int i = 0; i < 10; i++) {
            int x = mapX.get(i);
            int y = mapY.get(i);
            int common = Math.min(x, y);
            map.put(i, common);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < map.get(i); j++) {
                sb.append(i);
            }
        }
        String answer = "";
        if(sb.length()==0) answer = "-1";
        else if(sb.charAt(0)=='0'){
            answer = "0";
        } else{
            answer = sb.toString();
        }
        return answer;
    }
}