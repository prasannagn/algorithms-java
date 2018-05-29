package graph;

import java.util.LinkedList;
import java.util.List;

public class Cyclic {
    private Graph graph;

    public Cyclic(Graph graph) {
        this.graph = graph;
    }

    public boolean isCyclic() {
        if (graph.isDirected()) {
            return isCyclic(0, new LinkedList<>(), new LinkedList<>());
        } else {
            return isCyclic(0, new LinkedList<>(), -1);
        }
    }

    private boolean isCyclic(int node, List<Integer> visited, int parent) {
        visited.add(node);
        for (Edge edge : graph.getEdges()) {
            if (edge.getFrom() == node) {
                if (visited.contains(edge.getTo()) && parent != edge.getTo()) {
                    return true;
                } else if (!visited.contains(edge.getTo()) && isCyclic(edge.getTo(), visited, node)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclic(int node, List<Integer> visited, LinkedList<Integer> stack) {
        visited.add(node);
        stack.addFirst(node);
        for (Edge edge : graph.getEdges()) {
            if (edge.getFrom() == node) {
                if (visited.contains(edge.getTo()) && stack.contains(edge.getTo())) {
                    return true;
                } else if (!visited.contains(edge.getTo()) && isCyclic(edge.getTo(), visited, stack)) {
                    return true;
                }
            }
        }
        stack.removeFirst();
        return false;
    }
}
