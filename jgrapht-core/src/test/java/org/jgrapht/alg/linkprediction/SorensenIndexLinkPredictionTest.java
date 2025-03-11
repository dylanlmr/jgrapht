/*
 * (C) Copyright 2020-2023, by Dimitrios Michail and Contributors.
 *
 * JGraphT : a free Java graph-theory library
 *
 * See the CONTRIBUTORS.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the
 * GNU Lesser General Public License v2.1 or later
 * which is available at
 * http://www.gnu.org/licenses/old-licenses/lgpl-2.1-standalone.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR LGPL-2.1-or-later
 */
package org.jgrapht.alg.linkprediction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.jgrapht.Graph;
import org.jgrapht.TestUtil;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.jgrapht.util.SupplierUtil;
import org.junit.jupiter.api.Test;

/**
 * Tests for class SorensenIndexLinkPrediction
 *
 * @author Dimitrios Michail
 */
public class SorensenIndexLinkPredictionTest
{

    @Test
    public void testPrediction()
    {
        Graph<Integer,
            DefaultEdge> g = GraphTypeBuilder
                .undirected().weighted(false).vertexSupplier(SupplierUtil.createIntegerSupplier())
                .edgeSupplier(SupplierUtil.DEFAULT_EDGE_SUPPLIER).buildGraph();

        TestUtil.constructGraph(
            g, new int[][] { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 3, 4 },
                { 3, 5 }, { 4, 5 } });

        SorensenIndexLinkPrediction<Integer, DefaultEdge> alg =
            new SorensenIndexLinkPrediction<>(g);

        double[] scores = new double[6];

        int pos = 0;
        for (int u : g.vertexSet()) {
            for (int v : g.vertexSet()) {
                if (u >= v || g.containsEdge(u, v)) {
                    continue;
                }
                double score = alg.predict(u, v);
                scores[pos++] = score;
            }
        }

        double[] expected = { 0.8, 0.6666666666666666, 0.5, 0.8571428571428571, 0.4, 0.8 };

        assertArrayEquals(expected, scores, 1e-9);
    }

    @Test
    public void testInvalidPrediction()
    {
        assertThrows(LinkPredictionIndexNotWellDefinedException.class, () -> {
            Graph<Integer,
                DefaultEdge> g = GraphTypeBuilder
                    .directed().weighted(false).vertexSupplier(SupplierUtil.createIntegerSupplier())
                    .edgeSupplier(SupplierUtil.DEFAULT_EDGE_SUPPLIER).buildGraph();

            g.addVertex(0);
            g.addVertex(1);

            SorensenIndexLinkPrediction<Integer, DefaultEdge> alg =
                new SorensenIndexLinkPrediction<>(g);

            alg.predict(0, 1);
        });
    }

}
