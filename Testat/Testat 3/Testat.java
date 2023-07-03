public class Testat {
    public static int apply(int[] arr, int i) {

        // hier ergaenzen
        if (i < arr.length && i > -1) {

            if (arr[i] > 10 && arr[i] % 2 != 0) {
                return apply(arr, i - 1) + 1;
            } else {
                return apply(arr, i - 1) + 0;
            }
        } else {
            return 0;
        }

    }
}