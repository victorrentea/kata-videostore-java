package videostore.horror;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(Integer rentalsCount) {
        return rentalsCount * 3;
    }

    @Override
    public int getFrequentRenterBonus(int rentalDays) {
        return (rentalDays > 1) ? 2 : 1;
    }
}
