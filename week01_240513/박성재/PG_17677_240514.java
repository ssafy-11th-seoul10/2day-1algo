import java.util.*;

class Solution {
    static final int NUM = 65536;

    public int solution(String str1, String str2) {
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> inter = new ArrayList<>();
        List<String> union = new ArrayList<>();

        loop:
        for(int i=0; i<str1.length() - 1; i++){
            String str = str1.substring(i, i + 2);

            for(int j=0; j<str.length(); j++){
                if(!isAlpha(str.charAt(j))) continue loop;
            }

            str1List.add(str);
        }

        loop:
        for(int i=0; i<str2.length() - 1; i++){
            String str = str2.substring(i, i+2);

            for(int j=0; j<str.length(); j++){
                if(!isAlpha(str.charAt(j))) continue loop;
            }

            str2List.add(str);
        }

        for(String str : str1List){
            if(str2List.contains(str)){
                str2List.remove(str);
                inter.add(str);
            }
            union.add(str);
        }

        for(String str: str2List){
            union.add(str);
        }

        // System.out.println(inter.size() + " " + union.size());

        int total = union.size();
        int same = inter.size();

        if(total == 0){
            return NUM;
        }else{
            return NUM * same / total;
        }

    }

    static boolean isAlpha(char c){
        if((c >= 65 && c<= 90) || (c >=97 && c<= 122) ){
            return true;
        }

        return false;
    }
}