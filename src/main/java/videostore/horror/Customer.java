package videostore.horror;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Customer {
    @Getter
    private final String name;
    private final List<CustomerMovieRental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Movie movie, int rentalDays) {
        rentals.add(new CustomerMovieRental(movie, rentalDays));
    }

    public String statement() {
        return createStatementHeader() + createStatementBody() + createStatementFooter();
    }

    private String createStatementHeader() {
        return "Rental Record for " + name + "\n";
    }

    private String createStatementFooter() {
        return "Amount owed is " + calculateTotalAmount() + "\n" + "You earned " + calculateFrequentRenterPoints() + " frequent renter points";
    }

    private int calculateFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(CustomerMovieRental::getFrequentRenterBonus)
                .sum();
    }

    private double calculateTotalAmount() {
        return rentals.stream()
                .mapToDouble(CustomerMovieRental::calculateAmount)
                .sum();
    }

    private String createStatementBody() {
        return rentals.stream()
                .map(movieRental -> "\t" + movieRental.movie().getTitle() + "\t" + movieRental.calculateAmount() + "\n")
                .collect(Collectors.joining());
    }
}
