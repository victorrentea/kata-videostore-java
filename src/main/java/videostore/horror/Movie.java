package videostore.horror;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Movie {
    private final String title;
    private final MoviePriceCode priceCode;

    public abstract double calculateAmount(Integer rentalsCount);
}