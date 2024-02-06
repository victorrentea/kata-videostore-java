package videostore.horror;

import java.util.*;

import static videostore.horror.MovieType.*;

class Customer {
	private final String name;
	private final Map<Movie, Integer> rentals = new LinkedHashMap<>(); // preserves order

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Movie movie, int rentalDays) {
		rentals.put(movie, rentalDays);
	}


	public StringBuilder statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");


		for (Movie movie : rentals.keySet()) {

			// determine amounts for each line
			int rentalDays = rentals.get(movie);
			double amountToPay = movie.movieType().calculatePayment(rentalDays);

			// show figures line for this rental
			result.append("\t").append(movie.title()).append("\t").append(amountToPay).append("\n");

			totalAmount += amountToPay;

			frequentRenterPoints += getFrequentRenterPoints(movie.movieType(), rentalDays);
		}
		// add footer lines
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result;
	}

	private static int getFrequentRenterPoints(MovieType movieType, int rentalDays) {
		boolean eligibleForBonus = movieType == NEW_RELEASE && rentalDays > 1;
		if (eligibleForBonus) {
			return 2;
		}
        return 1;
    }

}