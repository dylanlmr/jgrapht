package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class HerschelGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 3 }, { 0, 4 }, { 1, 2 }, { 1, 5 }, { 1, 6 }, { 2, 3 },
                { 2, 7 }, { 3, 8 }, { 3, 9 }, { 4, 5 }, { 4, 9 }, { 5, 10 }, { 6, 7 }, { 6, 10 },
                { 7, 8 }, { 8, 10 }, { 9, 10 } };
        addEdges(targetGraph, edges);
    }
}
