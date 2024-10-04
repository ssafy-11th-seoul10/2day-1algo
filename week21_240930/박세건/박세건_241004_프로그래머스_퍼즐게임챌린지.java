import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start=1;
        int end=1;
        for(int i=0;i<diffs.length;i++){
            end=Math.max(end,diffs[i]);
        }
        
        while(start<end){
            int mid=(start+end)/2;
            long result=playGame(mid,diffs,times);
            System.out.println(mid+" "+result);
            if(result<=limit){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return end;
    }
    public long playGame(int mid,int[] diffs, int[] times){
        long result=0;
        for(int i=0;i<diffs.length;i++){
            if(mid>=diffs[i]){
                result+=times[i];
            }else{
                if(i==0){
                    result+=(diffs[i]-mid+1)*times[i];
                }else{
                    result+=(diffs[i]-mid)*(times[i-1]+times[i])+times[i];
                }        
            }
        }
        return result;
    }
}
