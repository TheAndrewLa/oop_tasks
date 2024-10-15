package andrewla;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * Class which implement {@code Graph} interface and presents graph as adjacency matrix.
 */
public class GraphAM implements Graph {

    /**
     * Creates an adjacency matrix graph
     */
    public GraphAM() {
        matrixRows = new ArrayList<>();

        for (int i = 0; i < matrixCapacity; i++) {
            matrixRows.add(new BitSet(matrixCapacity));
        }
    }

    @Override
    public int addVertex() {
        if (totalVertices == matrixCapacity) {
            reallocateMatrix();
        }

        totalVertices++;

        return totalVertices - 1;
    }

    @Override
    public void removeVertex(int vertex) {
        for (int i = 0; i < totalVertices; i++) {
            matrixRows.get(i).clear(vertex);
        }

        matrixRows.remove(vertex);

        totalVertices--;
    }

    @Override
    public void addEdge(int u, int v) {
        matrixRows.get(u).set(v);
        totalEdges++;
    }

    @Override
    public void removeEdge(int u, int v) {
        matrixRows.get(u).set(v);
        totalEdges--;
    }

    @Override
    public int getVertexCount() {
        return totalVertices;
    }

    @Override
    public int getEdgesCount() {
        return totalEdges;
    }

    @Override
    public int[] getAdjacent(int vertex) {
        BitSet adj_bitset = matrixRows.get(vertex);
        int[] adj = new int[adj_bitset.cardinality()];

        int j = 0;

        for (int i = 0; i < totalVertices; i++) {

            if (adj_bitset.get(i)) {
                adj[j] = i;
                j++;
            }
        }

        return adj;
    }

    /**
     * Functions which performs matrix reallocation.
     */
    private void reallocateMatrix() {
        for (int i = 0; i < matrixCapacity; i++) {
            BitSet newBitset = new BitSet(matrixCapacity * 2);
            newBitset.or(matrixRows.get(i));

            matrixRows.set(i, newBitset);
        }

        for (int i = 0; i < matrixCapacity; i++) {
            matrixRows.add(new BitSet(matrixCapacity * 2));
        }

        matrixCapacity *= 2;
    }

    private int matrixCapacity = 16;

    private int totalVertices = 0;
    private int totalEdges = 0;

    private final ArrayList<BitSet> matrixRows;
}
