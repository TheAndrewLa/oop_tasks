package andrewla;

class BucketCapacityArray {

    BucketCapacityArray() {
        // Array has some prime numbers calculated at the stage of hashmap constructor
        // So we don't need to find next prime number in runtime during rehash (for some time)

        array = new int[CAPACITY];

        int mul = 1;
        for (int i = 0; i < CAPACITY; i++) {
            array[i] = nextPrime(BASE_SIZE * mul);
            mul *= 2;
        }
    }

    public int getNext() {
        if (counter < CAPACITY) {
            return array[counter++];
        } else {
            int prime = nextPrime(runtimeBaseValue);
            runtimeBaseValue *= 2;

            return prime;
        }
    }

    private int nextPrime(int current) {
        int i = current;
        while (!isPrime(i)) {
            i += 1;
        }

        return i;
    }

    private boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }

        for (int i = 2; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static final int CAPACITY = 7;
    private static final int BASE_SIZE = 100;

    private int runtimeBaseValue = 100 * 128;

    private final int[] array;
    private int counter = 0;
}
