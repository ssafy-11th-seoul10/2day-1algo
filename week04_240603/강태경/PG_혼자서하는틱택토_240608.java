class PG_혼자서하는틱택토_240608 {
    public int solution(String[] board) {
        int o = 0;
        int x = 0;
        for (String s : board) {
            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);
                if(now=='O') o++;
                else if(now=='X') x++;
            }
        }

        //1. 마킹을 실수
        //1-1. O가 X보다 2개 이상 많다.
        //1-2. X가 O보다 많다.

        if(o>=x+2||x>o) {
            return 0;
        }

        //2. 이겼는데 게임을 진행
        //2-1. 둘 다 이기는 경우
        //2-2. O가 이겼는데 X가 O랑 같다.
        //2-3. X가 이겼는데 O가 X보다 1많다.

        //가로
        boolean oWin = false;
        boolean xWin = false;
        for (int i = 0; i < 3; i++) {
            if(board[i].charAt(0)=='.') continue;
            if(board[i].charAt(0)==board[i].charAt(1)&&board[i].charAt(0)==board[i].charAt(2)){
                if(board[i].charAt(0)=='O') oWin=true;
                else xWin = true;
            }
        }

        //세로
        for (int i = 0; i < 3; i++) {
            if(board[0].charAt(i)=='.') continue;
            if(board[0].charAt(i)==board[1].charAt(i)&&board[0].charAt(i)==board[2].charAt(i)){
                if(board[0].charAt(i)=='O') oWin=true;
                else xWin = true;
            }
        }


        //대각선
        if(board[0].charAt(0)!='.'&&board[0].charAt(0)==board[1].charAt(1)&&board[0].charAt(0)==board[2].charAt(2)){
            if(board[0].charAt(0)=='O') oWin=true;
            else xWin = true;
        } else if(board[0].charAt(2)!='.'&&board[0].charAt(2)==board[1].charAt(1)&&board[0].charAt(2)==board[2].charAt(0)){
            if(board[0].charAt(2)=='O') oWin=true;
            else xWin = true;
        }

        if(oWin&&xWin) return 0;
        if(oWin&&o==x) return 0;
        if(xWin&&o==x+1) return 0;

        return 1;
    }
}