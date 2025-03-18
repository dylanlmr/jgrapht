package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class PappusGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 5 }, { 0, 6 }, { 1, 2 }, { 1, 7 }, { 2, 3 }, { 2, 8 },
                { 3, 4 }, { 3, 9 }, { 4, 5 }, { 4, 10 }, { 5, 11 }, { 6, 13 }, { 6, 17 }, { 7, 12 },
                { 7, 14 }, { 8, 13 }, { 8, 15 }, { 9, 14 }, { 9, 16 }, { 10, 15 }, { 10, 17 },
                { 11, 12 }, { 11, 16 }, { 12, 15 }, { 13, 16 }, { 14, 17 } };
        addEdges(targetGraph, edges);
    }
}
