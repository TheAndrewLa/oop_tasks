package andrewla;

import java.util.LinkedList;

class Bucket<K, V> {

    Bucket() {
        keys = new LinkedList<>();
        values = new LinkedList<>();
    }

    public void addEntry(K key, V value) {
        if (keys.contains(key)) {
            throw new IllegalArgumentException("Illegal key!");
        }

        keys.add(key);
        values.add(value);
    }

    public void removeEntry(K key) {
        if (!keys.contains(key)) {
            throw new IllegalArgumentException("Illegal key!");
        }

        int index = keys.indexOf(key);
        keys.remove(index);
        values.remove(index);
    }

    public V findEntry(K key) {
        if (!keys.contains(key)) {
            throw new IllegalArgumentException("Illegal key!");
        }

        return values.get(keys.indexOf(key));
    }

    public void updateEntry(K key, V value) {
        if (!keys.contains(key)) {
            throw new IllegalArgumentException("Illegal key!");
        }

        values.set(keys.indexOf(key), value);
    }

    public boolean containsEntry(K key) {
        return keys.contains(key);
    }

    // Java doesn't have Pair class, so I need to use 2 lists

    private final LinkedList<K> keys;
    private final LinkedList<V> values;
}
