class PG_숫자카드나누기_240705 {

    //유클리드 호제
    static int gcd(int x, int y) {
        while (y != 0) {
            int temp = x;
            x = y;
            y = temp%y;
        }
        return x;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        //한 쪽이 모두 나눠지고 한쪽은 모두 나눠지지 않음
        //1. 한 쪽의 모든 수의 최대 공약수를 구함
        //2. 구한 공약수 중 다른 리스트의 모든 숫자를 나누고 나머지가 0이 아니면 답
        int answer = 0;
        int num = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            num = gcd(num, arrayA[i]);
        }
        boolean possible = true;
        for (int i = 0; i < arrayB.length; i++) {
            if(arrayB[i]%num==0){
                possible =false;
                break;
            }
        }
        if(possible) answer = Math.max(answer, num);
        num = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            num = gcd(num, arrayB[i]);
        }

        possible = true;
        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i]%num==0){
                possible =false;
                break;
            }
        }
        if(possible) answer = Math.max(answer, num);
        return answer;
    }
}