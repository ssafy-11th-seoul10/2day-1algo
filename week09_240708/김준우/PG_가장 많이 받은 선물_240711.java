import java.util.HashMap;

class Solution {
    static HashMap<String, Integer> name2idx = new HashMap<String, Integer>();
    static int[][] relation;
    static int[] giftPoint;
    static int[] thisMonth;
    
    public int solution(String[] friends, String[] gifts) {
        thisMonth = new int[friends.length];
        giftPoint = new int[friends.length];

        for(int i = 0; i < friends.length; i++) { 
            name2idx.put(friends[i], i);
        }
        relation = new int[friends.length][friends.length];
        for (int i = 0; i < gifts.length; i++) { 
            String giver = gifts[i].split(" ")[0];
            String receiver = gifts[i].split(" ")[1];
            int giver_idx = name2idx.get(giver);
            int receiver_idx = name2idx.get(receiver);
            relation[giver_idx][receiver_idx]++;
        }
        
        for (int i = 0; i < friends.length; i++) {
            int giveP = 0;
            int recP = 0;
            for (int j = 0; j < friends.length; j++) {
                giveP += relation[i][j];
                recP += relation[j][i];
            }
            giftPoint[i] = giveP - recP;
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i+1; j < friends.length; j++) {
                if(relation[i][j] == relation[j][i]) {
                    if (giftPoint[i] > giftPoint[j]) {
                        thisMonth[i]++;
                    } else if (giftPoint[i] < giftPoint[j]) { 
                        thisMonth[j]++;
                    }
                } else { 
                    if (relation[i][j] > relation[j][i]) {
                        thisMonth[i]++;
                    } else {
                        thisMonth[j]++;
                    }              
                }
            }
        }
        
        
        
//         for (int i = 0; i < friends.length; i++) {
//             for (int j = 0; j < friends.length; j++) { 
//                 System.out.print(relation[i][j] + " ");

//             }System.out.println();
//         }
        int maxi = 0;
        for (int i = 0; i < friends.length; i++) {
            if (maxi < thisMonth[i]) {
                maxi = thisMonth[i];
            }
        }
        return maxi;
    }
}