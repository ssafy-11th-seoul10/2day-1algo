import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();

        StringBuilder word = new StringBuilder();
        StringBuilder count = new StringBuilder();
        Stack<Integer> num = new Stack<>();
        num.push(1);
        int multi = 1;

        for (int i = formula.length() - 1; i >= 0; i--) {
            char now = formula.charAt(i);

            if (Character.isDigit(now)) { // 숫자
                count.insert(0, now);
            } else if (Character.isLowerCase(now)) { // 소문자
                word.insert(0, now);
            } else if (Character.isUpperCase(now)) { // 대문자
                word.insert(0, now);
                int nowCount = (count.length() > 0 ? Integer.parseInt(count.toString()) : 1) * multi;
                map.put(word.toString(), map.getOrDefault(word.toString(), 0) + nowCount);
                word = new StringBuilder();
                count = new StringBuilder();
            } else if (now == '(') {
                Integer pop = num.pop();
                multi /= pop;
            } else if (now == ')') {
                int nowCount = (count.length() > 0 ? Integer.parseInt(count.toString()) : 1);
                multi *= nowCount;
                num.push(nowCount);
                count = new StringBuilder();
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);

        StringBuilder result = new StringBuilder();

        for (String now : sortedMap.keySet()) {
            result.append(now);
            if (sortedMap.get(now) > 1) {
                result.append(sortedMap.get(now));
            }
        }

        return result.toString();
    }
}
