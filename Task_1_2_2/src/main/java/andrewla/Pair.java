package andrewla;

import java.util.Objects;

/**
 * Pair class.
 *
 * @param <T> the first parameter of pair
 * @param <U> the second parameter of pair
 */
public class Pair<T, U> {

    private T first;
    private U second;

    /**
     * Constructs pair by two element.
     *
     * @param first a first element of pair
     * @param second a second element of pair
     */
    public Pair(T first, U second) {
        update(first, second);
    }

    /**
     * Updates both element of pair.
     *
     * @param first a new first element
     * @param second a new second element
     */
    public void update(T first, U second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) obj;

        return first.equals(pair.first) && second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "(" + first.toString() + "; " + second.toString() + ")";
    }

    /**
     * Gets first element from pair.
     *
     * @return a first element
     */
    public T first() {
        return first;
    }

    /**
     * Gets second element from pair.
     *
     * @return a second element
     */
    public U second() {
        return second;
    }
}
