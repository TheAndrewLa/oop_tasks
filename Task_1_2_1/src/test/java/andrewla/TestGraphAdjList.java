package andrewla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * A class which performs testing of adjacency list graph: {@code GraphAL}.
 */
public class TestGraphAdjList {

    @Test
    void addVertex() {
        GraphAL graph = new GraphAL();

        for (int i = 0; i < 100; i++) {
            graph.addVertex();
        }

        assertEquals(100, graph.getVertexCount());
    }

    @Test
    void removeVertex() {
        GraphAL graph = new GraphAL();

        for (int i = 0; i < 100; i++) {
            graph.addVertex();
        }

        for (int i = 10; i < 20; i++) {
            graph.removeVertex(i);
        }

        assertEquals(90, graph.getVertexCount());
    }

    @Test
    void addEdge() {
        GraphAL graph = new GraphAL();

        for (int i = 0; i < 10; i++) {
            graph.addVertex();
        }

        for (int i = 0; i < 8; i++) {
            graph.addEdge(i, 4);
            graph.addEdge(4, i);
        }

        assertEquals(16, graph.getEdgesCount());
    }

    @Test
    void removeEdge() {
        GraphAL graph = new GraphAL();

        for (int i = 0; i < 100; i++) {
            graph.addVertex();
        }

        for (int i = 1; i < 20; i++) {
            graph.addEdge(0, i);
        }

        for (int i = 1; i < 10; i++) {
            graph.removeEdge(0, i);
        }

        assertEquals(10, graph.getEdgesCount());
    }

    @Test
    void getAdjacent() {
        GraphAL graph = new GraphAL();

        for (int i = 0; i < 50; i++) {
            graph.addVertex();
        }

        assertEquals(0, graph.getAdjacent(7).length);

        for (int i = 10; i < 15; i++) {
            graph.addEdge(1, i);
        }

        int[] adj = graph.getAdjacent(1);
        int[] expected_adj = {10, 11, 12, 13, 14};
        assertArrayEquals(expected_adj, adj);
    }
}
