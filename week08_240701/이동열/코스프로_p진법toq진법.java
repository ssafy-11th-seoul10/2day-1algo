// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public String solution(String s1, String s2, int p, int q) {
        String answer = "";
        int tmp = 1;
        int ss1 = 0;
        for(int i = s1.length()-1; i>=0; i--){
            int curr = s1.charAt(i) - '0';
            ss1+= tmp*curr;
            tmp*=p;
        }
        tmp=1;
        int ss2=0;
        for(int i = s2.length()-1; i>=0; i--){
            int curr = s2.charAt(i) - '0';
            ss2+= tmp*curr;
            tmp*=p;
        }
        int sum = ss1 + ss2;
        String answer_reverse = "";
        while(sum>0){
            answer_reverse+=sum%q;
            sum/=q;
        }
        for(int i = answer_reverse.length()-1; i>=0; i--){
            answer+=answer_reverse.charAt(i);
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String s1 = new String("112001");
        String s2 = new String("12010");
        int p = 3;
        int q = 8;
        String ret = sol.solution(s1, s2, p, q);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 \"" + ret + "\" 입니다.");
    }
}