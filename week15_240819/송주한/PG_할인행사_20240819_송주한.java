package PG;

class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0 ; i<=9 ;i++){
            for(int j=0;j<=want.length-1;j++){
                if(want[j].equals(discount[i])){
                    number[j]--;
                    break;
                }
            }
        }
        
        answer += check(number);
        
        for(int i= 1; i<=discount.length-10;i++){
            for(int j=0;j<=want.length-1;j++){
                if(want[j].equals(discount[i-1])){
                    number[j]++;
                }
                if(want[j].equals(discount[i+9])){
                    number[j]--;
                }
            }
            answer += check(number);
        }
        
        return answer;
    }
    
    static int check(int[] number){
        for(int i=0; i<number.length;i++){
            if(number[i]!=0) break;
            if(i==number.length-1) return 1;
        }
        return 0;
    }
}

