package org.jgrapht.generate.named.generator.petersen;

public class PetersenGenerator<V, E> extends GeneralizedPetersenGenerator<V, E> {
    private static final int REGULAR_POLYGON_SIZE = 5;
    private static final int STAR_POLYGON_SIZE = 2;

    public PetersenGenerator() {
        super(REGULAR_POLYGON_SIZE, STAR_POLYGON_SIZE);
    }
}
