package videostore.horror;

import java.util.*;
import java.util.stream.Collectors;

class Customer {
	private final String name;
	private final List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Movie movie, int daysRented) {
		rentals.add(new Rental(movie, daysRented));
	}
	public String generateRentalStatement() {
		double totalAmount = rentals.stream()
				.mapToDouble(Rental::calculateRentalCost)
				.sum();
		int frequentRenterPoints = rentals.stream()
				.mapToInt(Rental::calculateFrequentRenterPoints)
				.sum();
		StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");
		String rentalStatements = rentals.stream()
				.map(Rental::getRentalStatement)
				.collect(Collectors.joining());
		result.append(rentalStatements);
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result.toString();
	}
}