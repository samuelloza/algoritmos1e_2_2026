//UVA10340
public class UVA10340 {

    public static void greedy(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                // System.out.println("A = " + i + " B " + j);
                i++;
            }
            j++;
        }
        if (i == s.length()) {
            System.out.println("Yes");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        greedy("person", "compression");
    }
}