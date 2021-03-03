package com.patterns.modifiedbinarysearch;

public class ArrayReader {

    public int[] arr;

    public ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}
