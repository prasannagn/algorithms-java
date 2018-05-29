package graph;

public class BFSTest {
    public static void main(String[] args) {

        Graph graph = new Graph(6, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        BFS bfs = new BFS(graph);
        System.out.println(bfs.traverse(0));

        Graph g = new Graph(6, false);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

         bfs = new BFS(g);
        System.out.println(bfs.traverse(0));
    }
}
