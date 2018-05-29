package graph;

public class CycleTest {
    public static void main(String[] args) {
        Graph graph = new Graph(3, true);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        Cyclic cyclic = new Cyclic(graph);
        System.out.println(cyclic.isCyclic());

        graph = new Graph(3, false);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        cyclic = new Cyclic(graph);
        System.out.println(cyclic.isCyclic());

        graph = new Graph(5, true);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        cyclic = new Cyclic(graph);
        System.out.println(cyclic.isCyclic());

        graph = new Graph(5, false);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,4);
        graph.addEdge(4,3);
        graph.addEdge(3,0);
        cyclic = new Cyclic(graph);
        System.out.println(cyclic.isCyclic());

    }
}
