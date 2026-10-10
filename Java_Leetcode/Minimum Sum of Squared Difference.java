class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        long[] diff = new long[n];
        long max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) return 0;

        long low = 0, high = max;

        while (low < high) {
            long mid = (low + high) / 2;
            long need = 0;

            for (long d : diff) {
                if (d > mid) need += d - mid;
            }

            if (need <= k) high = mid;
            else low = mid + 1;
        }

        long level = low;
        long used = 0;
        long result = 0;

        for (long d : diff) {
            long reduced = Math.min(d, level);
            used += d - reduced;
            result += reduced * reduced;
        }

        long remaining = k - used;

        for (long d : diff) {
            if (remaining == 0) break;
            if (d >= level && level > 0) {
                result -= level * level;
                result += (level - 1) * (level - 1);
                remaining--;
            }
        }

        return result;
    }
}
