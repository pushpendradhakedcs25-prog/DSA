lass Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int k = n / 2 - 1;
        long sum = 0;
        while (k >= 0) {
            sum += (long) -nums[k] * nums[k];
            k--;
        }
        for (int i = n / 2; i < n; i++) {
            sum += (long) nums[i] * nums[i];
        }
        return sum;
    }

}
