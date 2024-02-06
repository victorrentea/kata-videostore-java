package videostore.horror;

import lombok.Getter;

@Getter
public class Rental {

    private final double price;
    private final Movie movie;
    private final int days;
    private final int frequentPoints;

    public Rental (Movie movie, int days) {
        this.movie = movie;
        this.days = days;
        this.price = calculatePrice(movie, days);
        this.frequentPoints = calculateFrequentRenterPoints(movie, days);
    }

    static double calculatePrice(Movie movie, int daysRented) {
        double thisAmount = 0;
        switch (movie.movieType()) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case CHILDREN:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    private static int calculateFrequentRenterPoints(Movie movie, int daysRented) {
        // add frequent renter points
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if (movie.movieType() == MovieType.NEW_RELEASE && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
