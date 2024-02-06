package videostore.horror;

import lombok.Getter;

import java.util.*;

import static videostore.horror.MovieType.NEW_RELEASE;

class Customer {
	@Getter
	private String customerName;
	private final Map<Movie, Integer> movieRentalsDays = new LinkedHashMap<>(); // preserves order

	public Customer(String customerName) {
		this.customerName = customerName;
	};

	public void addRental(Movie movie, int days) {
		movieRentalsDays.put(movie, days);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + getCustomerName() + "\n");

		for (Movie movie : movieRentalsDays.keySet()) {

			double currentAmount = 0;
			// determine amounts for each line
			int rentalDays = movieRentalsDays.get(movie);
			switch (movie.getMovieType()) {
				case REGULAR:
					currentAmount = getCurrentAmountRegularMovie(currentAmount, rentalDays);
					break;
				case NEW_RELEASE:
					currentAmount += rentalDays * 3;
					break;
				case CHILDRENS:
					currentAmount = getCurrentAmountChildrenMovie(currentAmount, rentalDays);
					break;
			}
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two days new release rental
			if (movie.getMovieType() == NEW_RELEASE && rentalDays > 1) {
				frequentRenterPoints++;
			}
			// show figures line for this rental
			result.append("\t").append(movie.getTitle()).append("\t").append(currentAmount).append("\n");
			totalAmount += currentAmount;
		}
		// add footer lines
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result.toString();
	}

	private static double getCurrentAmountChildrenMovie(double currentAmount, int rentalDays) {
		currentAmount += 1.5;
		if (rentalDays > 3)
			currentAmount += (rentalDays - 3) * 1.5;
		return currentAmount;
	}

	private static double getCurrentAmountRegularMovie(double currentAmount, int rentalDays) {
		currentAmount += 2;
		if (rentalDays > 2)
			currentAmount += (rentalDays - 2) * 1.5;
		return currentAmount;
	}
}