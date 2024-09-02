package PG;

public class PG_240902_약수의개수와덧셈 {
    public static void main(String[] args) {

        int left = 13;
        int right = 17;

        int answer = 0;

        for (int i = left; i <=right ; i++) {
            int count = 0;
            for (int j = 1; j*j <=i ; j++) {
                if(j*j==i) count++;
                else if(i%j==0) count+=2;
            }
            if(count%2==0){
                answer+=i;
            } else {
                answer-=i;
            }

        }
        System.out.println(answer);


    }
}
