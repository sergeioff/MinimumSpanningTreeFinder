package minimumSpanningTreeFinder;

/**
 * This class contains static methods which can read graph from different sources.
 * @author sergeioff
 */
public class GraphReaders {
    /**
     * Reads graph from keyboard.
     * Interacts with user input and shows him messages.
     * @return graph
     */
    static Graph readGraphFromKeyboard() {
        InputHelper reader = new InputHelper();
        System.out.print("Enter number of vertices in graph: ");
        int verticesNumber = reader.readInteger();

        Graph graph = new Graph(verticesNumber);

        System.out.print("Enter number of edges in graph: ");
        int edgesNumber = reader.readInteger();

        System.out.println("Enter vertices in next format \"firstPoint secondPoint weight\"");
        System.out.println("Example: 0 1 20");

        for (int i = 0; i < edgesNumber; i++) {
            System.out.printf("Enter edge number %d:\n", i);
            int[] input = reader.readIntegers();
            graph.addEdge(input[0], input[1], input[2]);
        }

        return graph;
    }

    /**
     * Reads graph from file.
     * @param path file name
     * @return graph
     */
    static Graph readGraphFromFile(String path) {
        InputHelper reader = new InputHelper(path);
        int verticesCount = reader.readInteger();
        int edgesCount = reader.readInteger();

        Graph graph = new Graph(verticesCount);

        for (int i = 0; i < edgesCount; i++) {
            int[] input = reader.readIntegers();
            graph.addEdge(input[0], input[1], input[2]);
        }

        return graph;
    }
}
