// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public int solution(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 4;
        }
        return solution(n-2) + (n-2)*(4*n-4) + (2*n-1) + 1;
    }

// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
public static void main(String[] args) {
    Main sol = new Main();
    int n1 = 3;
    int ret1 = sol.solution(n1);
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

    int n2 = 2;
    int ret2 = sol.solution(n2);
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}