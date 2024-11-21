package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241121_5710 {

    static long toFee(long amount) {
        long fee = 0L;
        if(amount>100){
            fee += (100)*2;
            if(amount>10000){
                fee += (10000-100)*3;
                if(amount>1000000){
                    fee += (1000000-10000) * 5;
                    fee += (amount-1000000) * 7;
                } else {
                    fee += (amount-10000) * 5;
                }
            } else {
                fee += (amount-100) * 3;
            }
        } else {
            fee = amount*2;
        }
        return fee;
    }

    static long toAmount(long fee){
        long amount = 0L;
        if(fee>100*2){
            amount+=100;
            fee-=100*2;
            if(fee>(10000-100)*3){
                amount += 10000-100;
                fee-=(10000-100) * 3;
                if(fee>(1000000-10000)*5){
                    amount += 1000000-10000;
                    fee-=(1000000-10000) * 5;
                    amount += fee / 7;
                } else {
                    amount += fee / 5;
                }
            } else {
                amount += fee / 3;
            }
        } else {
            amount = fee/2;
        }
        return amount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if(a == 0 && b==0) break;
            long totalAmount = toAmount(a);
            long start = 0;
            long end = totalAmount/2;
            long first = 0L;
            long second = 0L;
            // 사용량 2가지 찾기
            while (start <= end) {
                long mid = (start+end)/2;
                first = mid;
                second = totalAmount - first;
                long diff = Math.abs(toFee(second) - toFee(first));
                if(diff>b){
                    start = mid + 1;
                } else if(diff<b) {
                    end = mid - 1;
                } else {
                    if(toFee(second)-toFee(first) == b) break;
                }
            }
            sb.append(toFee(first)).append("\n");
        }
        System.out.println(sb);
    }
}
