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

    private final LinkedList<Pair<K, V>> kv_pairs;

    /**
     * A constructor of bucket, takes no arguments.
     */
    Bucket() {
        kv_pairs = new LinkedList<>();
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

        return kv_pairs.equals(bucket.kv_pairs);
    }

    @Override
    public int hashCode() {
        return kv_pairs.hashCode();
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

        kv_pairs.add(new Pair<>(key, value));
    }

    /**
     * Removes KV pair from bucket by key.
     * Throws illegal argument exception if there's no pair with given key.
     *
     * @param key a key to remove
     */
    public void removeEntry(K key) {
        for (Pair<K, V> i : kv_pairs) {
            if (i.first() == key) {
                kv_pairs.remove(i);
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
        for (Pair<K, V> i : kv_pairs) {
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
     * @param new_value a value found KV pair will be updated with
     */
    public void updateEntry(K key, V new_value) {
        for (Pair<K, V> i : kv_pairs) {
            if (i.first() == key) {
                i.update(key, new_value);
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
        for (Pair<K, V> i : kv_pairs) {
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
        return kv_pairs.isEmpty();
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return kv_pairs.iterator();
    }
}
