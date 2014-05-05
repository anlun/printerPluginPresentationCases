package org.jetbrains;

public class TSort1_A {
    private final double[ ] myArr;

    private void exchange (
            int i, int j)
    {   final double temp = myArr[i];
        myArr[i] = myArr[j];
        myArr[j] = temp; }

    private void reverseSort ()
    {   for (int i = 0; i < myArr.length - 1; i++)
        {
            for (int j = i + 1; j < myArr.length; j++)
            {
                if (myArr[i] < myArr[j])
                {
                    exchange (i, j); } } } }

    private double[] myBuffer;
    private void mergeSort ()
    {
        mergeSort (0, myArr.length); }
    private void mergeSort (
            int l, int r)
    {   if (r - l <= 1)
        {
            return; }
        final int middle = l + (r - l) / 2;
        mergeSort (l, middle);
        mergeSort (middle, r);
        int i = l, j = middle;
        int k = 0;
        while (i < middle && j < r)
        {
            if (myArr[i] < myArr[j])
            {
                myBuffer[k] = myArr[i];
                i++; k++; }
            else {
                myBuffer[k] = myArr[j];
                j++; k++; } }
        while (i < middle)
        {
            myBuffer[k] = myArr[i]; i++; k++; }
        while (j < r)
        {
            myBuffer[k] = myArr[j]; j++; k++; }
        System.arraycopy (myBuffer, 0, myArr, l, k);
    }

    private void printArray ()
    {
        for (double e: myArr) { System.out.print (e + " "); }
        System.out.println (); }

    public TSort1_A (
            double[] arr)
    {
        myArr = arr;
        myBuffer =  new double[myArr.length]; }

    public static void main (
            String[] args) {
        final double[] arr = {1, 10, 2, 9, 3, 8, 4, 7, 6, 5};
        TSort1_A m = new TSort1_A (arr);
        m.printArray ();
        m.mergeSort ();
        m.printArray ();
        m.reverseSort ();
        m.printArray (); } }
