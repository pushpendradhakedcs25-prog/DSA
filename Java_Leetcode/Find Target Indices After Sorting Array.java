class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list =new ArrayList<>();
        Arrays.sort(nums);
        check(nums, target,0, list);
        return list;
    
    }
    private void check(int []nums, int target, int index ,List<Integer>result){
        if(index==nums.length){
            return ;
        }
        if(nums[index]==target){
          result.add(index);
        }
      check(nums,target, index+1, result);
    }
}
