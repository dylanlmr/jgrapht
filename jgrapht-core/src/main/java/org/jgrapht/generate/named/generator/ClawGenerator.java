package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;
import org.jgrapht.generate.StarGraphGenerator;

public class ClawGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        new StarGraphGenerator<V, E>(4).generateGraph(targetGraph);
    }
}
