package org.jgrapht.generate.netgen.problem;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;


abstract class BipartiteMatchingProblemTest<V, E> {
    protected BipartiteMatchingProblem<V, E> bipartiteMatchingProblem;

    protected abstract BipartiteMatchingProblem<V, E> createBipartiteMatchingProblem();
    protected abstract Graph<V, E> createGraph();
    protected abstract Set<V> createPartition1();
    protected abstract Set<V> createPartition2();
    protected abstract Function<E, Double> createCosts();
    protected abstract boolean isWeighted();
    protected abstract Double expectedEdgeCost(E edge);

    @BeforeEach
    protected void setUp() {
        bipartiteMatchingProblem = createBipartiteMatchingProblem();
    }

    @Test
    public void testDumpCosts() {
        BipartiteMatchingProblem<V, E> problem = createBipartiteMatchingProblem();
        Graph<V, E> graph = problem.getGraph();

        for (E edge : graph.edgeSet())
            assertEquals(expectedEdgeCost(edge), problem.getCosts().apply(edge),
                    "Cost function should return the expected cost");

        try {
            problem.dumpCosts();
        } catch (UnsupportedOperationException e) {
            // This is expected for some graph implementations
        }
    }

    @Test
    public void testGraphNotNull() {
        assertNotNull(bipartiteMatchingProblem.getGraph(),
                "Graph should not be null");
    }

    @Test
    public void testPartition1NotNull() {
        assertNotNull(bipartiteMatchingProblem.getPartition1(),
                "Partition1 should not be null");
    }

    @Test
    public void testPartition2NotNull() {
        assertNotNull(bipartiteMatchingProblem.getPartition2(),
                "Partition2 should not be null");
    }

    @Test
    public void testCostsNotNull() {
        assertNotNull(bipartiteMatchingProblem.getCosts(),
                "Costs function should not be null");
    }

    @Test
    public void testGraphIsSimpleGraph() {
        assertInstanceOf(SimpleGraph.class, bipartiteMatchingProblem.getGraph(),
                "Graph should be an instance of SimpleGraph");
    }

    @Test
    public void testPartition1IsSubsetOfVertices() {
        Set<V> vertices = bipartiteMatchingProblem.getGraph().vertexSet();
        assertTrue(vertices.containsAll(bipartiteMatchingProblem.getPartition1()),
                "All vertices in partition1 should be in the graph");
    }

    @Test
    public void testPartition2IsSubsetOfVertices() {
        Set<V> vertices = bipartiteMatchingProblem.getGraph().vertexSet();
        assertTrue(vertices.containsAll(bipartiteMatchingProblem.getPartition2()),
                "All vertices in partition2 should be in the graph");
    }
}
