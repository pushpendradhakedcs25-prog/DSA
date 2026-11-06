import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int[] arr = new int[a];
            for (int j = 0; j < a; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            int count = 0;
            int start = 0;
            int end = arr.length - 1;
            while (start < end) {
                count += arr[end] - arr[start];
                start++;
                end--;
            }
            System.out.println(count);
        }
    }
}
