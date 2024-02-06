package videostore.horror;

public record CustomerMovieRental(Movie movie, int rentalDays) {
    public double calculateAmount() {
        return movie.calculateAmount(rentalDays);
    }

    public int getFrequentRenterBonus() {
        return movie.getFrequentRenterBonus(rentalDays);
    }
}
