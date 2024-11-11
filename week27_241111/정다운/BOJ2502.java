import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2502 {

    static int D, K;
    static int[][] riceCake_calendar;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        riceCake_calendar = new int[D][2];
        riceCake_calendar[0][0] = 1; riceCake_calendar[1][1] = 1;

        for(int day = 2; day < D; day++) {

            riceCake_calendar[day][0] = riceCake_calendar[day-1][0] + riceCake_calendar[day-2][0];
            riceCake_calendar[day][1] = riceCake_calendar[day-1][1] + riceCake_calendar[day-2][1];
        }

        // BruteForce
        int D_First_Cake_Para = riceCake_calendar[D-1][0];
        int D_Second_Cake_Para = riceCake_calendar[D-1][1];

        int MAX_First_RiceCake_Number = (K - D_Second_Cake_Para) / D_First_Cake_Para;
        int MAX_Second_RiceCake_Number = (K - D_First_Cake_Para) / D_Second_Cake_Para;

        outer : for(int firstRiceCake = 1; firstRiceCake <= MAX_First_RiceCake_Number; firstRiceCake++)
            for(int secondRiceCake = 1; secondRiceCake <= MAX_Second_RiceCake_Number; secondRiceCake++) {

                int tmp = (D_First_Cake_Para * firstRiceCake) + (D_Second_Cake_Para * secondRiceCake);

                if(tmp == K && firstRiceCake <= secondRiceCake) {
                    System.out.println(firstRiceCake);
                    System.out.println(secondRiceCake);
                    System.out.println();
                    break outer;
                }
            }
    }
}
