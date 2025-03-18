package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class GrotzschGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        for (int i = 1; i < 6; i++)
            addEdge(targetGraph, 0, i);
        addEdge(targetGraph, 10, 6);
        for (int i = 6; i < 10; i++) {
            addEdge(targetGraph, i, i + 1);
            addEdge(targetGraph, i, i - 4);
        }
        addEdge(targetGraph, 10, 1);
        for (int i = 7; i < 11; i++)
            addEdge(targetGraph, i, i - 6);
        addEdge(targetGraph, 6, 5);
    }
}
