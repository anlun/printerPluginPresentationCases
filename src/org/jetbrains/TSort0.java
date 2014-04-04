package org.jetbrains;

public class TSort0 {
    private final int[] a;

    private void exchange(int i, int j) {
        final int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void reverseSort() {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) { exchange(i, j); }
            }
        }
    }

    private void quickSort() { quickSort(0, a.length - 1); }
    private void quickSort(int left, int right) {
        if (right - left <= 0) { return; }
        final int separator = a[left + (right - left) / 2];

        int i = left;
        int j = right;
        while (i < j) {
            while (a[i] < separator) { i++; }
            while (a[j] > separator) { j--; }
            if (i <= j) {
                exchange(i, j);
                i++; j--;
            }
        }

        if (j > left ) { quickSort(left, j); }
        if (i < right) { quickSort(i, right); }
    }

    private void printArray() {
        for (int e: a) { System.out.print(e + " "); }
        System.out.println();
    }

    public TSort0(int[] arr) {
        a = arr;
    }

    public static void main(String[] args) {
        final int[] arr = {1, 10, 2, 9, 3, 8, 4, 7, 6, 5};
        TSort0 m = new TSort0(arr);
        m.printArray();
        m.quickSort();
        m.printArray();
        m.reverseSort();
        m.printArray();
    }
}