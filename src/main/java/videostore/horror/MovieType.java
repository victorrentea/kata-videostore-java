package videostore.horror;

public enum MovieType implements MovieTypeAction {
    REGULAR {
        @Override
        public double calculatePayment(int rentalDays) {
            double thisAmount = 2;
            if (rentalDays > 2)
                thisAmount += (rentalDays - 2) * 1.5;
            return thisAmount;
        }
    },
    NEW_RELEASE {
        @Override
        public double calculatePayment(int rentalDays) {
            return rentalDays * 3d;
        }
    },
    CHILDREN {
        @Override
        public double calculatePayment(int rentalDays) {
            double thisAmount = 1.5;
            if (rentalDays > 3)
                thisAmount += (rentalDays - 3) * 1.5;
            return thisAmount;
        }
    }
}
