package videostore.horror;

public enum MovieType {

    REGULAR(0),
    NEW_RELEASE(1),
    CHILDREN (2);
    private final int priceCode;

    MovieType(int price) {
        priceCode = price;
    }

    public int getPriceCode() {
        return priceCode;
    }
}


