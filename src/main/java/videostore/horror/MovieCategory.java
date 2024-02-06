package videostore.horror;

public enum MovieCategory {
    REGULAR(0),
    CHILDREN(2),
    NEW_RELEASE(1);

    private final int code;

    MovieCategory(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
