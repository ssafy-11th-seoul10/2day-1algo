package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2608 {


    static String[] a = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    static String[] b = new String[] {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static String[] c = new String[] {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static String[] d = new String[] {"M", "MM", "MMM"};

    static Map<String, Integer> convertNum = new HashMap<>();
    static Map<Integer, String> convertRomanian = new HashMap<>();

    public static int convertToNum(String roman) {

        int startIdx = 0;
        int number = 0;

        for(int i = 0; i < roman.length(); i++) {

            String tmp = roman.substring(startIdx, i + 1);

            if(convertNum.containsKey(tmp))
                continue;

            tmp = roman.substring(startIdx, i);
            number += convertNum.get(tmp);
            startIdx = i;
        }
        // 마지막 부분
        number += convertNum.get(roman.substring(startIdx));

        return number;
    }

    public static String convertToRoman(int num) {

        StringBuilder roman = new StringBuilder();

        for(int slag = 1000; slag >= 1; slag = slag / 10) {

            int f = num / slag;

            if(convertRomanian.get(f * slag) != null)
                roman.append(convertRomanian.get(f * slag));
            num = num % slag;
        }

        return roman.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        for(int num = 1; num < 10; num++) {
            convertNum.put(a[idx], num);
            convertRomanian.put(num, a[idx]);
            idx++;
        }

        idx = 0;
        for(int num = 10; num < 100; num=num+10) {
            convertNum.put(b[idx], num);
            convertRomanian.put(num, b[idx]);
            idx++;
        }

        idx = 0;
        for(int num = 100; num < 1000; num=num+100) {
            convertNum.put(c[idx], num);
            convertRomanian.put(num, c[idx]);
            idx++;
        }

        idx = 0;
        for(int num = 1000; num < 4000; num=num+1000) {
            convertNum.put(d[idx], num);
            convertRomanian.put(num, d[idx]);
            idx++;
        }

        String romaOne = br.readLine();
        int one = convertToNum(romaOne);
        //System.out.println(convertToNum(romaOne));
        String romaTwo = br.readLine();
        int two = convertToNum(romaTwo);
        //System.out.println(convertToNum(romaTwo));

        int res = one + two;
        String romainRes = convertToRoman(res);

        System.out.println(res);
        System.out.println(romainRes);
    }
}
