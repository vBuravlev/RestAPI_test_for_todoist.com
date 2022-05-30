package api.dictonary;

public enum DictonaryLanguage {
    EN("en"),
    RU("ru");

    private String pathLang;

    DictonaryLanguage(String pathApi) {
        this.pathLang = pathLang;
    }

    public String getPathLang() {
        return pathLang;
    }

}