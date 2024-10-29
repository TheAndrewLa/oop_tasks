package andrewla;

public class HashMap<K, V> {

    /**
     * Constructor of hashmap class, no arguments.
     */
    public HashMap() {
        capacityArray = new BucketCapacityArray();
        bucketsArray = new Bucket[capacityArray.getNext()];
    }

    /**
     * Insert method.
     * Throws unchecked exception on failure.
     *
     * @param key a key of new element
     * @param value a value of new element
     */
    public void insert(K key, V value) {
        bucketsArray[getBucketIndex(key)].addEntry(key, value);
        totalAdded += 1;

        float loadFactor = totalAdded / (float) bucketsArray.length;
        if (loadFactor >= 0.6f) {
            rehash();
        }
    }

    /**
     * Return value by key or throw an unchecked exception.
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
    }

    /**
     * Assign new value to value pointed by key.
     *
     * @param key a key
     * @param value a new value
     */
    public void update(K key, V value) {
        bucketsArray[getBucketIndex(key)].updateEntry(key, value);
    }

    /**
     * Function which performs rehashing of map.
     */
    private void rehash() {
        Bucket<K, V>[] newBuckets = new Bucket[capacityArray.getNext()];

        // TODO: finish it up
    }

    /**
     * Function which calculates an index of key in array of buckets.
     *
     * @param key a key
     * @return an index in @{code bucketsArray}
     */
    private int getBucketIndex(K key) {
        return key.hashCode() % bucketsArray.length;
    }

    private final BucketCapacityArray capacityArray;

    private Bucket<K, V>[] bucketsArray;
    private int totalAdded = 0;
}
