package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private Graph graph;

    public BFS(Graph graph) {
        this.graph = graph;
    }

    public List<Integer> traverse(int start){
        List<Integer> visited = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while(null != queue.peek()){
            int from = queue.poll();
            graph.getEdges().stream().filter(e-> e.getFrom()==from && !visited.contains(e.getTo())).forEach(edge -> {
                visited.add(edge.getTo());
                queue.add(edge.getTo());
            });
        }
        return visited;
    }
}
