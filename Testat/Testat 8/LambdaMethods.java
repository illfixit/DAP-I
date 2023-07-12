public class LambdaMethods {

    public static int makeInt(IntIntPairs p) {
        // Methode nicht loeschen und compilierbar ergaenzen
        return p.accumulate((k, v) -> {
            if (k == 0) {
                return 1;
            } else {
                return 0;
            }
        });
    }

    public static IntIntPairs makePairs(IntIntPairs p) {
        // Methode nicht loeschen und compilierbar ergaenzen
        return p.extract((k, v) -> k > 0);

    }

    public static void apply(IntIntPairs p) {
        // hier ergaenzen
        // Methode nicht loeschen
        p.manipulate((k, v) -> k * 5, (k, v) -> v);

    }

}
