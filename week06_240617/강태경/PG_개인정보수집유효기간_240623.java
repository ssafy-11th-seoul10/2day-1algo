import java.util.*;

class PG_개인정보수집유효기간_240623 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //약관 종류에 따라 유효기간이 다름
        //1년 뒤 파기
        //파기해야 될 번호 오름차순
        int[] answer = {};
        StringTokenizer stk = new StringTokenizer(today, ".");
        int ny = Integer.parseInt(stk.nextToken());
        int nm = Integer.parseInt(stk.nextToken());
        int nd = Integer.parseInt(stk.nextToken());

        Map<String, Integer> map = new TreeMap<>();
        for (String term : terms) {
            stk = new StringTokenizer(term);
            String type = stk.nextToken();
            int valid = Integer.parseInt(stk.nextToken());
            map.put(type, valid);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            stk = new StringTokenizer(privacies[i]);
            String dateTime = stk.nextToken();
            String type = stk.nextToken();
            int plusMonth = map.get(type);
            stk = new StringTokenizer(dateTime, ".");
            int year = Integer.parseInt(stk.nextToken());
            int month = Integer.parseInt(stk.nextToken()) + plusMonth;
            int day = Integer.parseInt(stk.nextToken());
            year+=(month-1)/12;
            month=(month-1)%12+1;
            if(year<ny){
                list.add(i+1);
            } else if(year==ny){
                if(month<nm){
                    list.add(i+1);
                } else if(month==nm){
                    if(day<=nd){
                        list.add(i + 1);
                    }
                }
            }
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}