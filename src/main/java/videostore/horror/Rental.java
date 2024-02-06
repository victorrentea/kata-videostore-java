package videostore.horror;

import static videostore.horror.MovieType.NEW_RELEASE;

public record Rental(Movie movie, int days) {
    public double calculatePayment() {
        return movie.movieType().calculatePayment(days);
    }
    public int calculateFrequentRenterPoints(){
        boolean eligibleForBonus = movie.movieType() == NEW_RELEASE && days > 1;
        if (eligibleForBonus) {
            return 2;
        }
        return 1;
    }
}
