package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class DoyleGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 3; j++) {
                this.addEdge(
                        targetGraph, doyleHash(i, j), doyleHash(mod(4 * i + 1, 9), mod(j - 1, 3)));
                this.addEdge(
                        targetGraph, doyleHash(i, j), doyleHash(mod(4 * i - 1, 9), mod(j - 1, 3)));
                this.addEdge(
                        targetGraph, doyleHash(i, j), doyleHash(mod(7 * i + 7, 9), mod(j + 1, 3)));
                this.addEdge(
                        targetGraph, doyleHash(i, j), doyleHash(mod(7 * i - 7, 9), mod(j + 1, 3)));
            }
    }

    private int doyleHash(int u, int v)
    {
        return u * 19 + v;
    }

    private int mod(int u, int m)
    {
        int r = u % m;
        return r < 0 ? r + m : r;
    }
}
