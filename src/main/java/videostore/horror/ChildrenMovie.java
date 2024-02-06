package videostore.horror;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(Integer rentalsCount) {
        double sum = 1.5;
        if (rentalsCount > 3) {
            sum += (rentalsCount - 3) * 1.5;
        }
        return sum;
    }
}
