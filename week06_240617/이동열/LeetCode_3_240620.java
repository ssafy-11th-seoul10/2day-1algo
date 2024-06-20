package leetcode;

import java.util.*;

class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int cnt = 0;
        List<Character> lst = new ArrayList();
        for(int i = 0; i<s.length(); i++){
            lst.clear();
            lst.add(s.charAt(i));
            cnt = 1;
            for(int j=i+1; j<s.length(); j++){
                char c = s.charAt(j);
                if(lst.contains(c)){
                    answer = Math.max(answer,cnt);
                    break;
                }
                else{
                    lst.add(c);
                    cnt+=1;
                }
            }
            answer = Math.max(answer,cnt);
        }
        return answer;
    }
}