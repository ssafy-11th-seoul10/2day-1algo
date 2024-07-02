import java.util.*;

class PG_테이블해시함수_240702 {

    static class Tuple implements Comparable<Tuple>{
        int[] attr;


        public Tuple(int[] attr) {
            this.attr = attr;
        }

        public int[] getAttr() {
            return attr;
        }

        //기본 정렬
        @Override
        public int compareTo(Tuple o) {
            int first = attr[sCol-1];
            int second = o.attr[sCol - 1];
            if(first==second) return o.attr[0] - attr[0];
            return first - second;
        }
    }

    static int sCol;

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        sCol = col;

        List<Tuple> tuples = new ArrayList<>();
        for (int[] row : data) {
            tuples.add(new Tuple(row));
        }
        Collections.sort(tuples);
        List<Integer> totals = new ArrayList<>();
        for (int row = row_begin; row <= row_end; row++) {
            int[] now = tuples.get(row-1).getAttr();
            int sum = 0;
            for (int num : now) {
                sum += num%row;
            }
            totals.add(sum);
        }
        int result = totals.get(0);
        for (int i = 1; i <totals.size() ; i++) {
            int now = totals.get(i);
            result ^= now;
        }
        return result;
    }
}