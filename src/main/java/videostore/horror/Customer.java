package videostore.horror;

import java.util.*;

class Customer {
	private final String name;
//	private final Map<RentedMovie, Integer> rentals = new LinkedHashMap<>(); // preserves order
	private final List<RentedMovie> rentedMovies = new LinkedList<>(); // preserves order


	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Movie movie, int days) {
		RentedMovie rm = new RentedMovie(movie, days);
		rentedMovies.add(rm);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + name + "\n";

		for (RentedMovie rentedMovie : rentedMovies) {
			// determine amounts for movie line
			Movie movie = rentedMovie.movie();
			int daysRental = rentedMovie.days();
			double thisAmount = calculateThisAmount(movie, daysRental);
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release movie
			if (movie.category() != null &&
				 (movie.category() == Category.NEW_RELEASE)
				 && daysRental > 1)
				frequentRenterPoints++;
			// show figures line for this movie
			result += "\t" + movie.title() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}

	private double calculateThisAmount(Movie rental, int days) {
		double thisAmount = 0;
		switch (rental.category()) {
			case REGULAR:
				thisAmount = 2;
				if (days > 2)
					thisAmount += (days - 2) * 1.5;
				return thisAmount;
			case NEW_RELEASE:
				return days * 3;
			case CHILDRENS:
				thisAmount = 1.5;
				if (days > 3)
					thisAmount += (days - 3) * 1.5;
				return thisAmount;
		}
		return thisAmount;
	}
}