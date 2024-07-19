import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2467_240719 {
    public static void main(String[] args) throws IOException {

        //양수와 음수를 나눈다.
        //양수 쪽에서 가장 작은수 2개 더하기
        //음수 쪽에서 가장 작은수 2개 더하기
        //양수 1개 음수 1개 선택하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if(num<0){
                listA.add(num);
            } else{
                listB.add(num);
            }
        }

        int answer = Integer.MAX_VALUE;
        int first = 0;
        int second = 0;
        //음수 2개 이상일 경우 체크
        if(listA.size()>=2){
            int now = Math.abs(listA.get(listA.size() - 1) + listA.get(listA.size() - 2));
            if (now < answer) {
                answer = now;
                first = listA.get(listA.size() - 2);
                second = listA.get(listA.size() - 1);
            }
        }

        //양수 2개 이상일 경우 체크
        if(listB.size()>=2){
            int now = Math.abs(listB.get(0) + listB.get(1));
            if (now < answer) {
                answer = now;
                first = listB.get(0);
                second = listB.get(1);
            }
        }

        //음수 1개 양수 1개 체크
        if (!listA.isEmpty() && !listB.isEmpty()) {
            int indexA = 0;
            int indexB = listB.size()-1;

            while (indexA < listA.size() && indexB >= 0) {
                int now = listA.get(indexA) + listB.get(indexB);
                int absNum = Math.abs(now);
                if(absNum<answer){
                    answer = absNum;
                    first = listA.get(indexA);
                    second = listB.get(indexB);
                }
                if(now==0){
                    break;
                } else if(now>0){
                    indexB--;
                } else{
                    indexA++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(first).append(" ").append(second);
        System.out.println(sb);
    }
}
