class Solution {
public:
    int firstStableIndex(vector<int>& nums, int k) {
        int n=nums.size();
        for(int i=0; i<n; i++){
            int max =INT_MIN;
            int min=INT_MAX;
            for(int j=0; j<=i; j++){
                max=std::max(max,nums[j]);
            }
            for(int j=i; j<n; j++){
                 min=std::min(min,nums[j]);
            }
            if(max-min<=k) return i;
        }
        return -1;
    }
};
