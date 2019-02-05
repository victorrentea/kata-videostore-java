package videostore.dirty;
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
		String result = "Rental Record for " + _name + "\n";

		for(Rental rental:this.rentals) {
			double price = rental.getPrice();
			frequentRenterPoints += rental.getDeltaPoints();
			result += getStatementLine(rental, price);
			totalAmount += price;
		}

		result += createFooterLines(totalAmount, frequentRenterPoints);

		return result;
	}

	//	{
//		List<String> errorListToAddTo = new ArrayList<>();
//
//		errorListToAddTo.addAll(oMetoda(new Object()));
//	}
//	private List<String> oMetoda(Object deValidat) {
//		List<String> errorListToAddTo = new ArrayList<>();
//		if (caz nashpa) {
//			errorListToAddTo.add("Nashpa");
//		}
//		return errorListToAddTo;
//	}

	private String createFooterLines(double totalAmount, int frequentRenterPoints) {
		return "Amount owed is " + totalAmount + "\n" +
				"You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
	}

	private String getStatementLine(Rental rental, double price) {
		return "\t" + rental.getMovie().getTitle() + "\t"
				+ String.valueOf(price) + "\n";
	}

}