package com.example;

public class MyClass {
    public static void main(String[] arg) {
        int[] a = {1, 4, 2};
        int[] b = {1, 3, 4, 7, 4, 5};
        int[] list = new int[a.length + b.length];
        System.arraycopy(a, 0, list, 0, a.length);
        System.arraycopy(b, 0, list, a.length, b.length);

        for (int i : list){
            System.out.println(i);
        }

        System.out.println("-------------------------");

        quickSort(list);

        for (int i : list){
            System.out.println(i);
        }
    }

    private static void quickSort(int[] list) {
        if (list.length > 0) {
            qSort(list, 0, list.length - 1);
        }
    }

    private static void qSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);
            qSort(list, low, middle - 1);
            qSort(list, middle + 1, high);
        }
    }

    private static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];

            while ((low < high && list[low] <= tmp)) {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = tmp;
        return low;
    }
}
