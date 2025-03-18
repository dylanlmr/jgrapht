package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class HoffmanGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 7 }, { 0, 8 }, { 0, 13 }, { 1, 2 }, { 1, 9 }, { 1, 14 },
                { 2, 3 }, { 2, 8 }, { 2, 10 }, { 3, 4 }, { 3, 9 }, { 3, 15 }, { 4, 5 }, { 4, 10 },
                { 4, 11 }, { 5, 6 }, { 5, 12 }, { 5, 14 }, { 6, 7 }, { 6, 11 }, { 6, 13 }, { 7, 12 },
                { 7, 15 }, { 8, 12 }, { 8, 14 }, { 9, 11 }, { 9, 13 }, { 10, 12 }, { 10, 15 },
                { 11, 14 }, { 13, 15 } };
        addEdges(targetGraph, edges);
    }
}
