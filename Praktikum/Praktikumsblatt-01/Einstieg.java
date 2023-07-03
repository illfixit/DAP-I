public class Einstieg {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("1 - Summe");
        System.out.println();

        System.out.println("interval( 5, 11 ): " + interval(5, 11));
        System.out.println("interval( 11, 5 ): " + interval(11, 5));
        System.out.println("interval( 3, -1 ): " + interval(3, -1));
        System.out.println("interval( 4, 4 ): " + interval(4, 4));
        System.out.println("interval( 0, 0 ): " + interval(0, 0));
        System.out.println();

        System.out.println("2 - Quersumme");
        System.out.println();

        System.out.println("digitSum(345): " + digitSum(345));
        System.out.println("digitSum(-17): " + digitSum(-17));
        System.out.println();

        System.out.println("3 - Ziffern/Zahlen/Quersumme als Text");
        System.out.println();
        System.out.println("digitToString( 7 ): " + digitToString(7));

        System.out.println("intToString(-34): " + intToString(-34));
        System.out.println("intToString(34): " + intToString(34));
        System.out.println("intToString(3): " + intToString(3));
        System.out.println("intToString(345): " + intToString(345));
        System.out.println("intToString(-345): " + intToString(-345));

        System.out.println("digitSumToString(345): " + digitSumToString(345));
        System.out.println("digitSumToString(0): " + digitSumToString(0));
        System.out.println("digitSumToString(3): " + digitSumToString(3));
        System.out.println("digitSumToString(55): " + digitSumToString(55));
        System.out.println();

        System.out.println("4 - Harshad-Zahlen");
        System.out.println();
        System.out.println("isHarshad(777): " + isHarshad(777));
        System.out.println("isHarshad(111): " + isHarshad(111));

        System.out.println("isHarshad(123): " + isHarshad(123));
        System.out.println("isHarshad(345): " + isHarshad(345));

        System.out.println("computeHarshads(111): ");
        computeHarshads(111);
        System.out.println();

        System.out.println("5 - Eulersche Zahl");
        System.out.println();
        System.out.println("computeEuler(0): " + computeEuler(0));
        System.out.println("computeEuler(1): " + computeEuler(1));
        System.out.println("computeEuler(2): " + computeEuler(2));
        System.out.println("computeEuler(3): " + computeEuler(3));

        System.out.println("computeEuler(10): " + computeEuler(10));
        System.out.println("computeEuler(66): " + computeEuler(66));
        System.out.println("computeEuler(167): " + computeEuler(167));
        System.out.println();

    }

    // 1 - Summe

    // Programmiere die Methode int interval( int a, int b ),
    // die die Summe aller int-Werte in dem geschlossenen
    // Intervall mit den Grenzen a und b berechnet und zurückgibt.
    // Dabei bildet immer der kleinere der Werte aus a und b
    // die untere Grenze, der größere Wert die oberere Grenze
    // des Intervalls.

    // Beispiele:
    // interval( 5, 11 ) gibt 56 zurück,
    // da 5+6+7+8+9+10+11=56 gilt.
    // interval( 11, 5 ) gibt ebenfalls 56 zurück,
    // da 5+6+7+8+9+10+11=56 gilt.
    // interval( 3, -1 ) gibt 5 zurück,
    // da -1+0+1+2+3=5 gilt.
    // interval( 4, 4 ) gibt 4 zurück.
    // interval( 0, 0 ) gibt 0 zurück.

    public static int interval(int a, int b) {
        int min, max;
        int sum = 0;

        if (a > b) {
            min = b;
            max = a;
        } else if (a < b) {
            min = a;
            max = b;
        } else {
            min = max = a;
        }

        for (int i = min; i <= max; i++) {
            sum += i;
        }

        return sum;
    }

    // 2 - Quersumme

    // Schreibe die Methode int digitSum( int x ),
    // die bei ihrer Ausführung eine ganze Zahl x
    // als Argument erhält und die Quersumme von x zurückgibt.
    // Die Quersumme ergibt sich als Summe der einzelnen Ziffern,
    // die die Zahl bilden. Das Vorzeichen spielt bei
    // der Berechnung der Quersumme keine Rolle.

    // Beispiele: Die Quersumme von 345 ist 3+4+5=12,
    // die Quersumme von -17 ist 1+7=8.

    // Hinweis: Im Dezimalsystem erhalten Sie die
    // letzte Ziffer einer Zahl als Rest der Division durch 10

    public static int digitSum(int x) {

        // falls x < 0, [x == 0 betrachten wir weiter]
        if (x < 0) {
            x = -x;
        }

        int sum = 0;

        // x = x / 10 "/" ist ganzzählige Division und
        // x = 3 / 10 ergibt nicht 0.3 sondern 0
        // damit ist x > 0 falsch und so können wir
        // die Schleife unterbrechen
        while (x > 0) {
            int number = x % 10;
            x = x / 10;
            sum += number;
        }

        // wenn x == 0 ist, dann sum = 0 und
        // die Programm ignoriert dir while Schleife
        // und gibt einfach sum (=0) zurück,
        // was auch richtig ist.

        return sum;
    }

    // 3 - Ziffern/Zahlen/Quersumme als Text

    // Schreibe die Methode String digitToString( int z1 ),
    // die bei ihrer Ausführung eine einstellige nicht-negative
    // ganze Zahl z1 – also eine einzelne Ziffer zwischen 0 und 9
    // – als Argument übergeben bekommt. Die Methode gibt einen
    // String zurück, der den Namen der Ziffer enthält.
    // Für andere Argumente soll der leere Text zurückgegeben
    // werden.

    // Beispiel: digitToString( 7 ) soll als Ergebnis
    // "sieben" liefern.
    public static String digitToString(int z1) {
        if (z1 < 0 || z1 > 9) {
            return "";
        }

        String[] nums = { "null", "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun" };

        return nums[z1];
    }

    // Schreibe die Methode String intToString( int z ), die bei
    // ihrer Ausführung eine ganze Zahl als Argument erhält und
    // einen String zurückgibt. Der String enthält die Folge der
    // Namen der Ziffern. Diese Namen werden durch "-" getrennt.
    // Ist die übergebene Zahl negativ, wird das Wort "minus"
    // vorangestellt. Benutze die Methode digitToString.
    // Beispiel: Das Argument -34 soll zu folgendem
    // Text führen: "minus-drei-vier".

    public static String intToString(int z) {
        String result = "";
        String sign = "";
        if (z < 0) {
            z = -z;
            sign = "minus-";
        }

        while (z > 0) {
            if (result == "") {
                result = digitToString(z % 10);
            } else {
                result = digitToString(z % 10) + "-" + result;
            }
            z = z / 10;
        }

        return sign + result;
    }

    // Schreibe nun die Methode String digitSumToString( int x ),
    // die die Methoden digitSum und intToString nutzt.
    // digitSumToString erhält bei ihrer Ausführung eine ganze
    // Zahl x als Argument übergeben und gibt den Wert der
    // Quersumme als Folge der Namen der Ziffern zurück.

    public static String digitSumToString(int x) {
        return intToString(digitSum(x));
    }

    // 4 - Harshad-Zahlen

    // Eine natürliche Zahl heißt Harshad-Zahl, wenn Sie durch
    // ihre Quersumme teilbar ist. Schreibe die Methode boolean
    // isHarshad( int z ), die bei ihrer Ausführung eine ganze
    // Zahl z als Argument erhält und true zurückgibt,
    // falls z eine Harshad-Zahl ist und sonst false.

    // Beispiel: 777 ist durch 7 + 7 + 7 = 21 teilbar und damit
    // eine Harshad-Zahl.

    public static boolean isHarshad(int z) {
        return z % digitSum(z) == 0;
    }

    // Schreibe die Methode void computeHarshads( int n ),
    // die bei ihrer Ausführung eine ganze Zahl n als Argument
    // erhält und alle Harshad-Zahlen von 1 bis bis n bestimmt
    // und am Bildschirm ausgibt.

    public static void computeHarshads(int n) {
        for (int i = 1; i < n; i++) {
            if (isHarshad(i)) {
                System.out.println(i);
            }
        }
    }

    // 5 - Eulersche Zahl

    // Programmieren Sie eine Methode double computeEuler( int n ),
    // die die Eulersche Zahl e = 2,71... berechnet. Die Berechnung
    // soll nach der Addition des n-ten Summenglieds abbrechen und
    // die berechnete Summe zurückgeben.

    public static double computeEuler(int n) {

        // if (n < 1) {
        // throw new IllegalArgumentException();
        // }

        double e = 1.0;
        double last = 1.0;

        for (int i = 1; i <= n; i++) {
            double current = last / i;
            e = e + current;
            last = current;
        }

        return e;
    }

}