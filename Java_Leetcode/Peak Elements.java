class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int t=0;
      for(int i=0; i<n; i++){
        if(max<nums[i]){
            max=nums[i];
            t=i;
        }
      }
      return t;
    }
}
