package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class BrinkmannGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 2 }, { 0, 5 }, { 0, 7 }, { 0, 13 }, { 1, 3 }, { 1, 6 }, { 1, 7 },
                { 1, 8 }, { 2, 4 }, { 2, 8 }, { 2, 9 }, { 3, 5 }, { 3, 9 }, { 3, 10 }, { 4, 6 },
                { 4, 10 }, { 4, 11 }, { 5, 11 }, { 5, 12 }, { 6, 12 }, { 6, 13 }, { 7, 15 }, { 7, 20 },
                { 8, 14 }, { 8, 16 }, { 9, 15 }, { 9, 17 }, { 10, 16 }, { 10, 18 }, { 11, 17 },
                { 11, 19 }, { 12, 18 }, { 12, 20 }, { 13, 14 }, { 13, 19 }, { 14, 17 }, { 14, 18 },
                { 15, 18 }, { 15, 19 }, { 16, 19 }, { 16, 20 }, { 17, 20 } };
        addEdges(targetGraph, edges);
    }
}
