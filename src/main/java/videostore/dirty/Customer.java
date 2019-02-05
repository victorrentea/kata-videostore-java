package videostore.dirty;
import java.util.Comparator;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Customer {
	private String _name;
	private Vector<IRental> rentals = new Vector<>();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(IRental arg) {
		rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		int frequentRenterPoints = rentals.stream().mapToInt(IRental::getDeltaPoints).sum();

		double totalPrice = rentals.stream().mapToDouble(IRental::getPrice).sum();


		String statementStr = createHeader();
		statementStr += createBody();
		statementStr += createFooter(totalPrice, frequentRenterPoints);
		return statementStr;
	}

	public String statementCuCr323() {
		String rez = statement();
//		for () // chestii in plus
		return rez;
	}

	private String createBody() {
		return rentals.stream().map(this::getStatementStr).collect(Collectors.joining());
	}

	private String createHeader() {
		return "Rental Record for " + _name + "\n";
	}

	private String getStatementStr(IRental rental) {
		return "\t" + rental.getMovie().getTitle() + "\t"
					+ String.valueOf(rental.getPrice()) + "\n";
	}

	//			// aici vrei sa faci ceva altfel pentru UC 322
//			if (cr323) {
//				// si altceva
//			}
	{

		Stream.of(1,2,3,4,5,6,7,8)
				.sorted(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2-o1;
					}
				});
		String s = createFooter(0, 0);
	}

	private String createFooter(double price, int points) {
		return "Amount owed is " + price + "\n" +
				"You earned " + points + " frequent renter points";
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

}