package week5;

public class binarySearch {

    public static int binarySearch(int vec[], int target) {
        int low = 0;
        int high = vec.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (vec[mid] == target) {
                return mid;
            } else if (target > vec[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // No existe
        return -1;
    }

    public static void main(String[] args) {
        int vec[] = { 1, 5, 9, 10, 20, 31, 100 };
        int target = 10;
        System.out.println(binarySearch(vec, target));
    }
}
