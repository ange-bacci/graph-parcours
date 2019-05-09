package fr.marethyun.graphes;

public class App {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new int[][] {
                new int[]{1, 1, 0, 1},
                new int[]{0, 0, 1, 1},
                new int[]{0, 0, 0, 0},
                new int[]{1, 0, 1, 0},
        });

        Graph graph = new Graph(matrix);

        graph.width(1);

    }
}
