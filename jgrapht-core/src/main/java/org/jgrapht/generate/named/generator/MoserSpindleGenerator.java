package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class MoserSpindleGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 4 }, { 0, 5 }, { 0, 6 }, { 1, 2 }, { 1, 5 }, { 2, 3 },
                { 2, 5 }, { 3, 4 }, { 3, 6 }, { 4, 6 } };
        addEdges(targetGraph, edges);
    }
}
