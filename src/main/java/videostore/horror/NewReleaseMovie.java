package videostore.horror;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int rentalsCount) {
        return rentalsCount * 3d;
    }

    @Override
    public int getFrequentRenterBonus(int rentalDays) {
        return (rentalDays > 1) ? 2 : 1;
    }
}
