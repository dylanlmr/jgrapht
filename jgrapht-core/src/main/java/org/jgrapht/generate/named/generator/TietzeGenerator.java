package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class TietzeGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[] vertices = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        addCycle(targetGraph, vertices);
        int[][] edges = { { 0, 9 }, { 1, 5 }, { 2, 7 }, { 3, 10 }, { 4, 8 }, { 6, 11 }, { 9, 10 },
                { 9, 11 }, { 10, 11 } };
        addEdges(targetGraph, edges);
    }
}
