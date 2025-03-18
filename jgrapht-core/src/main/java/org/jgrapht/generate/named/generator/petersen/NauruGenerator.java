package org.jgrapht.generate.named.generator.petersen;

public class NauruGenerator<V, E> extends GeneralizedPetersenGenerator<V, E> {
    private static final int REGULAR_POLYGON_SIZE = 12;
    private static final int STAR_POLYGON_SIZE = 5;

    public NauruGenerator() {
        super(REGULAR_POLYGON_SIZE, STAR_POLYGON_SIZE);
    }
}
