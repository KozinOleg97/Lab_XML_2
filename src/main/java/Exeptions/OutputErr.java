package Exeptions;

public class OutputErr extends Exception {

    public OutputErr(String message, String path, Object data) {
        super(message);
        this.path = path;
        this.data = data;
    }


    private String path;
    private Object data;

    public String getPath() {
        return path;
    }


    public Object getData() {
        return data;
    }
}
