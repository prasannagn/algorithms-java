package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ShortestPathTest {
    public static void main(String[] args) {
        Graph graph = new Graph(6, false);
        graph.addEdge(0, 1,10);
        graph.addEdge(0, 2,20);
        graph.addEdge(1, 2,5);
        graph.addEdge(1, 3,15);
        graph.addEdge(2, 4,3);
        graph.addEdge(3, 5,3);
        graph.addEdge(4, 5,1);

        ShortestPath bfs = new ShortestPath(graph);
        System.out.println(Arrays.toString(bfs.shortestPath(0)));

        Graph g = new Graph(4, false);

        g.addEdge(0, 1,30);
        g.addEdge(0, 2,10);
        g.addEdge(1, 2,15);
        g.addEdge(2, 3,5);

        bfs = new ShortestPath(g);
        System.out.println(Arrays.toString(bfs.shortestPath(0)));
    }


}

