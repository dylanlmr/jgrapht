package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for named graph generators.
 *
 * @param <V> the vertex type
 * @param <E> the edge type
 */
public abstract class NamedGraphGenerator<V, E> {
    protected Map<Integer, V> vertexMap;

    protected NamedGraphGenerator() {
        this.vertexMap = new HashMap<>();
    }

    public abstract void generate(Graph<V, E> targetGraph);

    protected V addVertex(Graph<V, E> targetGraph, int i)
    {
        return vertexMap.computeIfAbsent(i, i1 -> targetGraph.addVertex());
    }

    protected void addEdge(Graph<V, E> targetGraph, int i, int j)
    {
        V u = addVertex(targetGraph, i);
        V v = addVertex(targetGraph, j);
        targetGraph.addEdge(u, v);
    }

    protected void addEdges(Graph<V, E> targetGraph, int[][] edges)
    {
        for (int[] edge : edges)
            addEdge(targetGraph, edge[0], edge[1]);
    }

    protected void addCycle(Graph<V, E> targetGraph, int[] vertices)
    {
        for (int i = 0; i < vertices.length; i++)
            addEdge(targetGraph, vertices[i], vertices[(i + 1) % vertices.length]);
    }
}
