package org.jgrapht.generate.netgen.problem;

import org.jgrapht.Graph;

import java.util.Set;
import java.util.function.Function;

/**
 * Default implementation of a Bipartite Matching Problem
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 */
public class BipartiteMatchingProblemBase<V, E>
        implements BipartiteMatchingProblem<V, E>
{
    private final Graph<V, E> graph;
    private final Set<V> partition1;
    private final Set<V> partition2;
    private final Function<E, Double> costs;
    private final boolean weighted;

    /**
     * Constructs a new bipartite matching problem
     *
     * @param graph a graph, which defines the problem
     * @param partition1 one of the partitions of the graph
     * @param partition2 one of the partitions of the graph
     * @param costs problem cost function
     * @param weighted is the problem is weighted or not
     */
    public BipartiteMatchingProblemBase(
            Graph<V, E> graph, Set<V> partition1, Set<V> partition2, Function<E, Double> costs,
            boolean weighted)
    {
        this.graph = graph;
        this.partition1 = partition1;
        this.partition2 = partition2;
        this.costs = costs;
        this.weighted = weighted;
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
    public Function<E, Double> getCosts()
    {
        return costs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<V> getPartition1()
    {
        return partition1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<V> getPartition2()
    {
        return partition2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isWeighted()
    {
        return weighted;
    }

}
