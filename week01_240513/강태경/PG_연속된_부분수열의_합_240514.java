class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int sum = sequence[start];
        while(start<=end){
            if(sum<k){
                if(end==sequence.length-1) break;
                end++;
                sum += sequence[end];
            } else if(sum>k){
                sum -= sequence[start++];
            } else{
                if(end-start+1<len){
                    answer =  new int[]{start, end};
                    len = end-start+1;
                }
                sum -= sequence[start++];
            }
        }
        return answer;
    }
}