package org.jgrapht.generate.named.generator.petersen;

public class DesarguesGenerator<V, E> extends GeneralizedPetersenGenerator<V, E> {
    private static final int REGULAR_POLYGON_SIZE = 10;
    private static final int STAR_POLYGON_SIZE = 3;

    public DesarguesGenerator() {
        super(REGULAR_POLYGON_SIZE, STAR_POLYGON_SIZE);
    }
}
