package andrewla;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class which implement {@code Graph} interface and presents graph as adjacency list.
 */
public class GraphAL implements Graph {

    /**
     * Creates an adjacency list graph.
     */
    public GraphAL() {
        adjacencyList = new ArrayList<>();
    }

    @Override
    public int addVertex() {
        adjacencyList.add(new LinkedList<>());
        return adjacencyList.size() - 1;
    }

    @Override
    public void removeVertex(int vertex) {
        if (vertex >= adjacencyList.size()) {
            throw new IllegalArgumentException("Bad vertex index was provided!");
        }

        adjacencyList.remove(vertex);
    }

    @Override
    public void addEdge(int u, int v) {
        if (u >= adjacencyList.size() || v >= adjacencyList.size()) {
            throw new IllegalArgumentException("Bad vertex indices were provided!");
        }

        adjacencyList.get(u).add(v);
    }

    @Override
    public void removeEdge(int u, int v) {
        if (u >= adjacencyList.size() || v >= adjacencyList.size()) {
            throw new IllegalArgumentException("Bad vertex indices were provided!");
        }

        LinkedList<Integer> adj = adjacencyList.get(u);

        if (adj.contains(v)) {
            adj.removeFirstOccurrence(v);
        }
        else {
            throw new IllegalArgumentException("Edge with this path doesn't exist!");
        }
    }

    @Override
    public int getVertexCount() {
        return adjacencyList.size();
    }

    @Override
    public int getEdgesCount() {
        int count = 0;

        for (LinkedList<Integer> i : adjacencyList) {
            count += i.size();
        }

        return count;
    }

    @Override
    public int[] getAdjacent(int vertex) {
        LinkedList<Integer> adj = adjacencyList.get(vertex);

        int[] adj_array = new int[adj.size()];
        int j = 0;

        for (int i : adj) {
            adj_array[j] = i;
            j++;
        }

        return adj_array;
    }

    private final ArrayList<LinkedList<Integer>> adjacencyList;
}
