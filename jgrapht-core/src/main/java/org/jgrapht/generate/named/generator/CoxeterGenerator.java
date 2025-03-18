package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class CoxeterGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 23 }, { 0, 24 }, { 1, 2 }, { 1, 12 }, { 2, 3 }, { 2, 25 },
                { 3, 4 }, { 3, 21 }, { 4, 5 }, { 4, 17 }, { 5, 6 }, { 5, 11 }, { 6, 7 }, { 6, 27 },
                { 7, 8 }, { 7, 24 }, { 8, 9 }, { 8, 25 }, { 9, 10 }, { 9, 20 }, { 10, 11 }, { 10, 26 },
                { 11, 12 }, { 12, 13 }, { 13, 14 }, { 13, 19 }, { 14, 15 }, { 14, 27 }, { 15, 16 },
                { 15, 25 }, { 16, 17 }, { 16, 26 }, { 17, 18 }, { 18, 19 }, { 18, 24 }, { 19, 20 },
                { 20, 21 }, { 21, 22 }, { 22, 23 }, { 22, 27 }, { 23, 26 } };
        addEdges(targetGraph, edges);
    }
}
