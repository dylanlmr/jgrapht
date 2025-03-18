package org.jgrapht.generate.named.generator;

import org.jgrapht.Graph;

public class BuckyBallGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[][] edges = { { 0, 2 }, { 0, 48 }, { 0, 59 }, { 1, 3 }, { 1, 9 }, { 1, 58 }, { 2, 3 },
                { 2, 36 }, { 3, 17 }, { 4, 6 }, { 4, 8 }, { 4, 12 }, { 5, 7 }, { 5, 9 }, { 5, 16 },
                { 6, 7 }, { 6, 20 }, { 7, 21 }, { 8, 9 }, { 8, 56 }, { 10, 11 }, { 10, 12 }, { 10, 20 },
                { 11, 27 }, { 11, 47 }, { 12, 13 }, { 13, 46 }, { 13, 54 }, { 14, 15 }, { 14, 16 },
                { 14, 21 }, { 15, 25 }, { 15, 41 }, { 16, 17 }, { 17, 40 }, { 18, 19 }, { 18, 20 },
                { 18, 26 }, { 19, 21 }, { 19, 24 }, { 22, 23 }, { 22, 31 }, { 22, 34 }, { 23, 25 },
                { 23, 38 }, { 24, 25 }, { 24, 30 }, { 26, 27 }, { 26, 30 }, { 27, 29 }, { 28, 29 },
                { 28, 31 }, { 28, 35 }, { 29, 44 }, { 30, 31 }, { 32, 34 }, { 32, 39 }, { 32, 50 },
                { 33, 35 }, { 33, 45 }, { 33, 51 }, { 34, 35 }, { 36, 37 }, { 36, 40 }, { 37, 39 },
                { 37, 52 }, { 38, 39 }, { 38, 41 }, { 40, 41 }, { 42, 43 }, { 42, 46 }, { 42, 55 },
                { 43, 45 }, { 43, 53 }, { 44, 45 }, { 44, 47 }, { 46, 47 }, { 48, 49 }, { 48, 52 },
                { 49, 53 }, { 49, 57 }, { 50, 51 }, { 50, 52 }, { 51, 53 }, { 54, 55 }, { 54, 56 },
                { 55, 57 }, { 56, 58 }, { 57, 59 }, { 58, 59 } };
        addEdges(targetGraph, edges);
    }
}
