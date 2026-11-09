import java.util.Scanner;
public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] ch = s.toCharArray();
        int COUNT = 0, count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (Character.isUpperCase(ch[i])) {
                COUNT++;
            } else {
                count++;
            }
        }
      if (COUNT > count) {
            System.out.println(s.toUpperCase());
        } else {
            System.out.println(s.toLowerCase());
        }

    }
}
