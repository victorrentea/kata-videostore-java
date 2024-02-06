package videostore.horror;

public class RegularMovie extends Movie {
    public RegularMovie(String title, MoviePriceCode priceCode) {
        super(title, priceCode);
    }

    @Override
    public double calculateAmount(Integer rentalsCount) {
        double sum = 2;
        if (rentalsCount > 2) {
            sum += (rentalsCount - 2) * 1.5;
        }
        return sum;
    }
}
