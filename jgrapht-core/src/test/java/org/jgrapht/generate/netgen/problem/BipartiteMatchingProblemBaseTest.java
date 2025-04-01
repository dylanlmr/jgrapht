package org.jgrapht.generate.netgen.problem;


import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class BipartiteMatchingProblemBaseTest extends BipartiteMatchingProblemTest<String, DefaultEdge> {

    @Override
    protected BipartiteMatchingProblem<String, DefaultEdge> createBipartiteMatchingProblem() {
        return new BipartiteMatchingProblemBase<>(
                createGraph(), createPartition1(),
                createPartition2(), createCosts(), isWeighted());
    }

    @Override
    protected Graph<String, DefaultEdge> createGraph() {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        return graph;
    }

    @Override
    protected Set<String> createPartition1() {
        Set<String> partition1 = new HashSet<>();
        partition1.add("A");
        partition1.add("B");
        return partition1;
    }

    @Override
    protected Set<String> createPartition2() {
        Set<String> partition2 = new HashSet<>();
        partition2.add("C");
        partition2.add("D");
        return partition2;
    }

    @Override
    protected Function<DefaultEdge, Double> createCosts() {
        return edge -> 1.0;
    }

    @Override
    protected boolean isWeighted() {
        return true;
    }

    @Override
    protected Double expectedEdgeCost(DefaultEdge edge) {
        return 1.0;
    }

    @Test
    void testBipartiteMatchingProblemBase() {
        assertNotNull(bipartiteMatchingProblem,
                "Bipartite Matching Problem should be initialized");

        assertEquals(4, bipartiteMatchingProblem.getGraph()
                .vertexSet().size(), "Unexpected number of vertices");
        assertEquals(2, bipartiteMatchingProblem.getGraph()
                .edgeSet().size(), "Unexpected number of edges");

        assertEquals(2, bipartiteMatchingProblem.getPartition1()
                .size(), "Unexpected size of partition 1");
        assertEquals(2, bipartiteMatchingProblem.getPartition2()
                .size(), "Unexpected size of partition 2");

        assertEquals(1.0, bipartiteMatchingProblem.getCosts()
                .apply(new DefaultEdge()), "Edge cost should be 1.0");

        assertTrue(bipartiteMatchingProblem.isWeighted(),
                "The problem should be weighted");
    }

    @Test
    void testUnweightedBipartiteMatching() {
        bipartiteMatchingProblem = new BipartiteMatchingProblemBase<>(
                createGraph(), createPartition1(),
                createPartition2(), createCosts(), false);

        assertFalse(bipartiteMatchingProblem.isWeighted(),
                "The problem should be unweighted");
    }

    @Test
    void testDumpCostsWithCustomCosts() {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        DefaultEdge edge1 = graph.addEdge("A", "C");
        DefaultEdge edge2 = graph.addEdge("B", "D");

        Function<DefaultEdge, Double> customCosts = edge -> {
            if (edge == edge1) return 2.0;
            if (edge == edge2) return 3.0;
            return 0.0;
        };

        BipartiteMatchingProblem<String, DefaultEdge> problem = new BipartiteMatchingProblemBase<>(
                graph, createPartition1(), createPartition2(), customCosts, true);

        assertEquals(2.0, problem.getCosts().apply(edge1), "Edge A-C should have cost 2.0");
        assertEquals(3.0, problem.getCosts().apply(edge2), "Edge B-D should have cost 3.0");

        try {
            problem.dumpCosts();
        } catch (UnsupportedOperationException e) {
            // This is expected for SimpleGraph
        }
    }

    @Test
    void testDumpCostsWithZeroCosts() {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        DefaultEdge edge1 = graph.addEdge("A", "C");
        DefaultEdge edge2 = graph.addEdge("B", "D");

        Function<DefaultEdge, Double> zeroCosts = edge -> 0.0;

        BipartiteMatchingProblem<String, DefaultEdge> problem = new BipartiteMatchingProblemBase<>(
                graph, createPartition1(), createPartition2(), zeroCosts, true);

        assertEquals(0.0, problem.getCosts().apply(edge1), "Edge A-C should have cost 0.0");
        assertEquals(0.0, problem.getCosts().apply(edge2), "Edge B-D should have cost 0.0");

        try {
            problem.dumpCosts();
        } catch (UnsupportedOperationException e) {
            // This is expected for SimpleGraph
        }
    }

    @Test
    void testDumpCostsWithNegativeCosts() {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        DefaultEdge edge1 = graph.addEdge("A", "C");
        DefaultEdge edge2 = graph.addEdge("B", "D");

        Function<DefaultEdge, Double> negativeCosts = edge -> {
            if (edge == edge1) return -1.0;
            if (edge == edge2) return -2.0;
            return 0.0;
        };

        BipartiteMatchingProblem<String, DefaultEdge> problem = new BipartiteMatchingProblemBase<>(
                graph, createPartition1(), createPartition2(), negativeCosts, true);

        assertEquals(-1.0, problem.getCosts().apply(edge1), "Edge A-C should have cost -1.0");
        assertEquals(-2.0, problem.getCosts().apply(edge2), "Edge B-D should have cost -2.0");

        try {
            problem.dumpCosts();
        } catch (UnsupportedOperationException e) {
            // This is expected for SimpleGraph
        }
    }

    @Test
    void testPartitionDisjointness() {
        Set<String> intersection = new HashSet<>(bipartiteMatchingProblem.getPartition1());
        intersection.retainAll(bipartiteMatchingProblem.getPartition2());
        assertTrue(intersection.isEmpty(), "Partitions should be disjoint");
    }

    @Test
    void testPartitionCoverage() {
        Set<String> allVertices = new HashSet<>(bipartiteMatchingProblem.getGraph().vertexSet());
        Set<String> partitionUnion = new HashSet<>(bipartiteMatchingProblem.getPartition1());
        partitionUnion.addAll(bipartiteMatchingProblem.getPartition2());
        assertEquals(allVertices, partitionUnion, "All vertices should be in either partition1 or partition2");
    }
}
