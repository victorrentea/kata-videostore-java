package videostore.horror;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int rentalsCount) {
        double amount = 1.5;
        if (rentalsCount > 3) {
            amount += (rentalsCount - 3) * 1.5;
        }
        return amount;
    }
}
