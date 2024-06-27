class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        int chk[100001] = {};
        for(int i = 0 ; i < edges.size(); i ++){
            chk[edges[i][0]] ++;
            chk[edges[i][1]] ++;
        }
        int ans = 0;
        for(int i = 0 ; i < 100001; i ++){
            if(chk[i] >= 2) ans = i;
        }
        return ans;
    }
};
