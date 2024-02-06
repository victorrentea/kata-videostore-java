package videostore.horror;

import java.util.*;

class Customer {
	private final String name;
	private final List<RentedMovie> rentedMovies = new LinkedList<>(); // preserves order


	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Movie movie, int days) {
		rentedMovies.add( new RentedMovie(movie, days));
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + name + "\n";

		for (RentedMovie rentedMovie : rentedMovies) {
			// determine amounts for movie line
			Movie movie = rentedMovie.movie();
			double rentalPrice = rentedMovie.calculateRentalPrice();
			frequentRenterPoints += rentedMovie.calculateFrequentRenterPoints();
			// show figures line for this movie
			result += ("\t" + movie.title() + "\t" + rentalPrice + "\n");
			totalAmount += rentalPrice;
		}
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}

}