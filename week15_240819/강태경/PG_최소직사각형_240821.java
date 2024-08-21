class PG_최소직사각형_240821 {
    public int solution(int[][] sizes) {
        //한쪽에 큰것끼리, 나머지에 작은것끼리 배치
        //w가 큰 것으로
        int walletW = 0;
        int walletH = 0;
        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            if(w<=h){
                int temp = w;
                w = h;
                h = temp;
            }
            walletW = Math.max(walletW, w);
            walletH = Math.max(walletH, h);
        }
        return walletW * walletH;
    }
}