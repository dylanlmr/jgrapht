package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class FruchtGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 6 }, { 0, 7 }, { 1, 2 }, { 1, 7 }, { 2, 3 }, { 2, 8 },
                { 3, 4 }, { 3, 9 }, { 4, 5 }, { 4, 9 }, { 5, 6 }, { 5, 10 }, { 6, 10 }, { 7, 11 },
                { 8, 9 }, { 8, 11 }, { 10, 11 } };
        addEdges(targetGraph, edges);
    }
}
