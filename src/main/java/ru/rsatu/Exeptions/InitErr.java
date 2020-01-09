package ru.rsatu.Exeptions;

public class InitErr extends Exception {

    public InitErr(String message, String path) {
        super(message);
        this.path = path;
    }

    public InitErr(String message) {
        super(message);
    }



    public InitErr(String message, String path, String path2) {
        super(message);
        this.path = path;
        this.path2 = path2;
    }

    public String getPath2() { return path2; }
    public String getPath() {
        return path;
    }

    private String path = null;
    private String path2 = null;

}
