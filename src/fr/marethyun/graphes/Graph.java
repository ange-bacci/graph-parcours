package fr.marethyun.graphes;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    private ArrayList<Summit> summits = new ArrayList<>();

    public Graph(ArrayList<Summit> summits) {
        this.summits = summits;
    }

    public Graph(Matrix matrix) {

        if (matrix.getHeight() != matrix.getWidth()) throw new RuntimeException("Invalid");

        int summitCount = matrix.getHeight();

        HashMap<Integer, Summit> tempSummits = new HashMap<>();

        for (int i = 0; i < summitCount; i++) {
            tempSummits.put(i + 1, new Summit(i + 1, new ArrayList<>(), new ArrayList<>()));
        }

        for (int pos = 0; pos < summitCount; pos++) {

            int index = pos + 1;
            Summit summit = tempSummits.get(index);

            for (int column = 0; column < summitCount; column++) { // Successors
                int i = matrix.get(index - 1, column);

                if (i >= 1) summit.getSuccessors().add(tempSummits.get(column + 1));
            }

            for (int row = 0; row < summitCount; row++) { // Predecessors
                int i = matrix.get(row,index - 1);

                if (i >= 1) summit.getPredecessors().add(tempSummits.get(row + 1));
            }

            this.summits.add(summit);
        }
    }

    Graph width(int start) {

        PriorityQueue<Summit> list = new PriorityQueue<>();
        ArrayList<Summit> marked = new ArrayList<>();
        HashMap<Integer, Summit> newGraphSummits = new HashMap<>();

        list.add(this.summits.stream().filter(summit -> summit.getIndex() == start).findFirst().orElseThrow(RuntimeException::new));

        Summit current;
        while ((current = list.poll()) != null) {
            marked.add(current);

            List<Summit> collect = current.getSuccessors().stream().filter(summit -> !marked.contains(summit)).collect(Collectors.toList());

            list.addAll(collect);
        }

        System.out.println();

        return null;
    }

    Graph depth() {

        return null;
    }
}
