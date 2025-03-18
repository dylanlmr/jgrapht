package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class FranklinGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 5 }, { 0, 6 }, { 1, 2 }, { 1, 7 }, { 2, 3 }, { 2, 8 },
                { 3, 4 }, { 3, 9 }, { 4, 5 }, { 4, 10 }, { 5, 11 }, { 6, 7 }, { 6, 9 }, { 7, 10 },
                { 8, 9 }, { 8, 11 }, { 10, 11 } };
        addEdges(targetGraph, edges);
    }
}
