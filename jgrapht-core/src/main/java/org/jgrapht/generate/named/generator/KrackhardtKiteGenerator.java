package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class KrackhardtKiteGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 5 }, { 1, 3 }, { 1, 4 }, { 1, 6 },
                { 2, 3 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 3, 6 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
                { 6, 7 }, { 7, 8 }, { 8, 9 } };
        addEdges(targetGraph, edges);
    }
}
