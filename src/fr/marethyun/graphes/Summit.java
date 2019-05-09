package fr.marethyun.graphes;

import java.util.ArrayList;

public class Summit {
    private final int index;
    private final ArrayList<Summit> successors;
    private final ArrayList<Summit> predecessors;

    public Summit(int index, ArrayList<Summit> successors, ArrayList<Summit> predecessors) {
        this.index = index;
        this.successors = successors;
        this.predecessors = predecessors;
    }

    public int getIndex() {
        return index;
    }

    public ArrayList<Summit> getSuccessors() {
        return successors;
    }

    public ArrayList<Summit> getPredecessors() {
        return predecessors;
    }
}
