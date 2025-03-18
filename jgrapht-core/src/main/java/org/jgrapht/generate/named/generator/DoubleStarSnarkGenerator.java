package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class DoubleStarSnarkGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 14 }, { 0, 15 }, { 1, 2 }, { 1, 11 }, { 2, 3 }, { 2, 7 },
                { 3, 4 }, { 3, 18 }, { 4, 5 }, { 4, 14 }, { 5, 6 }, { 5, 10 }, { 6, 7 }, { 6, 21 },
                { 7, 8 }, { 8, 9 }, { 8, 13 }, { 9, 10 }, { 9, 24 }, { 10, 11 }, { 11, 12 }, { 12, 13 },
                { 12, 27 }, { 13, 14 }, { 15, 16 }, { 15, 29 }, { 16, 20 }, { 16, 23 }, { 17, 18 },
                { 17, 25 }, { 17, 28 }, { 18, 19 }, { 19, 23 }, { 19, 26 }, { 20, 21 }, { 20, 28 },
                { 21, 22 }, { 22, 26 }, { 22, 29 }, { 23, 24 }, { 24, 25 }, { 25, 29 }, { 26, 27 },
                { 27, 28 } };
        addEdges(targetGraph, edges);
    }
}
