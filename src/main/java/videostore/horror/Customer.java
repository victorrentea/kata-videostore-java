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
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + name + "\n";

		for (Rental movieRental : rentals) {
			// determine amounts for movie line
			int daysRented = movieRental.days();
			double thisAmount = calculatePrice(movieRental.movie(), daysRented);
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if (movieRental.movie().movieType() == MovieType.NEW_RELEASE && daysRented > 1)
				frequentRenterPoints++;
			// show figures line for this rental
			result += "\t" + movieRental.movie().title() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}

	private static double calculatePrice(Movie movie, int daysRented) {
		double thisAmount = 0;
		switch (movie.movieType()) {
			case REGULAR:
				thisAmount += 2;
				if (daysRented > 2)
					thisAmount += (daysRented - 2) * 1.5;
				break;
			case NEW_RELEASE:
				thisAmount += daysRented * 3;
				break;
			case CHILDREN:
				thisAmount += 1.5;
				if (daysRented > 3)
					thisAmount += (daysRented - 3) * 1.5;
				break;
		}
		return thisAmount;
	}
}
