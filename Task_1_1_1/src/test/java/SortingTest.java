import andrewla.SortingAlgorithms;
import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SortingTest {

    // Some constants for testing random arrays

    private static final int tinyArraySize = 5;
    private static final int smallArraySize = 50;
    private static final int mediumArraySize = 1000;
    private static final int bigArraySize = 15000;
    private static final int hugeArraySize = 50000;

    private static final int randomArrayIterations = 5;

    // Some constants for testing sorted & reverse sorted arrays

    private static final int sortedArrayBound = 50;

    private static boolean isArraySorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                return false;
            }
        }

        return true;
    }

    private static int[] createRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }

        return array;
    }

    private static int[] createRandomSortedArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];

        int prev = 0;

        for (int i = 0; i < size; i++) {
            int value = rand.nextInt(sortedArrayBound);

            array[i] = prev + value;
            prev = value + 1;
        }

        return array;
    }

    private static int[] createRandomRevSortedArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];

        int prev = 0;

        for (int i = 0; i < size; i++) {
            int value = rand.nextInt(sortedArrayBound);

            array[size - i - 1] = prev + value;
            prev = value + 1;
        }

        return array;
    }

    // General tests (random array with different sizes)

    @Test
    void checkTinyRandomArray() {
        for (int i = 0; i < randomArrayIterations; i++) {
            int[] array = createRandomArray(tinyArraySize);

            SortingAlgorithms.intSort(array);
            assertTrue(isArraySorted(array));
        }
    }

    @Test
    void checkSmallRandomArray() {
        int[] array = createRandomArray(smallArraySize);

        SortingAlgorithms.intSort(array);
        assertTrue(isArraySorted(array));
    }

    @Test
    void checkMediumRandomArray() {
        int[] array = createRandomArray(mediumArraySize);

        SortingAlgorithms.intSort(array);
        assertTrue(isArraySorted(array));
    }

    @Test
    void checkBigRandomArray() {
        int[] array = createRandomArray(bigArraySize);

        SortingAlgorithms.intSort(array);
        assertTrue(isArraySorted(array));
    }

    @Test
    void checkHugeRandomArray() {
        int[] array = createRandomArray(hugeArraySize);

        SortingAlgorithms.intSort(array);
        assertTrue(isArraySorted(array));
    }

    // Some corner-cases
    // Sorted, reverse-sorted and array with only one number (e.g. {1, 1, 1...}) )

    @Test
    void checkEmptyArray() {
        int[] array = new int[]{};

        SortingAlgorithms.intSort(array);
        assertTrue(isArraySorted(array));
    }

    @Test
    void checkOneElementArray() {
        int[] array = new int[]{42};

        SortingAlgorithms.intSort(array);
        assertTrue(isArraySorted(array));
    }

    @Test
    void checkSortedArray() {
        int[] array = createRandomSortedArray(mediumArraySize);

        SortingAlgorithms.intSort(array);
        assertTrue(isArraySorted(array));
    }

    @Test
    void checkReverseSortedArray() {
        int[] array = createRandomRevSortedArray(mediumArraySize);

        SortingAlgorithms.intSort(array);
        assertTrue(isArraySorted(array));
    }

    @Test
    void checkOneNumberArray() {
        Random rand = new Random();

        int[] array = new int[mediumArraySize];
        Arrays.fill(array, rand.nextInt());

        SortingAlgorithms.intSort(array);
        assertTrue(isArraySorted(array));
    }
}
