package graph;


import java.util.LinkedList;
import java.util.Queue;

public class Height {
    private Graph graph;

    public Height(Graph graph) {
        this.graph = graph;
    }

    public int height(int start) {
        LinkedList<Integer> visited = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int height = 0;
        while (queue.size() != 0) {
            int node = queue.poll();
            if (graph.getEdges().stream().anyMatch(e -> e.getFrom() == node && !visited.contains(e.getTo()))) {
                height++;
            }
            graph.getEdges().stream().filter(e -> e.getFrom() == node && !visited.contains(e.getTo())).forEach(edge -> {
                visited.add(edge.getTo());
                queue.add(edge.getTo());
            });
        }
        return height;
    }

}
