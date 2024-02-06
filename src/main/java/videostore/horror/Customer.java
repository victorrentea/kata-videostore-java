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

	public void addRental(Movie movie, int daysRented) {
		rentals.add(new Rental(movie,daysRented));
	}

	public String statement() {
		double totalAmount = 0;
		String result = "Rental Record for " + name + "\n";
		int frequentRenterPoints = 0;
		for (Rental movieRental : rentals) {
			frequentRenterPoints += movieRental.getFrequentPoints();
			// show figures line for this rental
			result += "\t" + movieRental.getMovie().title() + "\t" + movieRental.getPrice() + "\n";
			totalAmount += movieRental.getPrice();
		}
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}



}
