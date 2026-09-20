class Solution {
    public int subtractProductAndSum(int n) {
        int sum =0;
        int pr=1;
        while(n>0){
            int ld = n%10;
            sum =sum+ld;
            pr*=ld;
            n/=10;
        }
        return pr-sum;
    }
}
