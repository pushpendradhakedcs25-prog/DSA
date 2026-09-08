class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    private int atmost(int [] nums, int k){
        int c=0,odd=0,n=nums.length;
        int left=0;
        for(int right=0; right<n; right++){
                if(nums[right]%2==1){
                    odd++;
                }
                while(odd>k){
                    if(nums[left]%2==1){
                        odd--;
                    }
                    left++;
                }
                c+=right-left+1; // subarray length
        }
        return c;

    }
}
