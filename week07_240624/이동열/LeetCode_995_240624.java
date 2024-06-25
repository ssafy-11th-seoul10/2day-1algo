package leetcode;

import java.util.*;
class LeetCode_995 {

    /**
     * k개 직접 바꿔주면 시초
     * 현재 값이 0이면 index+k-1개 만큼 큐에 담기
     * 이미 answer가 진행된만큼(현재 answer값)을 count값에 담아두기
     * 뒤집힌 횟수는 현재 answer - count
     */

    private static class Node{
        int index;
        int count;
        int value;
        public Node(int index, int count, int value) {
            this.index = index;
            this.count = count;
            this.value = value;
        }
    }

    public static int minKBitFlips(int[] nums, int k) {
        Deque<Node> deque = new ArrayDeque<>();
        boolean flag = true;    //모두 1인지 검사하고 시작
        int currIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                deque.add(new Node(i, 0, 0));   //처음으로 0인 곳 넣고 시작
                currIndex = i;
                flag = false;
                break;
            }
        }
        if(flag){
            return 0;   //모두 1일떄
        }

        int answer = 0;
        while (currIndex < nums.length) {
            while (!deque.isEmpty()) {
                Node curr = deque.poll();

                //값이 0인 경우
                if ((answer - curr.count) % 2 == curr.value) { //짝수번 바뀌었을 때 0 또는 홀수번 바뀌었을때 1
                    if (curr.index + k > nums.length) {
                        return -1;
                    } //불가능한 경우
                    for (int i = currIndex + 1; i < curr.index + k; i++) {
                        deque.add(new Node(i, answer, nums[i]));
                    } //새로 바뀐 값들만 넣어주기
                    answer += 1;
                    currIndex = curr.index + k - 1;
                }
            }
            if(currIndex<nums.length){
                for (int i = currIndex+1; i < nums.length; i++) {
                    if (nums[i] == 0) {
                        deque.add(new Node(i, answer, 0));
                        currIndex = i;
                        break;
                    }
                }
            }
            if(deque.isEmpty()){
                return answer;
            }
        }
        return answer;
    }
}