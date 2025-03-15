package org.jgrapht.generate.netgen.problem;

import org.jgrapht.Graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * Default implementation of a Maximum Flow Problem.
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 */
public class MaximumFlowProblemBase<V, E>
        implements MaximumFlowProblem<V, E>
{
    private final Graph<V, E> graph;
    private final Set<V> sources;
    private final Set<V> sinks;
    private final Function<E, Double> capacities;

    /**
     * Constructs a new maximum flow problem.
     *
     * @param graph flow network
     * @param sources set of network sources
     * @param sinks set of network sinks
     * @param capacities network capacity function
     */
    public MaximumFlowProblemBase(
            Graph<V, E> graph, Set<V> sources, Set<V> sinks, Function<E, Double> capacities)
    {
        this.graph = graph;
        this.sources = sources;
        this.sinks = sinks;
        this.capacities = capacities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Graph<V, E> getGraph()
    {
        return graph;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<V> getSources()
    {
        return sources;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<V> getSinks()
    {
        return sinks;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Function<E, Double> getCapacities()
    {
        return capacities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MaximumFlowProblem<V, E> toSingleSourceSingleSinkProblem()
    {
        Set<E> newEdges = new HashSet<>();

        Set<V> sourceSet = convert(sources, newEdges, true);
        Set<V> sinkSet = convert(sinks, newEdges, false);

        Function<E, Double> updatedCapacities = e -> {
            if (newEdges.contains(e)) {
                return CAPACITY_INF;
            } else {
                return capacities.apply(e);
            }
        };

        return new MaximumFlowProblemBase<>(graph, sourceSet, sinkSet, updatedCapacities);
    }

    /**
     * Adds a new super vertex and connects it to all vertices in {@code vertices}. Depending on
     * the value of {@code sources}, the edges are directed from super vertex or to super
     * vertex. New edges are added to {@code newEdges}.
     *
     * @param vertices set of vertices to connect super vertex to
     * @param newEdges container to add new edges to
     * @param sources {@code true} if super vertex is super source, {@code false} if it's super
     *        sink
     * @return 1 element set containing the super vertex
     */
    private Set<V> convert(Set<V> vertices, Set<E> newEdges, boolean sources)
    {
        if (vertices.size() == 1) {
            return vertices;
        }
        V superVertex = graph.addVertex();
        Set<V> newSourceSet = Collections.singleton(superVertex);

        for (V vertex : vertices) {
            E edge;
            if (sources) {
                edge = graph.addEdge(superVertex, vertex);
            } else {
                edge = graph.addEdge(vertex, superVertex);
            }
            newEdges.add(edge);
        }
        return newSourceSet;
    }
}
