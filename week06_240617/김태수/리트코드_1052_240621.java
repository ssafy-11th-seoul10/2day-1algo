class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }

        int now = 0;

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                now += customers[i];
            }
        }

        int max = now;
        int left = 0;


        for (int i = minutes; i < grumpy.length; i++) {
            if (grumpy[i] == 1){
                now += customers[i];
            }

            if (grumpy[left] == 1){
                now -= customers[left];
            }

            left++;
            max = Math.max(max, now);
        }


        return max + sum;
    }
}
