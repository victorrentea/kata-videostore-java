package videostore.horror;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerTest {

    @Test
    public void characterizationTest() {
        Customer customer = new Customer("John Doe");
        customer.addRental(new NewReleaseMovie("Star Wars"), 6);
        customer.addRental(new ChildrenMovie("Sofia"), 7);
        customer.addRental(new RegularMovie("Inception"), 5);
        
        String expected = "Rental Record for John Doe\n"
                + "	Star Wars	18.0\n"
                + "	Sofia	7.5\n"
                + "	Inception	6.5\n"
                + "Amount owed is 32.0\n"
                + "You earned 4 frequent renter points";
        
        assertThat(customer.statement()).isEqualToIgnoringNewLines(expected);
    }
}
