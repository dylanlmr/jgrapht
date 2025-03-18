package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class ClebschGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int x = 0;
        for (int i = 0; i < 8; i++) {
            addEdge(targetGraph, x % 16, (x + 1) % 16);
            addEdge(targetGraph, x % 16, (x + 6) % 16);
            addEdge(targetGraph, x % 16, (x + 8) % 16);
            x++;
            addEdge(targetGraph, x % 16, (x + 3) % 16);
            addEdge(targetGraph, x % 16, (x + 2) % 16);
            addEdge(targetGraph, x % 16, (x + 8) % 16);
            x++;
        }
    }
}
