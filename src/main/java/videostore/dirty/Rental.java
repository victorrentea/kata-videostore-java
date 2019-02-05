package videostore.dirty;
class Rental implements IRental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	@Override
	public int getDaysRented() {
		return daysRented;
	}

	@Override
	public Movie getMovie() {
		return movie;
	}

	@Override
	public boolean isNewRelease() {
		return movie.getPriceCode() == Movie.NEW_RELEASE;
	}

	@Override
	public double getPrice() {
		double price = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			price += 2;
			if (daysRented > 2)
				price += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			price += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			price += 1.5;
			if (daysRented > 3)
				price += (daysRented - 3) * 1.5;
			break;
		}
		return price;
	}

	@Override
	public int getDeltaPoints() {
		int deltaPoints = 1;

		boolean isNewRelease = isNewRelease();
		if (isNewRelease && getDaysRented() > 1) {
			deltaPoints++;
		}
		return deltaPoints;
	}
}