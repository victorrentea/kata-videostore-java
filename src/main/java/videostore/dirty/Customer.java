package videostore.dirty;
import java.util.Enumeration;
import java.util.Vector;

class Customer {
	private String _name;
	private Vector<Rental> rentals = new Vector<>();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";

		for(Rental rental:this.rentals) {
			double price = getPrice(rental);
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& rental.getDaysRented() > 1)
				frequentRenterPoints++;

			result += getStatementLine(rental, price);

			totalAmount += price;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

	private String getStatementLine(Rental rental, double price) {
		return "\t" + rental.getMovie().getTitle() + "\t"
				+ String.valueOf(price) + "\n";
	}

	private double getPrice(Rental rental) {
		double price = 0;
		// determine amounts for each line
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			price += 2;
			if (rental.getDaysRented() > 2)
				price += (rental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			price += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			price += 1.5;
			if (rental.getDaysRented() > 3)
				price += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return price;
	}
}