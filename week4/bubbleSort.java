package week4;

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void printPerson() {
        System.out.println("Name " + this.name + " Age " + this.age);
    }
}

public class bubbleSort {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("----bubbleSortOptimized----");
        int arrInt[] = { 4, 5, 8, 7, 9, 1, 2, 100 };
        bubbleSortOptimized(arrInt);
        printArray(arrInt);
        System.out.println("-----");

        /*
         * int n = arr.length;
         * for (int i = 0; i < n; i++) {
         * for (int j = 0; j < n - i - 1; j++) {
         * if (arr[j] > arr[j + 1]) {
         * // swap
         * int tmp = arr[j];
         * arr[j] = arr[j + 1];
         * arr[j + 1] = tmp;
         * }
         * }
         * }
         * printArray(arr);
         */

        Person arr[] = {
                new Person("JULIO Z", 20), new Person("E", 18),
                new Person("JULIO A", 20), new Person("F", 1),
                new Person("C", 19), new Person("G", 29),
                new Person("D", 22), new Person("H", 30),
        };

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].age > arr[j + 1].age) {
                    // swap
                    Person tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                } else if (arr[j].age == arr[j + 1].age) {
                    if (arr[j].name.compareTo(arr[j + 1].name) > 0) {
                        Person tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }

            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i].printPerson();
        }
    }

    public static void bubbleSortOptimized(int arr[]) {
        int n = arr.length;
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[i- 1];
                    arr[i- 1] = tmp;
                    swapped = true;
                }
            }
            n--;
        }
    }
}
