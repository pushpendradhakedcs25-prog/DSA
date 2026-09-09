class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long start = 1000;
        long digits = 1;

        while (start <= n) {
            long end = Math.min(n, start * 1000 - 1);
            ans += (end - start + 1) * digits;
            start *= 1000;
            digits++;
        }

        return ans;
    }
}
