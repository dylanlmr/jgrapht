package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class HeawoodGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 5 }, { 0, 13 }, { 1, 2 }, { 1, 10 }, { 2, 3 }, { 2, 7 },
                { 3, 4 }, { 3, 12 }, { 4, 5 }, { 4, 9 }, { 5, 6 }, { 6, 7 }, { 6, 11 }, { 7, 8 },
                { 8, 9 }, { 8, 13 }, { 9, 10 }, { 10, 11 }, { 11, 12 }, { 12, 13 } };
        addEdges(targetGraph, edges);
    }
}
