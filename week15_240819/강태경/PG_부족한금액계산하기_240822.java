package PG;

public class PG_부족한금액계산하기_240822 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;


        long need = 0;
        for (int i = 1; i <= count; i++) {
            need+=price*i;
        }

        need -= money;
        if(need<=0){
            need = 0;
        }
        System.out.println(need);

    }
}
