class Solution {
    public int solution(String name) {
        int answer = 0;
        int[] move = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int size = name.length();
        int pos = size - 1; // 끝까지 다 이동한다고 가정 
        
        for (int i = 0; i < size; i++) {
            answer += move[name.charAt(i) - 'A'];
            
            int j = i + 1; // A가 아닌 문자가 있는 다음 위치
            while (j < size && name.charAt(j) == 'A') j++;
            
            // 앞에서 뒤로 가는 것과 뒤로 갔다가 돌아오는 것 중 최솟값
            // pos = Math.min(pos, Math.min(i + i + (size - j), i + (size - j) + (size - j)));
            pos = Math.min(pos, i +size - j + Math.min(i, size - j));
        }
        
        answer += pos;
        return answer;
    }
}
