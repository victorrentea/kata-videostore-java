package videostore.horror;

import lombok.Getter;

import java.util.*;

class Customer {
	@Getter
	private final String name;
	private final Map<Movie, Integer> rentals = new LinkedHashMap<>(); // preserves order

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Movie m, int d) {
		rentals.put(m, d);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

		for (Map.Entry<Movie, Integer> each: rentals.entrySet()) {
			double thisAmount = 0;
			// determine amounts for each line
			Movie movie = each.getKey();
			Integer rentalsCount = each.getValue();
			thisAmount = movie.calculateAmount(rentalsCount);

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if (movie.getPriceCode() == MoviePriceCode.NEW_RELEASE && rentalsCount > 1) {
				frequentRenterPoints++;
			}
			// show figures line for this rental
			result.append("\t").append(movie.getTitle()).append("\t").append(thisAmount).append("\n");
			totalAmount += thisAmount;
		}
		// add footer lines
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result.toString();
	}
}