import java.util.*;
import java.io.*;

class Main {
    static int origin;
    static int numLen;
    static int minCount = Integer.MAX_VALUE;
    static int[] numInt;
    static boolean[] selected;
    static int[] newNum;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        origin = Integer.parseInt(original);
        char[] numChar = original.toCharArray();
        numLen = numChar.length;
        numInt = new int[numLen];
        newNum = new int[numLen];
        selected = new boolean[numLen];
        for(int i = 0; i < numLen; i++){
            numInt[i] = numChar[i] - '0';
        }
        makeNum(0);
        System.out.print(minCount);
    }

    public static void makeNum(int cnt){
        if(cnt == numLen){
            int num = 0;
            for(int i = 0; i < numLen; i++){
                num *= 10;
                num += newNum[i];
            }
            if(num > origin){
                minCount = Math.min(minCount, num);
            }
            return;
        }
        for(int i = 0; i < numLen; i++){
            if(!selected[i]){
                selected[i] = true;
                newNum[cnt] = numInt[i];
                makeNum(cnt+1);
                selected[i] = false;
            }
        }
    }
}
