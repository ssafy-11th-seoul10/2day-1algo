import java.util.HashMap;

class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int mod = 0;
        HashMap<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            mod = (mod + nums[i]) % k;

            if (modSeen.containsKey(mod)) {
                if (i - modSeen.get(mod) > 1) {
                    return true;
                }
            } else {
                modSeen.put(mod, i);
            }
        }

        return false;
    }
}
