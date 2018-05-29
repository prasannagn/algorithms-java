package graph;

import java.util.LinkedList;

public class Graph {
    private int vertexesCount;
    private boolean isDirected;
    private LinkedList<Edge> edges;

    public Graph(int vertexesCount, boolean isDirected) {
        this.vertexesCount = vertexesCount;
        this.isDirected = isDirected;
        edges = new LinkedList<>();
    }

    public void addEdge(int from, int to, int weight) {
        edges.add(new Edge(from, to, weight));
        if (!isDirected) {
            edges.add(new Edge(to, from, weight));
        }
    }

    public void addEdge(int from, int to) {
        edges.add(new Edge(from, to, 1));
    }

    public int getVertexesCount() {
        return vertexesCount;
    }

    public void setVertexesCount(int vertexesCount) {
        this.vertexesCount = vertexesCount;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge> edges) {
        this.edges = edges;
    }
}
