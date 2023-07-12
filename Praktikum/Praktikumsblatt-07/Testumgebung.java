public class Testumgebung {
    public static void main(String[] args) {
        IntIntPairs testPairs = new IntIntPairs(20);
        testPairs.put(7, 3);
        testPairs.put(4, 3);
        testPairs.put(1, -9);
        testPairs.put(6, 6);
        testPairs.put(2, 8);
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
        testPairs.show();
        System.out.println();

        weiter(testPairs);

        // System.out.println("Beispiel: " + testPairs.accumulate((k, v) -> {
        // if (k == 0) {
        // return v;
        // } else {
        // return 0;
        // }
        // }));
        // System.out.println("# even key: " + testPairs.accumulate((k, v) -> {
        // if (k % 2 == 0) {
        // return 1;
        // } else {
        // return 0;
        // }
        // }));
        // System.out.println("# value > 10: " + testPairs.accumulate((k, v) -> {
        // if (v > 10) {
        // return 1;
        // } else {
        // return 0;
        // }
        // }));
        // System.out.println("sum of all values: " + testPairs.accumulate((k, v) ->
        // v));
        // System.out.print("all keys +10: ");
        // testPairs.manipulate((k, v) -> k + 10, (k, v) -> v);
        // testPairs.show();
        // System.out.println();
        // System.out.print("some keys +5: ");
        // testPairs.manipulate((k, v) -> {
        // if (v > 3) {
        // return k + 5;
        // } else {
        // return k;
        // }
        // }, (k, v) -> v);
        // testPairs.show();
        // System.out.println();
        // System.out.print("all values *2: ");
        // testPairs.manipulate((k, v) -> k, (k, v) -> 2 * v);
        // testPairs.show();
        // System.out.println();
        // testPairs.put(8, 8);
        // testPairs.put(-2, -2);
        // System.out.print("remove k==v: ");
        // testPairs.remove((k, v) -> k == v);
        // testPairs.show();
        // System.out.println();
        // System.out.print("remove 6: ");
        // testPairs.remove((k, v) -> k == 6);
        // testPairs.show();
        // System.out.println();
        // System.out.print("remove negative values: ");
        // testPairs.remove((k, v) -> v < 0);
        // testPairs.show();
        // System.out.println();
        // System.out.print("copy: ");
        // IntIntPairs otherPairs = testPairs.extract((k, v) -> true);
        // otherPairs.show();
        // System.out.println();
        // System.out.print("extract multiples of 3: ");
        // otherPairs = testPairs.extract((k, v) -> v % 3 == 0);
        // otherPairs.show();
        // System.out.println();
        // System.out.print("extract values >5: ");
        // otherPairs = testPairs.extract((k, v) -> v > 5);
        // otherPairs.show();
        // System.out.println();
        // System.out.print("sumUp: " + sumUp(testPairs));
        // System.out.println();
        // System.out.print("add 4 to value: ");
        // addNToValue(testPairs, 4);
        // testPairs.show();
        // System.out.println();
        // System.out.print("unique 17: " + uniqueKey(testPairs, 17));
        // System.out.println();
        // System.out.print("unique 14: " + uniqueKey(testPairs, 14));
        // System.out.println();
        // System.out.print("double >20: ");
        // doubleGreaterN(testPairs, 20);
        // testPairs.show();
        // System.out.println();
        // testPairs.show();
        // otherPairs.show();
        // concat(testPairs, otherPairs).show();
        // System.out.println();

        // System.out.println("Beispiel: " + testPairs.accumulate((k, v) -> {
        // if (k == 0) {
        // return v;
        // } else {
        // return 0;
        // }
        // }));

        // System.out.print("Beispiel: " + sumUp(testPairs));
        // System.out.println();

    }

    public static void weiter(IntIntPairs pairs) {

        // 1. Ermittle für alle gültigen Einträge des Wertes 0 in keys die
        // Summe der zugehörigen Werte in values. Die Lösung dieser Aufgabe
        // findest Du als Beispiel in der Testumgebung. Bestimme die Anzahl
        // der gültigen geraden Werte in keys.

        System.out.println("1-1a " + pairs.accumulate((k, v) -> {
            if (k == 0) {
                return v;
            } else {
                return 0;
            }
        }));

        System.out.println("1-1b " + pairs.accumulate((k, v) -> {
            if (k == 0) {
                return 1;
            } else {
                return 0;
            }
        }));

        // 2. Lösche alle gültigen Paare, deren Wert
        // in keys gleich dem Wert 6 ist.
        pairs.remove((k, v) -> k == 6);
        pairs.show();

        // 3. Erhöhe jeden gültigen Wert
        // in keys um den Wert 10.
        pairs.manipulate((k, v) -> k + 10, (k, v) -> v);
        pairs.show();

        // 4. Erstelle ein IntIntPairs-Objekt, das Kopien
        // aller gültigenPaare enthält, deren Wert in
        // values ganzzahlig durch 3 teilbar ist.
        IntIntPairs newPairs = pairs.extract((k, v) -> v % 3 == 0);
        newPairs.show();

        // 5. Bestimme die Anzahl dergültigen Werte
        // in values, die größer als 10 sind.
        System.out.println(pairs.accumulate((k, v) -> v > 10 ? 1 : 0));

        // 6. Erhöhe die Werte in keys um den Wert 5, deren
        // zugehöriger Wert in values größer als 3 ist.
        pairs.manipulate((k, v) -> v > 3 ? k + 5 : k, (k, v) -> v);
        pairs.show();

        // 7. Lösche alle gültigen Paare, die einen negativen
        // Wert in values besitzen.
        pairs.remove((k, v) -> v < 0);
        pairs.show();

        // 8. Verdopple jeden gültigen Wert in values.
        pairs.manipulate((k, v) -> k, (k, v) -> v * 2);
        pairs.show();

        // 9. Erstelle eine Kopie des IntIntPairs-Objekts,
        // das alle gültigen Paare enthält.
        IntIntPairs IIPKopie1 = pairs.extract((k, v) -> true);
        IIPKopie1.show();

        // 10. Lösche alle gültigen Paare, deren beide Werte
        // identisch sind.
        pairs.remove((k, v) -> k == v);
        pairs.show();

        // 11. Bilde die Summe aller gültigen Werte in values.
        System.out.println(pairs.accumulate((k, v) -> v));

        // 12.Er stelle ein IntIntPairs-Objekt, das Kopien
        // aller gültigen Paare enthält, deren Wert in
        // values größer als der Wert 5 ist.
        IntIntPairs IIPKopie2 = pairs.extract((k, v) -> v > 5);
        IIPKopie2.show();
    }
    // 2) kombinierte Nutzung von Lambda-Ausdrücken

    // Wähle jeweils geeignete Methoden der
    // Klasse IntIntPairs aus, übergib diesen
    // geeignete Lambda-Ausdrücke als Argumente
    // und kombiniere die Aufrufe passend
    // in einer statischen Methode.

    // 1. Implementiere eine
    // Methode sumUp(IntIntPairs pairs),
    // die für die gültigen Paare in pairs, deren Wert in keys
    // gleich 0 ist, die zugehörigen Werte aus values aufsummiert.
    // Die Lösung dieser Aufgabe finden Sie als Beispiel in der Testumgebung.
    public static int sumUp(IntIntPairs pairs) {
        return pairs.accumulate((k, v) -> k == 0 ? v : 0);
    }

    // 2. Implementiere eine Methode addNToValue(IntIntPairs pairs, int n),
    // die für die gültigen Paare in pairs die Werte in values um den Wert n erhöht.
    public static void addNToValue(IntIntPairs pairs, int n) {
        pairs.manipulate((k, v) -> k, (k, v) -> v + n);
    }

    // 3. Implementiere eine Methode uniqueKey(IntIntPairs pairs, int n),
    // die true zurückgibt, wenn in allen gültigen Paaren in pairs der Wert
    // von n in keys genau einmal auftritt.
    public static boolean uniqueKey(IntIntPairs pairs, int n) {
        return pairs.accumulate((k, v) -> k == n ? 1 : 0) == 1 ? true : false;
    }

    // 4. Implementiere eine Methode doubleGreaterN(IntIntPairs pairs, int n),
    // die für jedes gültigen Paar (k,v) in pairs, dessen Wert k in keys größer
    // als der Wert n ist, zu pairs ein weiteres Paar (k,2*v) hinzufügt, sofern
    // in pairs noch Einträge möglich sind.
    public static void doubleGreaterN(IntIntPairs pairs, int n) {
        IntIntPairs IIPTemp = pairs.extract((k, v) -> k > n);
        IIPTemp.manipulate((k, v) -> k, (k, v) -> 2 * v);
        pairs.combine(IIPTemp);

    }

    // 5. Implementiere eine Methode IntIntPairs concat(IntIntPairs first,
    // IntIntPairs second),
    // die ein neues INtIntPairs-Objekt erzeugt, dass alle gültigen Paare von first
    // und second enthält. first und second sollen nicht geändert werden.
    public static IntIntPairs concat(IntIntPairs first, IntIntPairs second) {
        IntIntPairs newPairs = new IntIntPairs(first.accumulate((k, v) -> 1) + second.accumulate((k, v) -> 1));
        newPairs.combine(first);
        newPairs.combine(second);
        return newPairs;
    }

    // pairs.accumulate(null);
    // pairs.combine(pairs);
    // pairs.extract(null);
    // pairs.manipulate(null, null);
    // pairs.remove(null);

}
