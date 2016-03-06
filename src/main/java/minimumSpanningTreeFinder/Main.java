package minimumSpanningTreeFinder;

/**
 * Main class of program. Interacts with user.
 * @author sergeioff
 */
public class Main {
    public static void main(String[] args) {
        InputHelper reader = new InputHelper();

        System.out.println("Please select the option:");
        System.out.println("\t1 - read graph from keyboard.");
        System.out.println("\t2 - read graph from file.");

        Graph graph = null;

        switch (reader.readInteger()) {
            case 1:
                graph = GraphReaders.readGraphFromKeyboard();
                break;
            case 2:
                System.out.println("Enter file name: ");
                graph = GraphReaders.readGraphFromFile(reader.readLine());
        }

        if (graph != null) {
            int[][] spanningTreeAdjacencyMatrix = graph.getMinimumSpanningTree().getAdjacencyMatrix();

            System.out.println("Minimum spanning tree:");
            for (int[] line : spanningTreeAdjacencyMatrix) {
                for (int el : line) {
                    System.out.printf("%d ", el);
                }
                System.out.println();
            }
        }
    }
}
