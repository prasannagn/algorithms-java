package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ShortestPath {
    private Graph graph;

    public ShortestPath(Graph graph) {
        this.graph = graph;
    }

    public int[] shortestPath(int start) {
        LinkedList<Integer> visitedNodes = new LinkedList<>();
        int[] dist = IntStream.range(0, graph.getVertexesCount()).map(x -> Integer.MAX_VALUE).toArray();
        dist[start] = 0;

        do {
            int minNode = getMinDistNode(dist, visitedNodes);
            visitedNodes.add(minNode);
            computeDist(minNode, dist);
        } while (visitedNodes.size() <= graph.getVertexesCount());
        return dist;
    }

    private void computeDist(int node, int[] dist) {
        graph.getEdges().stream().filter(e -> e.getFrom() == node).forEach(edge -> {
            if (dist[edge.getTo()] > dist[node] + edge.getWeight()) {
                dist[edge.getTo()] = dist[node] + edge.getWeight();
            }
        });
    }

    private int getMinDistNode(int[] dist, List<Integer> visitedNodes) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<dist.length;i++){
            if(min > dist[i] && !visitedNodes.contains(i)){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


}

