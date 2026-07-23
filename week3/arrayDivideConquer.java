package week3;

/**
 * arrayDivideConquer
 */
public class arrayDivideConquer {
    public static int maximo(int[] vec, int begin, int end) {
        if (begin == end) {
            return vec[begin];
        }

        int mid = (begin + end) / 2;
        System.out.println(begin + " "+ mid + " | " + (mid + 1) + " " + end);
        int left = maximo(vec, begin, mid);
        int right = maximo(vec, mid + 1 , end);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int vec[] = {7,2,15,4,9,21,3,12, 34};
        System.out.println(maximo(vec, 0, vec.length - 1));
    }

}