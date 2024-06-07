import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG_대충만든자판_240606 {
    public static void main(String[] args) {
        String[] keymap = {"AGZ", "BSSS"};
        String[] targets = {"ASA","BGZ"};
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[50];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);
                int count = i+1;
                int idx = now-'A';
                arr[idx] = Math.min(arr[idx], count);
            }
        }
        for (String target : targets) {
            int total = 0;
            for (int i = 0; i < target.length(); i++) {
                char now = target.charAt(i);
                int idx = now-'A';
                if(arr[idx]==Integer.MAX_VALUE){
                    total = -1;
                    break;
                }
                total+= arr[idx];
            }
            result.add(total);
        }
        for (Integer i : result) {
            System.out.print(i+" ");
        }
    }
}
