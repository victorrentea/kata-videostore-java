package videostore.horror;

import lombok.Getter;

public record Rental(@Getter Movie movie, @Getter int rentalDays) {

    public String getMovieTitle() {
        return movie.getTitle();
    }

    public double calculateAmount() {
        return movie.getMovieType().calculateAmount(rentalDays);
    }

    public int calculateFrequentRenterPoints() {
        return movie.getMovieType().calculateFrequentRenterPoints(rentalDays);
    }
}
