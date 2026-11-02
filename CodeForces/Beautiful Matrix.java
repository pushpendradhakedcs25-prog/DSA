
import java.util.Scanner;

public class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int a;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a = sc.nextInt();

                if (a == 1) {
                    System.out.println(Math.abs(i - 2) + Math.abs(j - 2));
                    return;
                }
            }
        }
    }
}
