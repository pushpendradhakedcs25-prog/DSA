 import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static long sum (int arr[]){
        long sum =0;
        for(int i=0; i<arr.length; i++){
            sum +=arr[i];
        }
        return sum ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int t=sc.nextInt();
            int k=sc.nextInt();
            int[] arr1 = new int[t];
            int []arr2= new int [t];

            for(int j=0; j<t; j++){
                arr1[j]=sc.nextInt();
            }
            Arrays.sort(arr1);
            for(int j=0; j<t; j++){
                arr2[j]=sc.nextInt();
            }
            Arrays.sort(arr2);
            int start=0;
            int end =t-1;
            while(k>0&&start<t&&end>=0) {
                if (arr1[start] < arr2[end]) {
                    int temp = arr1[start];
                    arr1[start] = arr2[end];
                    arr2[end] = temp;
                    start++;
                    end--;
                    k--;
                } else {
                    break;
                }
            }

            long sum1=sum(arr1);

            System.out.println( sum1);
        }
    }
}
