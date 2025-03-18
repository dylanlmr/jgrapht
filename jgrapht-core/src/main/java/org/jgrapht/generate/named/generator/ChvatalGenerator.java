package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class ChvatalGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 4 }, { 0, 6 }, { 0, 9 }, { 1, 2 }, { 1, 5 }, { 1, 7 },
                { 2, 3 }, { 2, 6 }, { 2, 8 }, { 3, 4 }, { 3, 7 }, { 3, 9 }, { 4, 5 }, { 4, 8 },
                { 5, 10 }, { 5, 11 }, { 6, 10 }, { 6, 11 }, { 7, 8 }, { 7, 11 }, { 8, 10 }, { 9, 10 },
                { 9, 11 } };
        addEdges(targetGraph, edges);
    }
}
