package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class PoussinGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[] vertices = { 0, 1, 2, 3, 4, 5, 6 };
        addCycle(targetGraph, vertices);
        int[] vertices1 = { 9, 10, 11, 12, 13, 14 };
        addCycle(targetGraph, vertices1);
        int[][] edges = { { 0, 2 }, { 0, 4 }, { 0, 5 }, { 1, 6 }, { 1, 7 }, { 2, 4 }, { 2, 7 },
                { 2, 8 }, { 3, 5 }, { 3, 8 }, { 3, 9 }, { 3, 13 }, { 5, 9 }, { 5, 10 }, { 6, 7 },
                { 6, 10 }, { 6, 11 }, { 7, 8 }, { 7, 11 }, { 7, 12 }, { 8, 12 }, { 8, 13 }, { 9, 13 },
                { 10, 14 }, { 11, 14 }, { 12, 14 } };
        addEdges(targetGraph, edges);
    }
}
