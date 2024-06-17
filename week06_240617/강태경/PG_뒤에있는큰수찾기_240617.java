class PG_뒤에있는큰수찾기_240617 {
    public int[] solution(int[] numbers) {
        //1-1. 뒤에서 앞으로 오는 방식 사용
        //1-2. 숫자 대신 위치를 기록
        //2-1. 앞 숫자랑 같은 경우 앞 숫자에 표기된 위치 표기
        //2-2. 앞 숫자보다 작은 경우 앞 숫자의 위치 표기
        //2-3. 앞 숫자보다 큰 경우 앞 숫자의 답 위치를 따라가며 큰 숫자 찾기 없으면 -1
        int n = numbers.length;
        int[] answer = new int[n];
        int[] arr = new int[n];
        arr[n-1] = -1;
        for (int i = n-2; i >= 0; i--) {
            if(numbers[i]==numbers[i+1]){
                arr[i] = arr[i+1];
            } else if(numbers[i]<numbers[i+1]){
                arr[i] = i+1;
            } else{
                int idx = arr[i+1];
                while(true){
                    if(idx==-1){
                        arr[i]=-1;
                        break;
                    }
                    if(numbers[i]<numbers[idx]){
                        arr[i] = idx;
                        break;
                    }
                    idx = arr[idx];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(arr[i]==-1){
                answer[i] = -1;
            } else{
                answer[i] = numbers[arr[i]];
            }
        }
        return answer;
    }
}