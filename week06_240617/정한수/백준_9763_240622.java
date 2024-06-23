import java.io.*;
import java.util.*;

public class Main {

    private static class Village{
        int x, y, z;

        public Village(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public static int getIntimacy(Village a, Village b){
            return Math.abs(a.x - b.x) + Math.abs(a.y - b.y) + Math.abs(a.z - b.z);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), min = Integer.MAX_VALUE;
        Village[] villages = new Village[N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            villages[i] = new Village(x, y, z);
        }

        for (int i = 0; i < N; i++) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    int tmp = Village.getIntimacy(villages[i], villages[j]);

                    if (tmp < min1){
                        min2 = min1;
                        min1 = tmp;
                    } else if (tmp < min2){
                        min2 = tmp;
                    }
                }
            }
            min = Math.min(min, min1 + min2);
        }

        System.out.println(min);
    }

}
