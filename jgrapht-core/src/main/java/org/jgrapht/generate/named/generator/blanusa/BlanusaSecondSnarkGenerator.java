package org.jgrapht.generate.named.generator.blanusa;

import org.jgrapht.Graph;
import org.jgrapht.generate.named.generator.NamedGraphGenerator;

public class BlanusaSecondSnarkGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 14 }, { 1, 5 }, { 1, 11 }, { 2, 3 }, { 2, 6 },
                { 3, 4 }, { 3, 9 }, { 4, 5 }, { 4, 7 }, { 5, 6 }, { 6, 8 }, { 7, 8 }, { 7, 17 },
                { 8, 9 }, { 9, 15 }, { 10, 11 }, { 10, 14 }, { 10, 16 }, { 11, 12 }, { 12, 13 },
                { 12, 17 }, { 13, 14 }, { 13, 15 }, { 15, 16 }, { 16, 17 } };
        addEdges(targetGraph, edges);
    }
}
