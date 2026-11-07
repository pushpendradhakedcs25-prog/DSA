import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
           int []arr=new int[3];
           for(int j=0; j<3; j++){
               arr[j]=sc.nextInt();
           }
           Arrays.sort(arr);
            System.out.println(arr[1]);
        }
    }
}
