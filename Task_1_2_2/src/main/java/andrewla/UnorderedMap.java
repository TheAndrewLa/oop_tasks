package andrewla;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * A class which implements hashmap data structure with chain method.
 *
 * @param <K> a key type
 * @param <V> a value type
 */
public class UnorderedMap<K, V> implements Iterable<Pair<K, V>> {

    /**
     * A class which implements (K; V) iterator for UnorderedMap.
     */
    private class PairIterator implements Iterator<Pair<K, V>> {

        private Iterator<Pair<K, V>> bucketIterator;
        private int bucketIndex;

        /**
         * Creates an iterator class.
         * Clears modification flag.
         */
        private PairIterator() {
            wasModified = false;

            bucketIndex = 0;
            bucketIterator = bucketsArray[bucketIndex].iterator();

            updateIterators();
        }

        @Override
        public boolean hasNext() {
            return bucketIterator != null;
        }

        @Override
        public Pair<K, V> next() {
            if (wasModified) {
                throw new ConcurrentModificationException(
                    "Collection was modified during iteration!");
            }

            Pair<K, V> ret = bucketIterator.next();
            updateIterators();

            return ret;
        }

        /**
         * Internal method which updates bucket iterator
         */
        private void updateIterators() {
            if (bucketIterator != null && bucketIterator.hasNext()) {
                return;
            }

            do {
                bucketIndex++;
            } while (bucketIndex < bucketsArray.length && bucketsArray[bucketIndex].isEmpty());

            if (bucketIndex < bucketsArray.length) {
                bucketIterator = bucketsArray[bucketIndex].iterator();
            }
            else {
                bucketIterator = null;
            }
        }
    }

    private static final int INITIAL_HASHMAP_CAPACITY = 32;

    private int cap = INITIAL_HASHMAP_CAPACITY;
    private int totalAdded = 0;

    private Bucket<K, V>[] bucketsArray;

    // This variable is needed to check when PairIterator::next should throw Exception
    private boolean wasModified;

    /**
     * Default constructor of hashmap, no arguments.
     */
    public UnorderedMap() {
        bucketsArray = new Bucket[cap];
        initializeBuckets(bucketsArray);
    }

    /**
     * Insert method. Throws illegal argument exception on failure.
     *
     * @param key   a key of new element
     * @param value a value of new element
     */
    public void insert(K key, V value) {
        bucketsArray[getBucketIndex(key)].addEntry(key, value);
        totalAdded += 1;

        wasModified = true;

        float loadFactor = (float) totalAdded / (float) cap;
        if (loadFactor >= 0.6f) {
            rehash();
        }
    }

    /**
     * Return value by key or throw an illegal argument exception.
     *
     * @param key a key
     * @return a value pointed by key
     */
    public V find(K key) {
        return bucketsArray[getBucketIndex(key)].findEntry(key);
    }

    /**
     * Removes element by key or throw an unchecked exception.
     *
     * @param key a key
     */
    public void remove(K key) {
        bucketsArray[getBucketIndex(key)].removeEntry(key);
        wasModified = true;
    }

    /**
     * Assign new value to value pointed by key.
     *
     * @param key   a key
     * @param value a new value
     */
    public void update(K key, V value) {
        bucketsArray[getBucketIndex(key)].updateEntry(key, value);
        wasModified = true;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new PairIterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        UnorderedMap<?, ?> hashMap = (UnorderedMap<?, ?>) (obj);

        // Arrays.equals has to compare all elements of the arrays
        // So, bucket should have equals() method

        return Arrays.equals(bucketsArray, hashMap.bucketsArray);
    }

    /**
     * Function which performs rehashing of map.
     */
    private void rehash() {
        cap <<= 1;

        Bucket<K, V>[] newBuckets = new Bucket[cap];
        initializeBuckets(newBuckets);

        for (Pair<K, V> i : this) {
            newBuckets[getBucketIndex(i.first())].addEntry(i.first(), i.second());
        }

        bucketsArray = newBuckets;
    }

    /**
     * Function which calculates an index of key in array of buckets.
     *
     * @param key a key
     * @return an index in @{code bucketsArray}
     */
    private int getBucketIndex(K key) {

        // A short explanation why -1 is here
        // 16 = 0b10000
        // a % 16 = a & 0b1111 = a & (16 - 1)

        return key.hashCode() & (cap - 1);
    }

    private void initializeBuckets(Bucket<K, V>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket<>();
        }
    }
}
