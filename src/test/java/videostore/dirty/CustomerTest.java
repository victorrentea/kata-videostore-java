package videostore.dirty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerTest {

    @Test
    public void characterizationTest() {
        Customer customer = new Customer("John Doe");
        customer.addRental(new Rental(new Movie("Star Wars", Movie.CATEGORY_NEW_RELEASE), 6));
        customer.addRental(new Rental(new Movie("Sofia", Movie.CATEGORY_CHILDRENS), 7));
        customer.addRental(new Rental(new Movie("Inception", Movie.CATEGORY_REGULAR), 5));
        
        String expected = "Rental Record for John Doe\n"
                + "	Star Wars	18.0\n"
                + "	Sofia	7.5\n"
                + "	Inception	6.5\n"
                + "Amount owed is 32.0\n"
                + "You earned 4 frequent renter points";

        assertThat(customer.statement()).isEqualToIgnoringNewLines(expected);
    }
}
