package videostore.horror;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CustomerTest {

    @Test
    void characterizationTest() {
        Customer customer = new Customer("John Doe");
        customer.addRentalToCustomer(new Movie("Star Wars", MovieType.NEW_RELEASE), 6);
        customer.addRentalToCustomer(new Movie("Sofia", MovieType.CHILDREN), 7);
        customer.addRentalToCustomer(new Movie("Inception", MovieType.REGULAR), 5);
        
        String expected = """
                Rental Record for John Doe
                	Star Wars	18.0
                	Sofia	7.5
                	Inception	6.5
                Amount owed is 32.0
                You earned 4 frequent renter points""";
        
        assertThat(customer.getCustomerInfo()).isEqualToIgnoringNewLines(expected);
    }
}
