package week4;

import java.util.Scanner;

/**
 * u10026
 */
/**
 * Inneru10026
 */
class Job {
    public int index;
    public int time;
    public int multa;

    public Job(int index, int time, int multa) {
        this.index = index;
        this.time = time;
        this.multa = multa;
    }
}

public class u10026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Job[] jobs = new Job[n];
            int time, multa;
            for (int i = 0; i < n; i++) {
                time = sc.nextInt();
                multa = sc.nextInt();
                jobs[i] = new Job((i + 1), time, multa);
            }
            bubbleSortOptimized(jobs);
            for (int i = 0; i < jobs.length; i++) {
                System.out.print(jobs[i].index);
                if (i + 1 != jobs.length) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if (t > 0) {
                System.out.println();
            }
        }
    }

    public static void bubbleSortOptimized(Job arr[]) {
        int n = arr.length;
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                double auxA = (double) arr[i - 1].multa / arr[i - 1].time;
                double auxB = (double) arr[i].multa / arr[i].time;
                if (auxA < auxB) {
                    Job tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    swapped = true;
                } else if (auxA == auxB) {
                    //Comparacion Lexicografica
                    if (arr[i - 1].index > arr[i].index) {
                        Job tmp = arr[i];
                        arr[i] = arr[i - 1];
                        arr[i - 1] = tmp;
                        swapped = true;
                    }
                }
            }
            n--;
        }
    }
}