package org.jgrapht.generate.named.generator.petersen;

import org.jgrapht.Graph;
import org.jgrapht.generate.GeneralizedPetersenGraphGenerator;
import org.jgrapht.generate.named.generator.NamedGraphGenerator;

public abstract class GeneralizedPetersenGenerator<V, E> extends NamedGraphGenerator<V, E> {
    private final int regularPolygonSize;
    private final int starPolygonSize;

    protected GeneralizedPetersenGenerator(int regularPolygonSize, int starPolygonSize) {
        this.regularPolygonSize = regularPolygonSize;
        this.starPolygonSize = starPolygonSize;
    }

    @Override
    public void generate(Graph<V, E> targetGraph) {
        GeneralizedPetersenGraphGenerator<V, E> generator =
                new GeneralizedPetersenGraphGenerator<>(regularPolygonSize, starPolygonSize);
        generator.generateGraph(targetGraph);
    }
}
