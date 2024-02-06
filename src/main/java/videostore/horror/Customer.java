package videostore.horror;

import lombok.Getter;

import java.util.*;

class Customer {
	@Getter
	private final String name;
	private final List<Rental> rentals = new ArrayList<>(); // preserves order

	public Customer(String name) {
		this.name = name;
	}

	public void addRentalToCustomer(Movie movie, int daysRented) {
		Rental rental = new Rental(movie, daysRented);
		rentals.add(rental);

	}

	public String getCustomerInfo() {
		StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");
		int frequentRenterPoints=0;
		double totalAmount=0;
		for (Rental movieRental : rentals) {
			frequentRenterPoints += movieRental.getFrequentPoints();
			totalAmount += movieRental.getPrice();
			result.append("\t").append(movieRental.getMovie().title()).append("\t").append(movieRental.getPrice()).append("\n");
		}

		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result.toString();
	}



}
