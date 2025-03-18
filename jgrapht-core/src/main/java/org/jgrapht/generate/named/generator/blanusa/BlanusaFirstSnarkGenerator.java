package org.jgrapht.generate.named.generator.blanusa;

import org.jgrapht.Graph;
import org.jgrapht.generate.named.generator.NamedGraphGenerator;

public class BlanusaFirstSnarkGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 5 }, { 0, 16 }, { 1, 2 }, { 1, 17 }, { 2, 3 }, { 2, 14 },
                { 3, 4 }, { 3, 8 }, { 4, 5 }, { 4, 17 }, { 5, 6 }, { 6, 7 }, { 6, 11 }, { 7, 8 },
                { 7, 17 }, { 8, 9 }, { 9, 10 }, { 9, 13 }, { 10, 11 }, { 10, 15 }, { 11, 12 },
                { 12, 13 }, { 12, 16 }, { 13, 14 }, { 14, 15 }, { 15, 16 } };
        addEdges(targetGraph, edges);
    }
}
