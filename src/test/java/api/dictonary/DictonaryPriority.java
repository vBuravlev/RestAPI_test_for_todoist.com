package api.dictonary;

public enum DictonaryPriority {
    ONE(1),
    TWO(2),
    TREE(3),
    FOUR(4);

    private int pathPrior;

    DictonaryPriority(int pathApi) {
        this.pathPrior = pathPrior;
    }

    public int getPathPrior() {
        return pathPrior;
    }

}