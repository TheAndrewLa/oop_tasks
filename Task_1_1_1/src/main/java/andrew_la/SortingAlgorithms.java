package andrew_la;

public class SortingAlgorithms {

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

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

    private static void buildHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            heapify(array, i, array.length - 1);
        }
    }

    /**
     * Function takes an array and sort it using heapsort method
     *
     * @param array an input array of integers
     */
    public static void intSort(int[] array) {
        // In spite of fact that algorithm will work without this 'if', let it be here
        // Something like optimization, I think
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
