import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Info[] infos = new Info[n];

        for (int i = 0; i < n; i++) {
            String number = sc.next();
            int strike = sc.nextInt();
            int ball = sc.nextInt();
            infos[i] = new Info(number, strike, ball);
        }

        int result = 0;

        for (int i = 123; i <= 987; i++) {
            if (isSameNumber(i) || String.valueOf(i).contains("0")) {
                continue;
            }

            if (isCan(infos, i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isSameNumber(int num) {
        int a = num % 10;
        int b = num / 10 % 10;
        int c = num / 100 % 10;

        return a == b || b == c || a == c;
    }

    private static boolean isCan(Info[] infos, int num) {
        for (Info info : infos) {
            int strike = countStrike(info.number, String.valueOf(num));
            int ball = countBall(info.number, String.valueOf(num));

            if (strike != info.strike || ball != info.ball) {
                return false;
            }
        }

        return true;
    }

    private static int countStrike(String num1, String num2) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (num1.charAt(i) == num2.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private static int countBall(String num1, String num2) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (num1.charAt(i) != num2.charAt(i) && num2.contains(String.valueOf(num1.charAt(i)))) {
                count++;
            }
        }

        return count;
    }
}

class Info {

    String number;
    int strike;
    int ball;

    public Info(String number, int strike, int ball) {
        this.number = number;
        this.strike = strike;
        this.ball = ball;
    }
}
