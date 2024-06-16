import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        int N = elements.length;
        Set<Integer> set = new HashSet<Integer>();

        for(int i=1;i<=N;i++){
            for(int j=0;j<N;j++){
                int c = i;
                int temp =0;
                int next = j;
                while(c-- > 0){
                    temp += elements[next++%N];
                }
                set.add(temp);
            }
        }
        answer = set.size();
        return answer;
    }
}