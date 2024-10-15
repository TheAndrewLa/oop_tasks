package andrewla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A class which performs testing of adjacency matrix graph: {@code GraphAM} class.
 */
public class TestGraphAdjMatrix {
    @Test
    void addVertex() {
        Graph graph = new GraphAM();

        for (int i = 0; i < 100; i++) {
            graph.addVertex();
        }

        assertEquals(100, graph.getVertexCount());
    }

    @Test
    void removeVertex() {
        Graph graph = new GraphAM();

        for (int i = 0; i < 100; i++) {
            graph.addVertex();
        }

        for (int i = 0; i < 20; i += 2) {
            graph.removeVertex(i);
        }

        assertEquals(90, graph.getVertexCount());
    }

    @Test
    void addEdge() {
        Graph graph = new GraphAM();

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
        Graph graph = new GraphAM();

        for (int i = 0; i < 30; i++) {
            graph.addVertex();
        }

        for (int i = 1; i < 10; i++) {
            graph.addEdge(0, i);
        }

        for (int i = 2; i < 10; i += 2) {
            graph.removeEdge(0, i);
        }

        assertEquals(5, graph.getEdgesCount());
    }

    @Test
    void getAdjacent() {
        GraphAL graphAL = new GraphAL();

        for (int i = 0; i < 50; i++) {
            graphAL.addVertex();
        }

        assertEquals(0, graphAL.getAdjacent(42).length);

        for (int i = 20; i < 30; i++) {
            graphAL.addEdge(10, i);
        }

        int[] adj = graphAL.getAdjacent(10);
        int[] expected_adj = {20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
        assertArrayEquals(expected_adj, adj);
    }
}
