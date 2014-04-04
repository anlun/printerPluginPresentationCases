package org.jetbrains;

public class ExToReprint {
    private long[] array;

    int binarySearch(long v) {
        return binarySearch(v, 0, array.length);
    }
    int binarySearch(long v, int l, int r) {
        if (r - l <= 1) {
            if (array[l] == v) { return l; }
            return -1;
        }
        int medium = l + (r - l) / 2;
        if (v >  array[medium]) { return binarySearch(v, medium, r); }
        if (v <  array[medium]) { return binarySearch(v, l, medium); }
        return medium;
    }

    void sort() {
        for (int i = array.length - 1; i >= 0; i--) {
            long max = array[0];
            array[0] = array[i];
            for (int j = 0; j < i; j++) {
                if (array[j] > max) {
                    final long temp = max;
                    max = array[j];
                    array[j] = temp;
                }
            }
            array[i] = max;
        }
    }

    private void printArray() {
        for (long e: array) { System.out.print(e + " "); }
        System.out.println();
    }

    public ExToReprint(long[] arr) {
        array = arr;
    }

    public static void main(String[] args) {
        final long[] arr = {1, 0, 2, 9, 3, 8, 4, 7, 6, 5};
        ExToReprint m = new ExToReprint(arr);
        m.printArray();
        m.sort();
        m.printArray();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(m.binarySearch(i) + " ");
        }
        System.out.println();
    }
}
