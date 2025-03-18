package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class BullGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        this.addEdge(targetGraph, 0, 1);
        this.addEdge(targetGraph, 1, 2);
        this.addEdge(targetGraph, 2, 3);
        this.addEdge(targetGraph, 1, 3);
        this.addEdge(targetGraph, 3, 4);
    }
}
