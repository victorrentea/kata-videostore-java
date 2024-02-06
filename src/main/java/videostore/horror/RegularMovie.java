package videostore.horror;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int rentalsCount) {
        double amount = 2;
        if (rentalsCount > 2) {
            amount += (rentalsCount - 2) * 1.5;
        }
        return amount;
    }
}
