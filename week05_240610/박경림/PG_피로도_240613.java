import java.util.*;

class Solution {
    private int len, answer = 0;
    private boolean[] selected;
    private int[] arr;
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        selected = new boolean[len];
        arr = new int[len];
        perm(0, k, dungeons);
        return answer;
    }
    
    private void perm(int cnt, int k, int[][] dungeons) {
        if (cnt == len) {
            // System.out.println(Arrays.toString(arr));
            int pirodo = k;
            int dungeon = 0;
            for (int i = 0; i < len; i++) {
                if (dungeons[arr[i]][0] > pirodo) return;
                pirodo -= dungeons[arr[i]][1];
                answer = Math.max(++dungeon, answer);
            }
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (selected[i]) continue;
            arr[cnt] = i;
            selected[i] = true;
            perm(cnt + 1, k, dungeons);
            selected[i] = false;
        }
    }
}
