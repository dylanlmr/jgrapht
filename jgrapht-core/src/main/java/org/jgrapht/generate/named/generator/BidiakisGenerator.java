package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class BidiakisGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 6 }, { 0, 11 }, { 1, 2 }, { 1, 5 }, { 2, 3 }, { 2, 10 },
                { 3, 4 }, { 3, 9 }, { 4, 5 }, { 4, 8 }, { 5, 6 }, { 6, 7 }, { 7, 8 }, { 7, 11 },
                { 8, 9 }, { 9, 10 }, { 10, 11 } };
        addEdges(targetGraph, edges);
    }
}
