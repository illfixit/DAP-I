/**
 * Praktikumsblatt 1 - Einstieg
 * Methoden mit einfachen Parametern
 */

public class SimpleMethods {

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
        int sum = 0;
        int lower;
        int upper;
        if (a < b) {
            lower = a;
            upper = b;
        } else {
            lower = b;
            upper = a;
        }
        while (lower <= upper) {
            sum = sum + lower;
            lower++;
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

    public static int digitSum(int y) {
        int x = y;
        if (x < 0) {
            x = -x;
        }
        int sum = 0;
        while (x > 0) {
            sum = sum + x % 10;
            x = x / 10;
        }
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

    public static String digitToString(int n) {
        if (n < 0 || n > 9) {
            return "";
        }
        String[] numbers = { "null", "eins", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun" };
        return numbers[n];
    }

    // Schreibe die Methode String intToString( int z ), die bei
    // ihrer Ausführung eine ganze Zahl als Argument erhält und
    // einen String zurückgibt. Der String enthält die Folge der
    // Namen der Ziffern. Diese Namen werden durch "-" getrennt.
    // Ist die übergebene Zahl negativ, wird das Wort "minus"
    // vorangestellt. Benutze die Methode digitToString.
    // Beispiel: Das Argument -34 soll zu folgendem
    // Text führen: "minus-drei-vier".

    public static String intToString(int n) {
        String s = "";
        int x = n;
        if (x < 0) {
            x = -x;
        }
        while (x > 9) {
            s = "-" + digitToString(x % 10) + s;
            x = x / 10;
        }
        if (n < 0) {
            s = "minus-" + digitToString(x) + s;
        } else {
            s = digitToString(x) + s;
        }
        return s;
    }

    // Schreibe nun die Methode String digitSumToString( int x ),
    // die die Methoden digitSum und intToString nutzt.
    // digitSumToString erhält bei ihrer Ausführung eine ganze
    // Zahl x als Argument übergeben und gibt den Wert der
    // Quersumme als Folge der Namen der Ziffern zurück.

    public static String digitSumToString(int n) {
        return intToString(digitSum(n));
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
        for (int i = 1; i <= n; i++) {
            if (isHarshad(i)) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    // 5 - Eulersche Zahl

    // Programmieren Sie eine Methode double computeEuler( int n ),
    // die die Eulersche Zahl e = 2,71... berechnet. Die Berechnung
    // soll nach der Addition des n-ten Summenglieds abbrechen und
    // die berechnete Summe zurückgeben.

    // Die Methode funktioniert nur fuer n < 66.
    // Bei groesseren Werten wird "Infinity" zurueckgegeben.
    public static double computeEuler(int n) {
        double e = 1.0;
        long nominator = 1;
        for (int i = 1; i <= n; i++) {
            nominator = nominator * i;
            // Wichtig: 1.0 als Zaehler verwenden, damit eine
            // Gleitkommadivision durchgefuehrt wird.
            e = e + 1.0 / nominator;
        }
        return e;
    }

}
