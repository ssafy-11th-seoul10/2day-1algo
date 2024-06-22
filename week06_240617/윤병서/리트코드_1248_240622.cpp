class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        deque<int> dq;
        int ans = 0;
        int oddcount = 0;
        int r = 0;
        for(int i = 0 ; i < nums.size(); i ++){
            if(nums[i] %  2 == 1){
                oddcount ++;
                dq.push_back(i);
            }
            while(oddcount > k){
                if(nums[r] % 2 == 1) oddcount --;
                r ++;
                if(dq.front() < r) dq.pop_front();
            }
            if(oddcount == k) ans += dq.front() - r + 1;
        }
        return ans;
    }
};
