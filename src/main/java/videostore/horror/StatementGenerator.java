package videostore.horror;

import java.util.List;
import java.util.stream.Collectors;

public class StatementGenerator {

  public static String generate(String customerName, List<Rental> rentals) {
    return formatHeader(customerName) + formatBody(rentals) + formatFooter(rentals);
  }

  private static String formatBody(List<Rental> rentals) {
    return rentals.stream().map(StatementGenerator::formatBodyLine).collect(Collectors.joining());
  }

  private static String formatBodyLine(Rental rental) {
    return "\t" + rental.getMovieTitle() + "\t" + rental.calculateAmount() + "\n";
  }

  private static String formatHeader(String customerName) {
    return "Rental Record for " + customerName + "\n";
  }

  private static String formatFooter(List<Rental> rentals) {
    return "Amount owed is %s\nYou earned %d frequent renter points".formatted(totalPrice(rentals), totalPoints(rentals));
  }

  private static double totalPrice(List<Rental> rentals) {
    return rentals.stream().mapToDouble(Rental::calculateAmount).sum();
  }

  private static int totalPoints(List<Rental> rentals) {
    return rentals.stream().mapToInt(Rental::calculateFrequentRenterPoints).sum();
  }
}

