package videostore.horror;

public record RentedMovie(
    Movie movie,
    int days
) {

  int calculateFrequentRenterPoints() {
    if (movie.category() != null &&
        (movie.category() == Category.NEW_RELEASE)
        && days > 1) {
      return 2;
    }
    return 1;
  }

  public double calculateRentalPrice() {
    double rentalPrice;
    switch (movie().category()) {
      case REGULAR -> {
        rentalPrice = 2;
        if (days > 2)
          rentalPrice += (days - 2) * 1.5;
        return rentalPrice;
      }
      case NEW_RELEASE -> {
        return days * 3;
      }
      case CHILDRENS -> {
        rentalPrice = 1.5;
        if (days > 3)
          rentalPrice += (days - 3) * 1.5;
        return rentalPrice;
      }
      default -> throw new IllegalStateException("Unexpected value: " + movie().category());
    }
  }
}
