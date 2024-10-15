package andrewla;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Graph interface, defines basic graph functions.
 */
public interface Graph {

    /**
     * Adds vertex to graph.
     *
     * @return an index of added vertex
     */
    int addVertex();

    /**
     * Removes vertex from graph.
     *
     * @param vertex an index of vertex to be removed
     */
    void removeVertex(int vertex);

    /**
     * Adds edge to graph between 2 vertices.
     *
     * @param u the first vertex
     * @param v the second vertex
     */
    void addEdge(int u, int v);

    /**
     * Removes edge from graph.
     *
     * @param u a start of an edge
     * @param v an end of an edge
     */
    void removeEdge(int u, int v);

    /**
     * Returns number of vertices.
     *
     * @return - int value, number of vertices
     */
    int getVertexCount();

    /**
     * Returns number of edges.
     *
     * @return - int value, number of edges
     */
    int getEdgesCount();

    /**
     * Get array of vertices which is adjacent to given
     *
     * @param vertex a vertex to find adjacent of it
     * @return an array of adjacent vertices
     */
    int[] getAdjacent(int vertex);

    /**
     * TODO: string format
     *
     * @param data a data of graph
     * @param graph a graph to fill data in, has to be empty
     */
    public static void initializeFromString(String data, Graph graph) {
        Scanner scanner = new Scanner(data);

        int vertexCount = scanner.nextInt();
        int edgesCount = scanner.nextInt();

        for (int i = 0; i < vertexCount; i++) {
            graph.addVertex();
        }

        for (int i = 0; i < edgesCount; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            graph.addEdge(u, v);
        }
    }
}
