import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

class Solution {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Info> infos = new LinkedList<>();

        for (int i = 0; i < difficulty.length; i++) {
            infos.add(new Info(difficulty[i], profit[i]));
        }

        Collections.sort(infos);

        TreeMap<Integer, Integer> dp = new TreeMap<>();

        for (Info now : infos) {
            Entry<Integer, Integer> entry = dp.floorEntry(now.diff);
            if (entry != null) {
                dp.put(now.diff, Math.max(now.pro, entry.getValue()));
            } else {
                dp.put(now.diff, now.pro);
            }
        }

        int result = 0;
        for (int work : worker) {
            Entry<Integer, Integer> entry = dp.floorEntry(work);
            if (entry != null) {
                result += entry.getValue();
            }
        }

        return result;
    }
}

class Info implements Comparable<Info> {
    int diff;
    int pro;

    public Info(int diff, int pro) {
        this.diff = diff;
        this.pro = pro;
    }

    @Override
    public int compareTo(Info o) {
        if (this.diff == o.diff) {
            return this.pro - o.pro;
        }

        return this.diff - o.diff;
    }
}
