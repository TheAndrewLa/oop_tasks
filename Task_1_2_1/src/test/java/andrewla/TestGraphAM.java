package andrewla;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A class which performs testing of adjacency matrix graph: {@code GraphAM} class.
 */
public class TestGraphAM {
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
}
