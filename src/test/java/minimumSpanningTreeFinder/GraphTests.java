package minimumSpanningTreeFinder;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author sergeioff
 */
public class GraphTests {
    Graph createGraph1() {
        Graph graph = new Graph(7);

        graph.addEdge(0, 6, 21);
        graph.addEdge(0, 1, 27);
        graph.addEdge(6, 5, 22);
        graph.addEdge(5, 4, 29);
        graph.addEdge(6, 1, 16);
        graph.addEdge(1, 2, 14);
        graph.addEdge(1, 3, 13);
        graph.addEdge(1, 4, 18);
        graph.addEdge(2, 3, 19);
        graph.addEdge(4, 3, 24);

        return graph;
    }

    Graph createGraph2() {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 8);
        graph.addEdge(1, 2, 11);
        graph.addEdge(1, 3, 8);
        graph.addEdge(2, 4, 7);
        graph.addEdge(4, 3, 2);
        graph.addEdge(2, 5, 1);
        graph.addEdge(5, 4, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 6, 4);
        graph.addEdge(3, 7, 7);
        graph.addEdge(7, 6, 14);
        graph.addEdge(7, 8, 9);
        graph.addEdge(8, 6, 10);

        return graph;
    }

    Graph createGraph3() {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 20);
        graph.addEdge(0, 3, 11);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 4, 17);

        return graph;
    }

    @Test
    public void testGraphCreation1() {
        Graph graph = createGraph1();

        assertArrayEquals(new int[][] {
                {0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {0, 1, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 1, 0}
                }, graph.getAdjacencyMatrix()
        );
    }

    @Test
    public void testGraphCreation2() {
        Graph graph = createGraph2();

        assertArrayEquals(new int[][] {
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 0, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 0}
        }, graph.getAdjacencyMatrix());
    }

    @Test
    public void testGraphCreation3() {
        Graph graph = createGraph3();

        assertArrayEquals(new int[][] {
                {0, 1, 0, 1, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1},
                {1, 0, 0, 1, 0}
        }, graph.getAdjacencyMatrix());
    }

    @Test
    public void testFindingMinimumSpanningTree1() {
        Graph graph = createGraph1();

        assertArrayEquals(new int[][] {
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 1, 0}
                }, graph.getMinimumSpanningTree().getAdjacencyMatrix()
        );
    }

    @Test
    public void testFindingMinimumSpanningTree2() {
        Graph graph = createGraph2();

        assertArrayEquals(new int[][] {
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 0}
        }, graph.getMinimumSpanningTree().getAdjacencyMatrix());
    }

    @Test
    public void testFindingMinimumSpanningTree3() {
        Graph graph = createGraph3();

        assertArrayEquals(new int[][] {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0}
        }, graph.getMinimumSpanningTree().getAdjacencyMatrix());
    }
}
