/*
 * (C) Copyright 2017-2023, by Joris Kinable and Contributors.
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
package org.jgrapht.generate;

import org.jgrapht.*;
import org.jgrapht.alg.isomorphism.*;
import org.jgrapht.alg.shortestpath.*;
import org.jgrapht.generate.named.generator.*;
import org.jgrapht.generate.named.generator.blanusa.BlanusaFirstSnarkGenerator;
import org.jgrapht.generate.named.generator.blanusa.BlanusaSecondSnarkGenerator;
import org.jgrapht.generate.named.generator.horton.EllinghamHorton54Generator;
import org.jgrapht.generate.named.generator.horton.EllinghamHorton78Generator;
import org.jgrapht.generate.named.generator.klein.Klein3RegularGenerator;
import org.jgrapht.generate.named.generator.klein.Klein7RegularGenerator;
import org.jgrapht.graph.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.jgrapht.generate.named.NamedGraphUtils.createAndGenerateGraph;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for NamedGraphGenerator
 *
 * @author Joris Kinable
 */
public class NamedGraphGeneratorTest
{

    @Test
    public void testDoyleGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new DoyleGenerator<>());
        this.validateBasics(g, 27, 54, 3, 3, 5);
        assertTrue(GraphTests.isEulerian(g));
        validateAutomorphismCount(g, 54);
    }

    @Test
    public void testBullGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new BullGenerator<>());
        this.validateBasics(g, 5, 5, 2, 3, 3);
    }

    @Test
    public void testClawGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new ClawGenerator<>());
        this.validateBasics(g, 4, 3, 1, 2, Integer.MAX_VALUE);
        assertTrue(GraphTests.isBipartite(g));
    }

    @Test
    public void testBuckyBallGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new BuckyBallGenerator<>());
        this.validateBasics(g, 60, 90, 9, 9, 5);
        assertTrue(GraphTests.isCubic(g));
    }

    @Test
    public void testClebschGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new ClebschGenerator<>());
        this.validateBasics(g, 16, 40, 2, 2, 4);
        validateAutomorphismCount(g, 1920);
    }

    @Test
    public void testGroetzschGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new GrotzschGenerator<>());
        this.validateBasics(g, 11, 20, 2, 2, 4);
    }

    @Test
    public void testBidiakisCubeGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new BidiakisGenerator<>());
        this.validateBasics(g, 12, 18, 3, 3, 4);
        assertTrue(GraphTests.isCubic(g));
    }

    @Test
    public void testBlanusaFirstSnarkGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new BlanusaFirstSnarkGenerator<>());
        this.validateBasics(g, 18, 27, 4, 4, 5);
        assertTrue(GraphTests.isCubic(g));
    }

    @Test
    public void testBlanusaSecondSnarkGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new BlanusaSecondSnarkGenerator<>());
        this.validateBasics(g, 18, 27, 4, 4, 5);
        assertTrue(GraphTests.isCubic(g));
    }

    @Test
    public void testDoubleStarSnarkGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new DoubleStarSnarkGenerator<>());
        this.validateBasics(g, 30, 45, 4, 4, 6);
    }

    @Test
    public void testBrinkmannGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new BrinkmannGenerator<>());
        this.validateBasics(g, 21, 42, 3, 3, 5);
        assertTrue(GraphTests.isEulerian(g));
    }

    @Test
    public void testGossetGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new GossetGenerator<>());
        this.validateBasics(g, 56, 756, 3, 3, 3);
    }

    @Test
    public void testChvatalGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new ChvatalGenerator<>());
        this.validateBasics(g, 12, 24, 2, 2, 4);
        assertTrue(GraphTests.isEulerian(g));
    }

    @Test
    public void testKittellGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new KittellGenerator<>());
        this.validateBasics(g, 23, 63, 3, 4, 3);
    }

    @Test
    public void testCoxeterGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new CoxeterGenerator<>());
        this.validateBasics(g, 28, 42, 4, 4, 7);
        assertTrue(GraphTests.isCubic(g));
        validateAutomorphismCount(g, 336);
    }

    @Test
    public void testDiamondGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new DiamondGenerator<>());
        this.validateBasics(g, 4, 5, 1, 2, 3);
    }

    @Test
    public void testEllinghamHorton54Graph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new EllinghamHorton54Generator<>());
        this.validateBasics(g, 54, 81, 9, 10, 6);
        assertTrue(GraphTests.isCubic(g));
        assertTrue(GraphTests.isBipartite(g));
        validateAutomorphismCount(g, 32);
    }

    @Test
    public void testEllinghamHorton78Graph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new EllinghamHorton78Generator<>());
        this.validateBasics(g, 78, 117, 7, 13, 6);
        assertTrue(GraphTests.isCubic(g));
        assertTrue(GraphTests.isBipartite(g));
        validateAutomorphismCount(g, 16);
    }

    @Test
    public void testErreraGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new ErreraGenerator<>());
        this.validateBasics(g, 17, 45, 3, 4, 3);
    }

    @Test
    public void testFolkmanGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new FolkmanGenerator<>());
        this.validateBasics(g, 20, 40, 3, 4, 4);
        assertTrue(GraphTests.isBipartite(g));
        assertTrue(GraphTests.isEulerian(g));
        validateAutomorphismCount(g, 3840);
    }

    @Test
    public void testFranklinGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new FranklinGenerator<>());
        this.validateBasics(g, 12, 18, 3, 3, 4);
        assertTrue(GraphTests.isCubic(g));
        assertTrue(GraphTests.isBipartite(g));
        validateAutomorphismCount(g, 48);
    }

    @Test
    public void testFrughtGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new FruchtGenerator<>());
        this.validateBasics(g, 12, 18, 3, 4, 3);
        assertTrue(GraphTests.isCubic(g));
    }

    @Test
    public void testGoldnerHararyGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new GoldnerHararyGenerator<>());
        this.validateBasics(g, 11, 27, 2, 2, 3);
    }

    @Test
    public void testHeawoodGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new HeawoodGenerator<>());
        this.validateBasics(g, 14, 21, 3, 3, 6);
        assertTrue(GraphTests.isCubic(g));
        assertTrue(GraphTests.isBipartite(g));
        validateAutomorphismCount(g, 336);
    }

    @Test
    public void testHerschelGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new HerschelGenerator<>());
        this.validateBasics(g, 11, 18, 3, 4, 4);
        assertTrue(GraphTests.isBipartite(g));
        validateAutomorphismCount(g, 12);
    }

    @Test
    public void testHoffmanGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new HoffmanGenerator<>());
        this.validateBasics(g, 16, 32, 3, 4, 4);
        assertTrue(GraphTests.isBipartite(g));
        validateAutomorphismCount(g, 48);
    }

    @Test
    public void testKrackhardtKiteGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new KrackhardtKiteGenerator<>());
        this.validateBasics(g, 10, 18, 2, 4, 3);
    }

    @Test
    public void testKlein3RegularGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new Klein3RegularGenerator<>());
        this.validateBasics(g, 56, 84, 6, 6, 7);
        assertTrue(GraphTests.isCubic(g));
        validateAutomorphismCount(g, 336);
    }

    @Test
    public void testKlein7RegularGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new Klein7RegularGenerator<>());
        this.validateBasics(g, 24, 84, 3, 3, 3);
        validateAutomorphismCount(g, 336);
    }

    @Test
    public void testMoserSpindleGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new MoserSpindleGenerator<>());
        this.validateBasics(g, 7, 11, 2, 2, 3);
        validateAutomorphismCount(g, 8);
    }

    @Test
    public void testPappusGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new PappusGenerator<>());
        this.validateBasics(g, 18, 27, 4, 4, 6);
        assertTrue(GraphTests.isCubic(g));
        assertTrue(GraphTests.isBipartite(g));
        validateAutomorphismCount(g, 216);
    }

    @Test
    public void testPoussinGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new PoussinGenerator<>());
        this.validateBasics(g, 15, 39, 3, 3, 3);
    }

    @Test
    public void testSchlaefliGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new SchlafliGenerator<>());
        this.validateBasics(g, 27, 216, 2, 2, 3);
    }

    @Test
    public void testTietzeGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new TietzeGenerator<>());
        this.validateBasics(g, 12, 18, 3, 3, 3);
        assertTrue(GraphTests.isCubic(g));
    }

    @Test
    public void testTutteGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new TutteGenerator<>());
        this.validateBasics(g, 46, 69, 5, 8, 4);
        assertTrue(GraphTests.isCubic(g));
    }

    @Test
    public void testThomsenGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new ThomsenGenerator<>());
        this.validateBasics(g, 6, 9, 2, 2, 4);
        assertTrue(GraphTests.isBipartite(g));
    }

    @Test
    void testZacharysKarateClubGraph()
    {
        Graph<Integer, DefaultEdge> g = createAndGenerateGraph(new ZacharysKarateClubGenerator<>());
        assertEquals(34, g.vertexSet().size(), "Unexpected number of vertices");
        assertEquals(78, g.edgeSet().size(), "Unexpected number of edges");
        this.validateBasics(g, 34, 78, 3, 5, 3);
    }

    private <V, E> void validateBasics(
        Graph<V, E> g, int vertices, int edges, int radius, int diameter, double girth)
    {
        assertEquals(vertices, g.vertexSet().size());
        assertEquals(edges, g.edgeSet().size());
        GraphMeasurer<V, E> gm = new GraphMeasurer<>(g);
        assertEquals(radius, gm.getRadius(), 0.00000001);
        assertEquals(diameter, gm.getDiameter(), 0.00000001);
        assertEquals(girth, GraphMetrics.getGirth(g), 0.00000001);
    }

    private void validateAutomorphismCount(Graph<Integer, DefaultEdge> g, int value)
    {
        VF2GraphIsomorphismInspector<Integer, DefaultEdge> vf =
            new VF2GraphIsomorphismInspector<>(g, g);

        Iterator<GraphMapping<Integer, DefaultEdge>> iter = vf.getMappings();
        int count = 0;
        while (iter.hasNext()) {
            count++;
            iter.next();
        }
        assertEquals(count, value);
    }
}
