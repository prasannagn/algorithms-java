package graph;

import java.util.LinkedList;
import java.util.List;

public class DFS {

    private Graph graph;

    public DFS(Graph graph) {
        this.graph = graph;
    }

    public List<Integer> traverse(int start) {
        List<Integer> visited = new LinkedList<>();
        visited.add(start);
        traverse(start, visited);
        return visited;
    }

    private void traverse(int start, List<Integer> visited) {
        graph.getEdges().stream().filter(e -> e.getFrom() == start && !visited.contains(e.getTo())).forEach(edge -> {
            visited.add(edge.getTo());
            traverse(edge.getTo(), visited);
        });
    }
}
