package org.jetbrains;

public class TSort2 {
    private final float[] m_arr;

    private void exchange(int i, int j) {
        final float temp = m_arr[i];
        m_arr[i] = m_arr[j];
        m_arr[j] = temp;
    }

    private void sift_down(int i, int j) {
        boolean done = false;
        int maxChild;
        while ((i * 2 < j) && !done) {
            if (i * 2 == j || m_arr[i * 2] > m_arr[i * 2 + 1])
                 maxChild = i * 2;
            else maxChild = i * 2 + 1;

            if (m_arr[i] < m_arr[maxChild]) {
                exchange(i, maxChild);
                i = maxChild;
            } else {
                done = true;
            }
        }
    }

    private void heap_sort() {
        for (int i = m_arr.length / 2 - 1; i >= 0; i--) {
            sift_down(i, m_arr.length);
        }
        for (int i = m_arr.length - 1; i >= 1; i--) {
            exchange(0, i);
            sift_down(0, i - 1);
        }
    }

    private void reverse_sort() {
        for (int i = 0; i < m_arr.length - 1; i++) {
            for (int j = i + 1; j < m_arr.length; j++) {
                if (m_arr[i] < m_arr[j]) { exchange(i, j); }
            }
        }
    }

    private void print_array() {
        for (float e: m_arr) { System.out.print(e + " "); }
        System.out.println();
    }

    public TSort2(float[] arr) {
        m_arr = arr;
    }

    public static void main(String[] args) {
        final float[] arr = {1, 10, 2, 9, 3, 8, 4, 7, 6, 5};
        TSort2 m = new TSort2(arr);
        m.print_array();
        m.heap_sort();
        m.print_array();
        m.reverse_sort();
        m.print_array();
    }
}
