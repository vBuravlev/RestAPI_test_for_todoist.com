package api.dictonary;

public enum DictonaryLanguage {
    EN("en"),
    RU("ru");

    private String pathApi;

    DictonaryLanguage (String pathApi) {
        this.pathApi=pathApi;
    }

    public String getPathApi() {
        return pathApi;
    }

}