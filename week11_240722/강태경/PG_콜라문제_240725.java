public class PG_콜라문제_240725 {
    public static void main(String[] args) {

        int a = 3;
        int b = 1;
        int n = 20;

        int answer = 0;
        int q = 0;
        int r = 0;

        while (true) {
            q = n/a;
            if(q==0) break;
            r = n%a;

            answer+=q*b;
            n = r+q*b;
        }

        System.out.println(answer);
    }
}
