package videostore.horror;

import lombok.Getter;

public record Rental(@Getter Movie movie, @Getter int rentalDays) {

    public String getMovieTitle() {
        return movie.title();
    }

    public double calculateAmount() {
//        return movie.movieType().calculateAmount(rentalDays);
        return switch (movie.movieType()) {
            case REGULAR -> 2 + (rentalDays > 2 ? (rentalDays - 2) * 1.5 : 0);
            case NEW_RELEASE -> rentalDays * 3;
            case CHILDRENS -> 1.5 + (rentalDays > 3 ? (rentalDays - 3) * 1.5 : 0);
        };
    }

    public int calculateFrequentRenterPoints() {
        return movie.movieType().calculateFrequentRenterPoints(rentalDays);
    }
}
