package org.jgrapht.generate.named.generator.klein;

import org.jgrapht.Graph;
import org.jgrapht.generate.named.generator.NamedGraphGenerator;

public class Klein7RegularGenerator<V, E> extends NamedGraphGenerator<V, E> {
    @Override
    public void generate(Graph<V, E> targetGraph) {
        vertexMap.clear();
        int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
        addCycle(targetGraph, arr);
        int[][] edges = { { 0, 2 }, { 0, 6 }, { 0, 10 }, { 0, 11 }, { 0, 12 }, { 0, 18 }, { 1, 3 },
                { 1, 9 }, { 1, 11 }, { 1, 20 }, { 1, 22 }, { 2, 4 }, { 2, 10 }, { 2, 15 }, { 2, 19 },
                { 3, 5 }, { 3, 7 }, { 3, 14 }, { 3, 22 }, { 4, 6 }, { 4, 8 }, { 4, 19 }, { 4, 21 },
                { 5, 7 }, { 5, 11 }, { 5, 17 }, { 5, 23 }, { 6, 8 }, { 6, 11 }, { 6, 16 }, { 6, 18 },
                { 7, 9 }, { 7, 14 }, { 7, 15 }, { 7, 16 }, { 7, 17 }, { 8, 10 }, { 8, 13 }, { 8, 14 },
                { 8, 16 }, { 8, 21 }, { 9, 11 }, { 9, 13 }, { 9, 15 }, { 9, 16 }, { 9, 20 }, { 10, 12 },
                { 10, 13 }, { 10, 14 }, { 10, 15 }, { 11, 13 }, { 11, 23 }, { 12, 14 }, { 12, 17 },
                { 12, 18 }, { 12, 22 }, { 12, 23 }, { 13, 15 }, { 13, 21 }, { 13, 23 }, { 14, 16 },
                { 14, 22 }, { 15, 17 }, { 15, 19 }, { 16, 18 }, { 16, 20 }, { 17, 18 }, { 17, 19 },
                { 17, 23 }, { 18, 19 }, { 18, 20 }, { 19, 20 }, { 19, 21 }, { 20, 21 }, { 20, 22 },
                { 21, 22 }, { 21, 23 }, { 22, 23 } };
        addEdges(targetGraph, edges);
    }
}
