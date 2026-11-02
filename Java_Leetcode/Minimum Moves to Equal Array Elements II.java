class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum =0;
        int n= nums.length;
        int target = n/2;
        for(int i=0; i<n; i++){
            sum+=Math.abs(nums[i]-nums[target]);
        }
        return sum;
    }
}
