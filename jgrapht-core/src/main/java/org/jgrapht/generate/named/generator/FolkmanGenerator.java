package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class FolkmanGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 3 }, { 0, 13 }, { 0, 15 }, { 1, 2 }, { 1, 6 }, { 1, 8 },
                { 2, 3 }, { 2, 17 }, { 2, 19 }, { 3, 6 }, { 3, 8 }, { 4, 5 }, { 4, 7 }, { 4, 17 },
                { 4, 19 }, { 5, 6 }, { 5, 10 }, { 5, 12 }, { 6, 7 }, { 7, 10 }, { 7, 12 }, { 8, 9 },
                { 8, 11 }, { 9, 10 }, { 9, 14 }, { 9, 16 }, { 10, 11 }, { 11, 14 }, { 11, 16 },
                { 12, 13 }, { 12, 15 }, { 13, 14 }, { 13, 18 }, { 14, 15 }, { 15, 18 }, { 16, 17 },
                { 16, 19 }, { 17, 18 }, { 18, 19 } };
        addEdges(targetGraph, edges);
    }
}
