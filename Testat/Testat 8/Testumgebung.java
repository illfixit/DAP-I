public class Testumgebung {
    public static void main(String[] args) {
        IntIntPairs testPairs = new IntIntPairs(20);
        testPairs.put(7, 3);
        testPairs.put(4, 3);
        testPairs.put(1, -9);
        testPairs.put(6, 6);
        testPairs.put(41, 12);
        testPairs.put(9, -11);
        testPairs.put(8, 12);
        testPairs.put(5, -60);
        testPairs.put(14, 18);
        testPairs.put(0, 12);
        testPairs.put(-9, -16);
        testPairs.put(0, 0);
        testPairs.put(17, 32);
        testPairs.put(1, 1);
        System.out.println("Paare fuer Test: ");
        testPairs.show();
        System.out.println();

        System.out.println("Test fuer makeInt - Ergebniswert ist:");
        System.out.println(LambdaMethods.makeInt(testPairs));
        System.out.println();
        System.out.println("Test fuer makePairs - Ergebnispaare sind: ");
        LambdaMethods.makePairs(testPairs).show();
        System.out.println();
        System.out.println("Test fuer apply - geaenderte Paare: ");
        LambdaMethods.apply(testPairs);
        testPairs.show();
        System.out.println();

    }
}
