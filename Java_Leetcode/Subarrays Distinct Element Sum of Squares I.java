class Solution {
    public int sumCounts(List<Integer> nums) {
        return check(nums, 0, 0);
    
    }
    private int check(List<Integer> num , int start, int end){
        if(start==num.size()){
            return 0;
        }
        if(end ==num.size()){
            return check(num, start+1, start+1);
        }
        HashSet<Integer> set= new HashSet<>();
        for(int i=start; i<=end; i++){
             set.add(num.get(i));
        }
        int dis= set.size();
        return dis*dis + check( num, start ,end +1); 
    }
}
