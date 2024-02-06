package videostore.horror;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title, MoviePriceCode priceCode) {
        super(title, priceCode);
    }

    @Override
    public double calculateAmount(Integer rentalsCount) {
        return rentalsCount * 3;
    }
}
