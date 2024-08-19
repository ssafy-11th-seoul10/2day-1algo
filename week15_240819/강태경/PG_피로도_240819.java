class PG_피로도_240819 {
    static void perm(int depth){
        if(depth==arr.length) return;
        for (int i = 0; i < arr.length; i++) {
            if((bit&(1<<i))==0 && hp>=arr[i][0]){
                bit|=(1<<i);
                hp-=arr[i][1];
                count++;
                answer = Math.max(answer, count);

                perm(depth+1);

                bit^=(1<<i);
                hp+=arr[i][1];
                count--;
            }
        }
    }

    static int hp, bit, count, answer;
    static int[][] arr;

    public int solution(int k, int[][] dungeons) {
        //순열 사용
        hp = k;
        arr = dungeons.clone();
        bit = 0;
        count = 0;
        answer = 0;
        perm(0);
        return answer;
    }
}