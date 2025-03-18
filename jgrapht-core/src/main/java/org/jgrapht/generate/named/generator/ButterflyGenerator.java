package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;
import org.jgrapht.generate.WindmillGraphsGenerator;

public class ButterflyGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        new WindmillGraphsGenerator<V, E>(WindmillGraphsGenerator.Mode.DUTCHWINDMILL, 2, 3)
                .generateGraph(targetGraph);
    }
}
