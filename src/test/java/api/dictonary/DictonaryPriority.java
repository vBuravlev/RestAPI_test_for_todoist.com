package api.dictonary;

public enum DictonaryPriority {
    ONE(1),
    TWO(2),
    TREE(3),
    FOUR(4);

    private int pathApi;

    DictonaryPriority (int pathApi) {
        this.pathApi=pathApi;
    }

    public int getPathApi() {
        return pathApi;
    }

}