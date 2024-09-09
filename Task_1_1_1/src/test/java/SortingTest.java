import andrewla.SortingAlgorithms;
import java.util.Random;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SortingTest {

    private static boolean isArraySorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                return false;
            }
        }

        return true;
    }

    // General test (random array)

    @Test
    void checkRandomArray() {
        Random rand = new Random();

        for (int length = 1; length < 100; length += 10) {
            int[] array = new int[length];

            for (int i = 0; i < length; i++) {
                array[i] = rand.nextInt();
            }

            SortingAlgorithms.intSort(array);
            assertTrue(isArraySorted(array));
        }
    }

    // Some corner-cases
    // (sorted, reverse-sorted and array with only one number (e.g. {1, 1, 1...}) )

    @Test
    void checkSortedArray() {
        Random rand = new Random();

        for (int length = 1; length < 100; length += 10) {
            int[] array = new int[length];
            int base = rand.nextInt(100);

            for (int i = 0; i < length; i++) {
                array[i] = base * (i + 1);
            }

            SortingAlgorithms.intSort(array);
            assertTrue(isArraySorted(array));
        }
    }

    @Test
    void checkReverseSortedArray() {
        Random rand = new Random();

        for (int length = 1; length < 100; length += 10) {
            int[] array = new int[length];
            int base = rand.nextInt(100);

            for (int i = 0; i < length; i++) {
                array[i] = base * (length - i);
            }

            SortingAlgorithms.intSort(array);
            assertTrue(isArraySorted(array));
        }
    }

    @Test
    void checkOneNumberArray() {
        Random rand = new Random();

        for (int length = 1; length < 100; length += 10) {
            int[] array = new int[length];
            int value = rand.nextInt();

            for (int i = 0; i < length; i++) {
                array[i] = value;
            }

            SortingAlgorithms.intSort(array);
            assertTrue(isArraySorted(array));
        }
    }
}
