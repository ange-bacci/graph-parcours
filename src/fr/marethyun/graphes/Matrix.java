package fr.marethyun.graphes;

import java.util.LinkedList;

public class Matrix {
    private final LinkedList<LinkedList<Integer>> raw;

    private final int height;
    private final int width;

    public Matrix(LinkedList<LinkedList<Integer>> raw) {
        this.raw = raw;
        if (!isValid()) throw new RuntimeException("invalid");

        this.height = raw.size();
        this.width = raw.isEmpty() ? 0 : raw.get(0).size();
    }

    public Matrix(int[][] matrix) {
        raw = new LinkedList<>();

        for (int[] intArray : matrix) {
            LinkedList<Integer> line = new LinkedList<>();
            for (Integer i : intArray) {
                line.add(i);
            }
            raw.add(line);
        }

        if (!isValid()) throw new RuntimeException("invalid");

        this.height = raw.size();
        this.width = raw.isEmpty() ? 0 : raw.get(0).size();
    }

    public int get(int i, int j) {
        return raw.get(i).get(j);
    }

    private boolean isValid() {
        if (this.raw.isEmpty()) return true;
        for (int i = 1; i < this.raw.size(); i++) {
            if (this.raw.get(0) == null && this.raw.get(i - 1).size() != this.raw.get(i).size()) return false;
        }
        return true;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
