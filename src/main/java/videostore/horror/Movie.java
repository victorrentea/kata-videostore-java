package videostore.horror;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Movie {
    private final String title;

    public abstract double calculateAmount(int rentalsCount);

    public int getFrequentRenterBonus(int rentalDays) {
        return 1;
    }
}
