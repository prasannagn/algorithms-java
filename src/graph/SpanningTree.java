package graph;

import java.util.Comparator;

public class SpanningTree {

    private Graph graph;

    public SpanningTree(Graph graph) {
        this.graph = graph;
    }

    private class Subset {
        private int parent, rank;

        private Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }


    }

    public Graph spanningTree() {
        Graph spanningTree = new Graph(graph.getVertexesCount(), false);
        graph.getEdges().sort(Comparator.comparing(Edge::getWeight));
        Subset[] subsets = new Subset[graph.getVertexesCount()];
        for (int i = 0; i < graph.getVertexesCount(); i++) {
            subsets[i] = new Subset(i, 0);
        }
        int i = 0;
        int e = 0;
        while (i < (graph.getVertexesCount() - 1)) {
            Edge edge = graph.getEdges().get(e++);
            int x = findParent(subsets, edge.getFrom());
            int y = findParent(subsets, edge.getTo());
            if (x != y) {
                spanningTree.addEdge(edge.getFrom(), edge.getTo(), edge.getWeight());
                if (subsets[x].rank < subsets[y].rank) {
                    subsets[x].parent = y;
                } else if (subsets[x].rank > subsets[y].rank) {
                    subsets[y].parent = x;
                } else {
                    subsets[y].parent = x;
                    subsets[x].rank = x++;
                }
                i++;
            }
        }
        return spanningTree;
    }

    private int findParent(Subset subsets[], int i) {
        // findParent root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = findParent(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

}
