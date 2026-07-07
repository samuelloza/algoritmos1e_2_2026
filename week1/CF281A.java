import java.util.Scanner;

public class CF281A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        System.out.print(line.charAt(0) + "".toUpperCase());
        System.out.println(line.substring(1, line.length()));
        
    }
}
