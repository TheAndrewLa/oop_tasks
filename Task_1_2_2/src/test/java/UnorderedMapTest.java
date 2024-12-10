import andrewla.UnorderedMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * This class used for testing UnorderedMap class
 */
public class UnorderedMapTest {

    @Test
    void findTest() {
        UnorderedMap<String, Integer> map = new UnorderedMap<>();

        map.insert("First", 123);
        map.insert("Second", 234);
        map.insert("Third", 678);
        map.insert("Third-N-Half", 100);
        map.insert("Fourth", 999);

        try {
            map.insert("Third", 1234);
        } catch (Exception e) {
            assertTrue(true);
        }

        assertEquals(123, map.find("First"));
        assertEquals(678, map.find("Third"));
        assertEquals(999, map.find("Fourth"));

        try {
            map.find("Not_exist_here");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void rehashTest() {
        UnorderedMap<Integer, Integer> map = new UnorderedMap<>();

        for (int i = 1; i < 100; i++) {
            map.insert(i, 3 * i);
        }

        for (int i = 1; i < 100; i++) {
            try {
                final int res = map.find(i);
                assertEquals(i * 3, res);
            } catch (Exception e) {
                fail();
            }
        }
    }

    @Test
    void equalTest() {
        UnorderedMap<String, Integer> map = new UnorderedMap<>();
        map.insert("One", 1);
        map.insert("Two", 2);
        map.insert("Three", 3);

        UnorderedMap<String, Integer> another_map = new UnorderedMap<>();
        another_map.insert("One", 1);
        another_map.insert("Two", 2);
        another_map.insert("Three", 3);

        assertEquals(map, another_map);
    }

    @Test
    void iteratorTest() {
        UnorderedMap<Integer, Integer> map = new UnorderedMap<>();

        for (int i = 0; i <= 100; i++) {
            map.insert(i, i);
        }

        int res = 0;

        for (var i : map) {
            assertEquals(i.first(), i.second());
            res += i.second();
        }

        assertEquals(5050, res);
    }

}
