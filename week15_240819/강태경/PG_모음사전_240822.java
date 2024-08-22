package PG;

public class PG_모음사전_240822 {
    public static void main(String[] args) {

        String word = "EIO";

        // A, E, I, O, U -> 5개
        // 길이 1~5
        // O(5^1 + 5^2 + 5^3 + 5^4+5^5)
        StringBuilder buf = new StringBuilder();
        int idx = 0;
        while(true){
            idx++;
            if(buf.length()<5){
                buf.append('A');
            } else{
                int pointer = 4;
                while(pointer>0){
                    char now = buf.charAt(pointer);
                    if(now=='A'){
                        buf.deleteCharAt(pointer);
                        buf.append('E');
                    } else if(now=='E'){
                        buf.deleteCharAt(pointer);
                        buf.append('I');
                    }else if(now=='I'){
                        buf.deleteCharAt(pointer);
                        buf.append('O');
                    }else if(now=='O'){
                        buf.deleteCharAt(pointer);
                        buf.append('U');
                    } else{
                        buf.deleteCharAt(pointer);
                        if(buf.length()==1){
                            now = buf.charAt(0);
                            if(now=='A'){
                                buf.deleteCharAt(0);
                                buf.append('E');
                            } else if(now=='E'){
                                buf.deleteCharAt(0);
                                buf.append('I');
                            }else if(now=='I'){
                                buf.deleteCharAt(0);
                                buf.append('O');
                            }else if(now=='O'){
                                buf.deleteCharAt(0);
                                buf.append('U');
                            }
                        }

                    }
                    if(now!='U') break;
                    pointer--;
                }
            }
            if (buf.toString().equals(word)) {
                System.out.println(idx);
                break;
            }
        }

    }
}
