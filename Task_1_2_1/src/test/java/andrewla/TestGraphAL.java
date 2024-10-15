package andrewla;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A class which performs testing of adjacency list graph: {@code GraphAL}.
 */
public class TestGraphAL {

    @Test
    void addVertex() {
        GraphAL graphAL = new GraphAL();

        for (int i = 0; i < 100; i++) {
            graphAL.addVertex();
        }

        assertEquals(100, graphAL.getVertexCount());
    }

    @Test
    void removeVertex() {
        GraphAL graphAL = new GraphAL();

        for (int i = 0; i < 100; i++) {
            graphAL.addVertex();
        }

        for (int i = 10; i < 20; i++) {
            graphAL.removeVertex(i);
        }

        assertEquals(90, graphAL.getVertexCount());
    }

    @Test
    void addEdge() {
        GraphAL graphAL = new GraphAL();

        for (int i = 0; i < 10; i++) {
            graphAL.addVertex();
        }

        for (int i = 0; i < 8; i++) {
            graphAL.addEdge(i, 4);
            graphAL.addEdge(4, i);
        }

        assertEquals(16, graphAL.getEdgesCount());
    }

    @Test
    void removeEdge() {
        GraphAL graphAL = new GraphAL();

        for (int i = 0; i < 100; i++) {
            graphAL.addVertex();
        }

        for (int i = 1; i < 20; i++) {
            graphAL.addEdge(0, i);
        }

        for (int i = 1; i < 10; i++) {
            graphAL.removeEdge(0, i);
        }

        assertEquals(10, graphAL.getEdgesCount());
    }
}
