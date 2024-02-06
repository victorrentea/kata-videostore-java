package videostore.horror;

enum MovieType {
    REGULAR {
        @Override
        public double calculateAmount(int rentalDays) {
            double amount = 2;
            if (rentalDays > 2)
                amount += (rentalDays - 2) * 1.5;
            return amount;
        }

        @Override
        public int calculateFrequentRenterPoints(int rentalDays) {
            return 1;
        }
    },
    NEW_RELEASE {
        @Override
        public double calculateAmount(int rentalDays) {
            return rentalDays * 3;
        }

        @Override
        public int calculateFrequentRenterPoints(int rentalDays) {
            return (rentalDays > 1) ? 2 : 1;
        }
    },
    CHILDRENS {
        @Override
        public double calculateAmount(int rentalDays) {
            double amount = 1.5;
            if (rentalDays > 3)
                amount += (rentalDays - 3) * 1.5;
            return amount;
        }

        @Override
        public int calculateFrequentRenterPoints(int rentalDays) {
            return 1;
        }
    };

    public abstract double calculateAmount(int rentalDays);

    public abstract int calculateFrequentRenterPoints(int rentalDays);
}