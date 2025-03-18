package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class ThomsenGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 3 }, { 0, 4 }, { 0, 5 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 3 },
                { 2, 4 }, { 2, 5 } };
        addEdges(targetGraph, edges);
    }
}
