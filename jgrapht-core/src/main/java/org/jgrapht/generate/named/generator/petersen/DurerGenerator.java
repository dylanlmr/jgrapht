package org.jgrapht.generate.named.generator.petersen;

public class DurerGenerator<V, E> extends GeneralizedPetersenGenerator<V, E> {
    private static final int REGULAR_POLYGON_SIZE = 6;
    private static final int STAR_POLYGON_SIZE = 2;

    public DurerGenerator() {
        super(REGULAR_POLYGON_SIZE, STAR_POLYGON_SIZE);
    }
}
