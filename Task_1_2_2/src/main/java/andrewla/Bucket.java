package andrewla;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A bucket class which implements chain in hashmap.
 *
 * @param <K> a key of chain entry
 * @param <V> a value of chain entry
 */
class Bucket<K, V> implements Iterable<Pair<K, V>> {

    private final LinkedList<Pair<K, V>> kvPairs;

    /**
     * A constructor of bucket, takes no arguments.
     */
    Bucket() {
        kvPairs = new LinkedList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Bucket<?, ?> bucket = (Bucket<?, ?>) obj;

        return kvPairs.equals(bucket.kvPairs);
    }

    @Override
    public int hashCode() {
        return kvPairs.hashCode();
    }

    /**
     * Add new KV pair to bucket.
     * Throws illegal argument exception if KV pair with given key was already added.
     *
     * @param key a key
     * @param value a value
     */
    public void addEntry(K key, V value) {
        if (containsEntry(key)) {
            throw new IllegalArgumentException("Key already added");
        }

        kvPairs.add(new Pair<>(key, value));
    }

    /**
     * Removes KV pair from bucket by key.
     * Throws illegal argument exception if there's no pair with given key.
     *
     * @param key a key to remove
     */
    public void removeEntry(K key) {
        for (Pair<K, V> i : kvPairs) {
            if (i.first() == key) {
                kvPairs.remove(i);
                return;
            }
        }

        throw new IllegalArgumentException("Key doesn't exist!");
    }

    /**
     * Finds a value from KV pair with given key.
     * Throws illegal argument exception if there's no pair with given key.
     *
     * @param key a key of KV pair to find
     * @return a value of found KV pair
     */
    public V findEntry(K key) {
        for (Pair<K, V> i : kvPairs) {
            if (i.first() == key) {
                return i.second();
            }
        }

        throw new IllegalArgumentException("Key doesn't exists!");
    }

    /**
     * Updates KV pair with given key by given new value.
     * Throws illegal argument exception if there's no pair with given key.
     *
     * @param key a key of KV pair to update
     * @param newValue a value found KV pair will be updated with
     */
    public void updateEntry(K key, V newValue) {
        for (Pair<K, V> i : kvPairs) {
            if (i.first() == key) {
                i.update(key, newValue);
                return;
            }
        }

        throw new IllegalArgumentException("Key doesn't exists!");
    }

    /**
     * Returns true if bucket contains element with given key.
     *
     * @param key a key to find
     * @return an indicating value
     */
    public boolean containsEntry(K key) {
        for (Pair<K, V> i : kvPairs) {
            if (i.first() == key) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns true if bucket is empty.
     *
     * @return a state of bucket
     */
    public boolean isEmpty() {
        return kvPairs.isEmpty();
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return kvPairs.iterator();
    }
}
