package andrewla;

import java.util.Arrays;

/**
 * Class with sorting algorithms. There is only heapsort now.
 */
public class SortingAlgorithms {

    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 2, 1, 4, 4};

        intSort(array);

        System.out.println(Arrays.toString(array));
    }

    /**
     * Function which swaps two elements in the array.
     *
     * @param array an array where swapping should occur
     * @param i     an index to first element
     * @param j     an index to second element
     */
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * Function which heapify elements in the array.
     *
     * @param array an array of elements
     * @param index a start index to do heapify
     * @param limit a bound to heapify
     */
    private static void heapify(int[] array, int index, int limit) {
        int left = index * 2 + 1;
        int right = left + 1;

        int largest = index;

        if (left <= limit && array[index] > array[left]) {
            largest = left;
        }

        if (right <= limit && array[largest] > array[right]) {
            largest = right;
        }

        if (largest != index) {
            swap(array, index, largest);
            heapify(array, largest, limit);
        }
    }

    /**
     * Function which build heap from array in-place.
     *
     * @param array an array to make heap
     */
    private static void buildHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            heapify(array, i, array.length - 1);
        }
    }

    /**
     * Function which takes an array and sort it using heapsort method.
     *
     * @param array an input array of integers
     */
    public static void intSort(int[] array) {
        // In spite of fact that algorithm will work without this 'if', let it be here
        // I think it's something like optimization
        if (array.length <= 1) {
            return;
        }

        buildHeap(array);
        int heapSize = array.length - 1;

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, heapSize);
            heapSize--;
            heapify(array, 0, heapSize);
        }
    }
}
