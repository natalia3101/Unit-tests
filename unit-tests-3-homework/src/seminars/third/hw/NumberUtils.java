package seminars.third.hw;

public class NumberUtils {
    public boolean evenOddNumber(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean numberInInterval(int number) {
        return number > 25 && number < 100;
    }
}
