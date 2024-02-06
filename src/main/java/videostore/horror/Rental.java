package videostore.horror;

public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double calculateRentalCost() {
        MovieCategory category = getCategoryFromCode(movie.priceCode());
        return switch (category) {
            case REGULAR -> calculateRental(2, 1.5, 2);
            case NEW_RELEASE -> calculateRental(0, 3, 0);
            case CHILDREN -> calculateRental(1.5, 1.5, 3);
        };
    }

    private MovieCategory getCategoryFromCode(int code) {
        for (MovieCategory category : MovieCategory.values()) {
            if (category.getCode() == code) {
                return category;
            }
        }
        throw new IllegalStateException("Invalid movie category code: " + code);
    }

    private double calculateRental(double baseAmount, double additionalRate, int additionalDays) {
        double rentalAmount = baseAmount;
        if (daysRented > additionalDays) {
            rentalAmount += (daysRented - additionalDays) * additionalRate;
        }
        return rentalAmount;
    }

    public int calculateFrequentRenterPoints() {
        return (movie.priceCode() == MovieCategory.NEW_RELEASE.getCode() && daysRented > 1) ? 2 : 1;
    }

    public String getRentalStatement() {
        return "\t" + movie.title() + "\t" + calculateRentalCost() + "\n";
    }
}
