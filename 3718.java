class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new  HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

         for(int j=1; j<=nums.length+1; j++){
           int p=k*j;
           if(!set.contains(p)){
            return p;
           }
        }
        return 0;
        
    }
}