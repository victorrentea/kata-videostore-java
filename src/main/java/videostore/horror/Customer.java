package videostore.horror;

import java.util.*;

import static videostore.horror.MovieType.*;

class Customer {
	private final String name;
	private final Map<Movie, Integer> rentals = new LinkedHashMap<>(); // preserves order

	public Customer(String name) {
		this.name = name;
	};

	public void addRental(Movie movie, int rentalDays) {
		rentals.put(movie, rentalDays);
	}


	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + name + "\n";


		for (Movie each : rentals.keySet()) {

			double thisAmount = 0;
			// determine amounts for each line
			int dr = rentals.get(each);
			switch (each.movieType()) {
				case REGULAR:
					thisAmount += 2;
					if (dr > 2)
						thisAmount += (dr - 2) * 1.5;
					break;
				case NEW_RELEASE:
					thisAmount += dr * 3;
					break;
				case CHILDRENS:
					thisAmount += 1.5;
					if (dr > 3)
						thisAmount += (dr - 3) * 1.5;
					break;
			}
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if (each.movieType() == NEW_RELEASE && dr > 1)
				frequentRenterPoints++;
			// show figures line for this rental
			result += "\t" + each.title() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}
}