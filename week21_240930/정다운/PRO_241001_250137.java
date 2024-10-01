package programmers;
// 붕대 감기 "기술" : 기술 시전 완료 후 즉시 or 몬스터한테 공격 당하여 기술이 취소
// 단, 연속 성공 시간이 0으로 초기화 (timer)
// 붕대를 통한 체력회복 로직 : (t초마다) t * x 회복 + y 추가 회복

// 기술 시전 시간 도중 -> 공격 받으면 기술 취소
// 공격 당하는 순간은 체력 회복 불가
public class PRO250137 {
    static int t;
    static int x;
    static int y;

    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage = { 붕대 감기 기술 시전 시간, x 회복, y 추가 회복분 }
        // health : 최대 체력 상한선
        // attacks : 공격 시간과 피해량

        // STEP 1. 데이터 설정
        t = bandage[0]; x = bandage[1]; y = bandage[2];

        // 최대 시간 : 1000 * 100 = 100,000
        // STEP 2. Simulation
        int myHP = health;
        int success = 0;
        int idx = 0;

        for(int time = 0; time < 100_000; time++) {

            if(myHP <= 0 || idx == attacks.length)
                break;

            int[] monster = attacks[idx];
            int startAttack = monster[0];
            int attackRate = monster[1];

            // 몬스터 공격 시점
            if(startAttack == time) {
                myHP = myHP - attackRate;
                success = 0;
                idx++;

                continue;
            }

            // 평상시
            success++;

            if(myHP < health){
                if(success == t) {
                    success = 0;

                    myHP = myHP + (y + x) >= health ?
                            health : myHP + (y + x);
                }

                else
                    myHP = myHP + x >= health ?
                            health : myHP + x;
            }
        }

        // 0 이하면 -1 return
        return myHP <= 0 ? -1 : myHP;

    }
}
