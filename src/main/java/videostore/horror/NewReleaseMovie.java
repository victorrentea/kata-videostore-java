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
    public int getFrequentRenterBonus(int rentalsCount) {
        if (rentalsCount > 1) {
            return 1;
        }
        return 0;
    }
}
