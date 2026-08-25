class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        for(int i=0; i<nums.length; i++){
            int p=k;
            int sum =0;
            for(int j=i; j<nums.length; j++){
                if(nums[j]==0){
                    if(p==0){
                    break;
                }
                  p--;
                }
               
                    sum++;
                max=Math.max(max,sum);
        
            }
        }
        return max;
    }
}