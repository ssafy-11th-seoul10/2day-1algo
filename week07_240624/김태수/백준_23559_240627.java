import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cost = sc.nextInt();

        Bab[] babs = new Bab[n];

        for (int i = 0; i < n; i++) {
            babs[i] = new Bab(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(babs);

        int result = 0;
        int count5 = (cost - 1000 * n) / 4000;

        for (int i = 0; i < n; i++) {
            if (count5 > 0) {
                if (babs[i].a > babs[i].b) {
                    count5--;
                    result += babs[i].a;
                } else {
                    result += babs[i].b;
                }
            } else {
                result += babs[i].b;
            }
        }

        System.out.println(result);
    }
}

class Bab implements Comparable<Bab> {
    int a;
    int b;

    public Bab(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Bab o) {
        return -(Math.abs(this.a - this.b) - Math.abs(o.a - o.b));
    }
}
