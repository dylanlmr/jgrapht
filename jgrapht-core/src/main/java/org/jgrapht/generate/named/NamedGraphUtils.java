package org.jgrapht.generate.named;

import org.jgrapht.Graph;
import org.jgrapht.generate.named.generator.NamedGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.jgrapht.util.SupplierUtil;

public class NamedGraphUtils {
    public static Graph<Integer, DefaultEdge> createGraph() {
        return GraphTypeBuilder
                .undirected()
                .allowingMultipleEdges(false)
                .allowingSelfLoops(false)
                .vertexSupplier(SupplierUtil.createIntegerSupplier())
                .edgeClass(DefaultEdge.class)
                .buildGraph();
    }

    public static Graph<Integer, DefaultEdge> createAndGenerateGraph(
            NamedGraphGenerator<Integer, DefaultEdge> generator)
    {
        Graph<Integer, DefaultEdge> graph = createGraph();
        generator.generate(graph);
        return graph;
    }

    private NamedGraphUtils() {}
}
