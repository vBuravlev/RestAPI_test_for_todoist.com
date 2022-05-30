package api.dictonary;

public enum DictonaryApiV1 {
    TASKS("/rest/v1/tasks"),
    TASK("/rest/v1/tasks/"),
    PROJECTS("/rest/v1/projects"),
    PROJECT("/rest/v1/projects/"),
    CLOSE("/close"),
    REOPEN("/reopen");

    private String pathApi;

    DictonaryApiV1(String pathApi) {
        this.pathApi = pathApi;
    }

    public String getPathApi() {
        return pathApi;
    }

}
