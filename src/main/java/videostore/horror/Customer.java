package videostore.horror;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

class Customer {
	@Getter
	private final String customerName;
	private final List<Rental> movieRentals = new ArrayList<>();

	public Customer(String customerName) {
		this.customerName = customerName;
	};

	public void addRental(Rental rental) {
		movieRentals.add(rental);
	}

	public String statement() {
    return StatementGenerator.generate(customerName, movieRentals);
	}

}