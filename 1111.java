class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int []arr= new int [n];
        int dept=1;
        for(int i=0; i<n; i++){
             if(seq.charAt(i)=='('){
                 dept++;
                arr[i]=dept%2;
             }else {
                arr[i]=dept%2;
                dept--;
             }
        }
        return arr;
    }
}