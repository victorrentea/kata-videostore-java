package videostore.horror;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

class Customer {
	@Getter
	private final String name;
	private final Map<Movie, Integer> rentals = new LinkedHashMap<>(); // preserves order

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Movie movie, int rentalDays) {
		rentals.put(movie, rentalDays);
	}

	public String statement() {
//		double totalAmount = 0;
//		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

		double totalAmount = rentals.entrySet().stream()
				.mapToDouble(each -> each.getKey().calculateAmount(each.getValue()))
				.sum();

		int frequentRenterPoints = rentals.entrySet().stream()
				.mapToInt(each -> each.getKey().getFrequentRenterBonus(each.getValue()))
				.sum();


		for (Map.Entry<Movie, Integer> each: rentals.entrySet()) {
			Movie movie = each.getKey();
            double thisAmount = movie.calculateAmount(each.getValue());
			result.append("\t").append(movie.getTitle()).append("\t").append(thisAmount).append("\n");
		}

		// add footer lines
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result.toString();
	}
}
