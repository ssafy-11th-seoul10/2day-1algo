class PG_붕대감기_240602 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int nHealth = health;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int sum = 0;
        int idx = 0;
        int lastTime = attacks[attacks.length - 1][0];
        for (int i = 1; i <= lastTime; i++) {
            int[] attack = attacks[idx];
            //공격 당했다면
            if (attack[0] == i) {
                nHealth -= attack[1];
                //죽는다면
                if (nHealth <= 0) {
                    return -1;
                }
                //죽지 않았다면
                sum=0;
                idx++;
                //공격 당하지 않았다면
            } else {
                nHealth += x;
                sum++;
                //연속 회복 성공
                if (sum == t) {
                    sum = 0;
                    nHealth += y;
                }
                if(nHealth>health) nHealth = health;
            }
        }
        return nHealth;
    }
}