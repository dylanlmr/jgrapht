package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class ErreraGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 7 }, { 0, 14 }, { 0, 15 }, { 0, 16 }, { 1, 2 }, { 1, 9 },
                { 1, 14 }, { 1, 15 }, { 2, 3 }, { 2, 8 }, { 2, 9 }, { 2, 10 }, { 2, 14 }, { 3, 4 },
                { 3, 9 }, { 3, 10 }, { 3, 11 }, { 4, 5 }, { 4, 10 }, { 4, 11 }, { 4, 12 }, { 5, 6 },
                { 5, 11 }, { 5, 12 }, { 5, 13 }, { 6, 7 }, { 6, 8 }, { 6, 12 }, { 6, 13 }, { 6, 16 },
                { 7, 13 }, { 7, 15 }, { 7, 16 }, { 8, 10 }, { 8, 12 }, { 8, 14 }, { 8, 16 }, { 9, 11 },
                { 9, 13 }, { 9, 15 }, { 10, 12 }, { 11, 13 }, { 13, 15 }, { 14, 16 } };
        addEdges(targetGraph, edges);
    }
}
