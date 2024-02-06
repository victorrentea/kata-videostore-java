package videostore.horror;

import java.util.List;

public class RentalCalculator {

    public static String generateRentalStatement(List<Rental> movieRentalsDays) {
        StringBuilder result = new StringBuilder();
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental rental : movieRentalsDays) {
            result.append("\t").append(rental.getMovieTitle()).append("\t").append(rental.calculateAmount()).append("\n");

            frequentRenterPoints += rental.calculateFrequentRenterPoints();
            totalAmount += rental.calculateAmount();
        }
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }
}

