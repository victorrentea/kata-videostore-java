package videostore.horror;

import java.util.*;
import java.util.stream.Collectors;


class Customer {
	private final String name;
	private final List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}


	public StringBuilder statement() {
		StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

		result.append(rentals.stream()
				.map(rental -> {
					double amountToPay = rental.calculatePayment();
					return "\t" + rental.movie().title() + "\t" + amountToPay;
				})
				.collect(Collectors.joining("\n")));
		// determine amounts for each line
		double totalAmount = rentals.stream().mapToDouble(Rental::calculatePayment).sum();
		int frequentRenterPoints = rentals.stream().mapToInt(Rental::calculateFrequentRenterPoints).sum();
		// add footer lines
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result;
	}
}