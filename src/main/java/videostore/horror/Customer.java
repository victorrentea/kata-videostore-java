package videostore.horror;

import java.util.*;

import static videostore.horror.MovieType.*;

class Customer {
	private final String name;
	private final List<Rental> rentals = new ArrayList<>(); // preserves order

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Movie movie, int rentalDays) {
		rentals.add(new Rental(movie,rentalDays));
	}


	public StringBuilder statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

		for (Rental rental : rentals) {
			// determine amounts for each line
			double amountToPay = rental.calculatePayment();
			// show figures line for this rental
			result.append("\t").append(rental.movie().title()).append("\t").append(amountToPay).append("\n");
			totalAmount += amountToPay;
			frequentRenterPoints += rental.calculateFrequentRenterPoints();
		}
		// add footer lines
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result;
	}
}