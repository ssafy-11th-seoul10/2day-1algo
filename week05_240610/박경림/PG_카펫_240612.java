class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int blocks = brown + yellow;
        int width = 3;
        int height = 1;
        
        while (true) {
            height = blocks / width;
            int rem = blocks % width;
            
            if (rem == 0 && width >= height && yellow == (width - 2) * (height - 2)) {
                answer[0] = width;
                answer[1] = height;
                return answer;
            }
            
            width += 1;
        }
    }
}
