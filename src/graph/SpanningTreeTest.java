package graph;

public class SpanningTreeTest {

    public static void main(String[] args) {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, false);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(3, 1, 15);
        graph.addEdge(2, 3, 4);
        graph.addEdge(0, 3, 5);

        SpanningTree spanningTree = new SpanningTree(graph);
        Graph graph1 = spanningTree.spanningTree();
        graph1.getEdges().forEach(System.out::print);

        System.out.println();

        graph = new Graph(6, false);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 20);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 5, 25);
        graph.addEdge(3, 2, 5);
        graph.addEdge(4, 5, 15);
        graph.addEdge(2, 1, 5);
        graph.addEdge(3, 1, 4);
        graph.addEdge(3, 4, 4);

        spanningTree = new SpanningTree(graph);
        graph1 = spanningTree.spanningTree();
        graph1.getEdges().forEach(System.out::print);
    }

}
