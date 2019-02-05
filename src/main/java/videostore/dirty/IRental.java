package videostore.dirty;

public interface IRental {
    int getDaysRented();

    Movie getMovie();

    boolean isNewRelease();

    double getPrice();

    int getDeltaPoints();
}
