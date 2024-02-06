package videostore.horror;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerTest {

    @Test
    public void characterizationTest() {
        Customer customer = new Customer("John Doe");
        final Movie star_wars = new Movie("Star Wars", MovieType.NEW_RELEASE);
        customer.addRental(new Rental(star_wars, 6));
        final Movie sofia = new Movie("Sofia", MovieType.CHILDREN);
        customer.addRental(new Rental(sofia, 7));
        final Movie inception = new Movie("Inception", MovieType.REGULAR);
        customer.addRental(new Rental(inception, 5));
        
        String expected = "Rental Record for John Doe\n"
                + "	Star Wars	18.0\n"
                + "	Sofia	7.5\n"
                + "	Inception	6.5\n"
                + "Amount owed is 32.0\n"
                + "You earned 4 frequent renter points";
        
        assertThat(customer.statement()).isEqualToIgnoringNewLines(expected);
    }
}
