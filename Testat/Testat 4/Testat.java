public class Testat {
    public static Fraction apply(Fraction[] arr, Fraction f, int i) {

        // hier ergaenzen

        if (i < 0 || i >= arr.length) {
            return new Fraction(-2);
        } else {

            Fraction res;
            if (arr[i].subtract(f).toDouble() > 0.0) {
                res = arr[i];
            } else {
                res = new Fraction(0);
            }
            if (i == 0) {
                return res;
            } else {
                return res.add(apply(arr, f, i - 1));
            }

        }

    }
}