package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class DiamondGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 2, 3 } };
        addEdges(targetGraph, edges);
    }
}
