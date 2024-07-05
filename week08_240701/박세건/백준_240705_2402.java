세그먼트 트리 사용
구간 합을 구할때 log N 의 속도로 해결할 수 있는 알고리즘
구간 합을 구해야하는데 내용이 계속 수정되는 경우 생각

이분탐색 트리 개념을 사용
  최상위 노드는 모든 배열의 합을 저장(start ~ end)
  왼쪽 자식 노드에게는 왼쪽 부분의 합을 저장(start ~ mid)
  오른쪽 자식 노드에게는 오른쪽 부분의 합을 저장(mid+1 ~ end)
  
구현 방식
  트리를 만들어주는 함수(curStart, curEnd, curNode) - 최상위 노드는 자식노드 두개의 합이라는 것을 재귀 함수를 사용해서 구현, curStart와 curEnd가 같아지면 arr 값으로 리턴
  트리 내부를 수정해주는 함수(curStart, curEnd, curNode, idx, val) - 최상위 노드부터 시작해서 curStart~curEnd 범위에 내가 찾는 idx가 존재하는지를 확인하면서 수정
  트리를 통해 구간 합을 구해주는 함수(curStart, curEnd, curNode, targetStart, targetEnd) - curStart~curEnd 범위가 내가 찾고자 하는 targetStart~targetEnd 사이에 존재하는지를 확인하면서 진행

  

------------------------------------------------

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M, K;
    private static long[] arr;
    private static long[] segmentTree;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        /*
         *   [i][0] : 처음에 저장된 값, [i][0] : 이후 수정된 값
         * */
        arr = new long[N + 1];

        segmentTree = new long[N * 4];
        for (int i = 1; i <= N; i++) {
            long x = Long.parseLong(br.readLine());
            arr[i] = x;
        }
        makeTree(1, N, 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                updateValue(1, N, 1, b, diff);
            } else {
                long answer = findSum(1, N, 1, b, (int) c);
                System.out.println(answer);
            }
        }

    }

    private static long findSum(int curStart, int curEnd, int cur, int start, int end) {
        //원하는 범위를 벗어났을때
        if (end < curStart || start > curEnd) {
            return 0;
        }
        //원하는 범위가 현재 범위 안에 위치할때
        if (start <= curStart && curEnd <= end) {
            return segmentTree[cur];
        }
        //원하는 범위가 걸쳐있을경우
        int mid = (curStart + curEnd) / 2;
        return findSum(curStart, mid, cur * 2, start, end) + findSum(mid + 1, curEnd, cur * 2 + 1, start, end);
    }

    private static void updateValue(int curStart, int curEnd, int cur, int target, long value) {
        if (curStart > target || target > curEnd) {
            return;
        }
        segmentTree[cur] += value;
        if (curStart == curEnd) {
            return;
        }
        int mid = (curStart + curEnd) / 2;
        updateValue(curStart, mid, cur * 2, target, value);
        updateValue(mid + 1, curEnd, cur * 2 + 1, target, value);
    }

    private static long makeTree(int start, int end, int cur) {
        if (start == end) {
            return segmentTree[cur] = arr[start];
        }
        int mid = (start + end) / 2;
        return segmentTree[cur] = makeTree(start, mid, cur * 2) + makeTree(mid + 1, end, cur * 2 + 1);
    }

}
