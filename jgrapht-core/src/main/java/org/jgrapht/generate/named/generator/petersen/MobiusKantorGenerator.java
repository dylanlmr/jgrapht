package org.jgrapht.generate.named.generator.petersen;

public class MobiusKantorGenerator<V, E> extends GeneralizedPetersenGenerator<V, E> {
    private static final int REGULAR_POLYGON_SIZE = 8;
    private static final int STAR_POLYGON_SIZE = 3;

    public MobiusKantorGenerator() {
        super(REGULAR_POLYGON_SIZE, STAR_POLYGON_SIZE);
    }
}
