import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class 240513_백준_1713 {
    static class Hubo implements Comparable<Hubo>{
        int num;
        int index;
        int count;

        public Hubo(int num){
            this.num = num;
            this.count = 1;
        }
        @Override
        public int compareTo(Hubo hubo){
            if(this.count > hubo.count){
                return 1;
            }else if(this.count < hubo.count){
                return -1;
            }else{
                if(this.index > hubo.index){
                    return 1;
                }else{
                    return -1;
                }

            }
        }
    }

    static List<Hubo> list;
    public static void main(String[] args) throws IOException {
        // 3
        // 2 1 4 3 5 6 2 7 2

        // 2
        // 2 1
        // 2 1 4
        // 1 4 3 // 2삭제
        // 4 3 5 // 1삭제
        // 3 5 6 // 4삭제
        // 5 6 2 // 3삭제
        // 6 2 7 // 5삭제
        // 6 2 7 //

        // 1. 추천 수가 가장 적은 학생 먼저 제거
        // 2. 게시된지 가장 오래된 사진 삭제

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 전체 추천 수

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            Hubo hubo = new Hubo(num);


            int findIndex = isContain(num);
            if(findIndex >=0){
                list.get(findIndex).count ++;
                Collections.sort(list);
                continue;
            }

            hubo.index = i;
            list.add(hubo);

            if(list.size() > n){
                list.remove(0);
            }
            Collections.sort(list);

        }

        Collections.sort(list, (o1, o2) -> {
            return Integer.compare(o1.num, o2.num);
        });

        for (Hubo hubo: list) {
            sb.append(hubo.num).append(" ");
        }
        System.out.println(sb);

    }

    static int isContain(int num){
        for(int i=0; i<list.size(); i++){
            if(num == list.get(i).num){
                return i;
            }
        }

        return -1;
    }
}
