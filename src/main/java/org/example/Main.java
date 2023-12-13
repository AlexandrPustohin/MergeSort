package org.example;

public class Main {
    public static void main(String[] args) {
        int A[] = {5,2,4,6,1,3,2,6};
        Sort(A,0, A.length);
    }

    private static void Sort(int[] array, int low, int high) {
        if (low >= high-1)
            return;
        int middle = low + (high - low)/2;
        Sort(array, low, middle);
        Sort(array, middle, high);
        merge(array, low, middle, high);
    }

    private static void merge(int[] array, int low, int middle, int high) {
        int[] capacity = new int[high - low];
        int currentIndex = 0;
        for (int i = low, k = middle; i < middle || k < high; ) {
            if (i == middle) {
                while (k < high)
                    capacity[currentIndex++] = array[k++];
                break;
            }
            if (k == high) {
                while (i < middle)
                    capacity[currentIndex++] = array[i++];
                break;
            }
            if (array[i] < array[k])
                capacity[currentIndex++] = array[i++];
            else
                capacity[currentIndex++] = array[k++];
        }
        for (int i = low, c = 0; i < high && c < capacity.length; i++, c++)
            array[i] = capacity[c];
    }

}