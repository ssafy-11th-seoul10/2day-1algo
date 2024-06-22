package Softeer;

import java.io.*;
import java.util.*;

public class eight_speed_transmission {

    static int[] transmission;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        transmission = new int[8];
        for(int i = 0; i < 8; i++)
            transmission[i] = Integer.parseInt(st.nextToken());

        int flag = 0;

        for(int i = 1; i < 8; i++) {
            if (i == 1) {
                if (transmission[i] - transmission[i - 1] > 0)
                    flag = 1;
                else if (transmission[i] - transmission[i - 1] < 0)
                    flag = 2;
            } else {
                if (flag == 1 && transmission[i] - transmission[i - 1] <= 0) {
                    flag = 0;
                    break;
                } else if (flag == 2 && transmission[i] - transmission[i - 1] >= 0) {
                    flag = 0;
                    break;
                }
            }
        }

        if(flag == 0)
            System.out.println("mixed");
        else if(flag == 1)
            System.out.println("ascending");
        else
            System.out.println("descending");
    }
}
