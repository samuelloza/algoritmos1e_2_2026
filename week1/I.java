import java.util.Scanner;
/**
 * https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/I
 * I
 */
public class I {

    public static int esVocal (char cad) {
        if (cad == 'a' || cad == 'e' || cad == 'i' || cad == 'o' || cad == 'u') {
            return 1;
        }
        return 0;
    }

    public static int f(String cad, int i) {
        //Base
        if (cad.length() == i) {
            return 0;
        }
        //verificar si es vocal
        return esVocal(cad.charAt(i)) + f(cad, i + 1);
        //1 + 0 + 1 + 0
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String cad = sc.nextLine().toLowerCase();
        int ans = f(cad, 0);
        System.out.println(ans);
    }
}
