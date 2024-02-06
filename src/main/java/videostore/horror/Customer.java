package videostore.horror;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Customer {
    @Getter
    private final String name;
    private final List<CustomerMovieRental> rentals = new ArrayList<>(); // preserves order


    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Movie movie, int rentalDays) {
        rentals.add(new CustomerMovieRental(movie, rentalDays));
    }

    public String statement() {
        return "Rental Record for " + name + "\n" + createStatementBody() + createStatementFooter();
    }

    private String createStatementFooter() {
        double totalAmount = rentals.stream()
                .mapToDouble(CustomerMovieRental::calculateAmount)
                .sum();

        int frequentRenterPoints = rentals.stream()
                .mapToInt(CustomerMovieRental::getFrequentRenterBonus)
                .sum();

        return "Amount owed is " + totalAmount + "\n" +
                "You earned " + frequentRenterPoints + " frequent renter points";
    }

    private String createStatementBody() {
        return rentals.stream().map(movieRental -> {
            double thisAmount = movieRental.calculateAmount();
            return "\t" + movieRental.movie().getTitle() + "\t" + thisAmount + "\n";
        }).collect(Collectors.joining());
    }
}
