package videostore.horror;

import lombok.Getter;

public record Rental(@Getter Movie movie, @Getter int rentalDays) {

    public String getMovieTitle() {
        return movie.title();
    }

    public double calculateAmount() {
        return movie.movieType().calculateAmount(rentalDays);
    }

    public int calculateFrequentRenterPoints() {
        return movie.movieType().calculateFrequentRenterPoints(rentalDays);
    }
}
