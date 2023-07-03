public class Blatt2 {

    // 1 - Brüche zählen
    // Schreibe die Methode Fraction countNegatives( Fraction[] arr ).
    // Die Methode countNegatives zählt die negativen Brüche in diesem Feld
    // und gibt den ermittelte Anzahl als Bruch zurück.
    public static Fraction countNegatives(Fraction[] arr) {

        int count = 0;

        for (Fraction f : arr) {
            if (f.toDouble() < 0) {
                count++;
            }
        }

        return new Fraction(count);
    }

    // 2 - Werte aufsummieren
    // Schreibe die Methode Fraction sumUpNegatives( Fraction[] arr ).
    // Die Methode sumUpNegatives bildet die Summe der negativen Brüche
    // in diesem Feld und gibt die ermittelte Summe als Bruch zurück.
    public static Fraction sumUpNegatives(Fraction[] arr) {
        Fraction sum = new Fraction(0);

        for (Fraction f : arr) {
            if (f.toDouble() < 0) {
                sum.add(f);
            }
        }

        return sum;
    }

    // 3 - Bestimmen des Maximums in einem Feld
    // Schreibe die Methode Fraction maximum( Fraction[] arr ).
    // Die Methode maximum bestimmt den größten Bruch in
    // diesem Feld und gibt ihn zurück.
    public static Fraction maximum(Fraction[] arr) {
        if (arr.length == 0) {
            return null;
        }

        Fraction max = arr[0];

        for (Fraction f : arr) {
            if (f.toDouble() > max.toDouble()) {
                max = f;
            }
        }

        return max;
    }

    // 4 - Bestimmen der Häufigkeit des Maximums in einem Feld
    // Schreibe die Methode Fraction countMaximum( Fraction[] arr ),
    // die zählt, wie häufig der größte Wert vorkommt.
    // Die ermittelte Anzahl wird als Bruch zurückgegeben.
    public static Fraction countMaximum(Fraction[] arr) {
        if (arr.length == 0) {
            return null;
        }

        Fraction max = arr[0];
        int count = 1;

        for (Fraction f : arr) {
            if (f.toDouble() > max.toDouble()) {
                max = f;
                count = 1;
            } else if (f.equals(max)) {
                count++;
            }
        }

        return new Fraction(count);
    }

    // Musterlösung
    // public static Fraction countMaximum(Fraction[] arr) {
    // int count = 0;
    // Fraction max = maximum(arr);
    // for (Fraction f : arr) {
    // if (f.equals(max)) {
    // count++;
    // }
    // }
    // return new Fraction(count);
    // }

    // 5 - Sortierung prüfen
    // Schreibe die Methode boolean isSorted( Fraction[] arr ).
    // Die Methode isSorted soll true zurückgeben, falls die im Feld
    // enthaltenen Werte aufsteigend sortiert sind;
    // sonst wird false zurückgegeben.
    public static boolean isSorted(Fraction[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].toDouble() <= arr[i - 1].toDouble()) {
                return false;
            }
        }

        return true;
    }

    // 6 - Erhöhen der Inhalte eines Feldes
    // Schreibe die Methode
    // Fraction[] increaseArray(Fraction[] arr, Fraction z).
    // Die Methode increaseArray erhöht alle Brüche des Feldes um
    // den Wert des Bruchs z und gibt das veränderte Feld zurück.
    public static Fraction[] increaseArray(Fraction[] arr, Fraction z) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].add(z);
        }

        return arr;
    }

    // 7 - Bedingtes Verdoppeln der Inhalte eines Feldes
    // Schreibe die Methode
    // Fraction[] doubleIfContainsPositive( Fraction[] arr ).
    // Die Methode doubleIfContainsPositive verdoppelt alle Brüche
    // des Feldes, falls in dem Feld mindestens ein positiver
    // Bruch vorkommt; sonst bleibt das Feld unverändert.
    // Das (veränderte) Feld wird zurückgegeben.
    public static Fraction[] doubleIfContainsPositive(Fraction[] arr) {
        Fraction[] doubleArr = new Fraction[arr.length];

        boolean containsPositive = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toDouble() > 0) {
                containsPositive = true;
            }
            doubleArr[i] = arr[i].multiply(new Fraction(2));
        }

        return containsPositive ? doubleArr : arr;
    }

    // jop, es gibt kein Nummer 8 im Praktikumsblatt

    // 9 - Erzeugen eines Textes
    // Schreibe die Methode String toString( Fraction[] arr ).
    // Die Methode toString erzeugt einen Text, der alle Brüche
    // des Feldes in der Reihenfolge ihres Auftretens durch Kommas
    // getrennt enthält. Der erzeugte Text wird zurückgegeben.
    public static String toString(Fraction[] arr) {
        String result = "";

        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                result = result + arr[i].toString() + ", ";
            } else {
                result = result + arr[i].toString();
            }
        }

        return result;
    }

    // 10 - Erzeugen eines Feldes mit ausgesuchten Inhalten
    // Schreibe die Methode Fraction[] selectNegatives( Fraction[] arr ).
    // Die Methode selectNegatives gibt ein Feld zurück, in dem
    // ausschließlich die negativen Brüche des als Argument übergebenen
    // Feldes enthalten sind. Die Methode countNegatives kann dazu benutzt
    // werden, die Größe des zurückgegebenen Feldes zu bestimmen.
    public static Fraction[] selectNegatives(Fraction[] arr) {
        int len = (int) countNegatives(arr).toDouble();
        Fraction[] resArr = new Fraction[len];

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toDouble() < 0) {
                resArr[idx] = arr[i];
                idx++;
            }
        }

        return resArr;
    }

    // 11 - Zählen von Folgen
    // Schreibe die Methode Fraction countSequences( Fraction[] arr ),
    // die ein Feld als Parameter besitzt. Die Methode countSequences
    // ermittelt die Anzahl der im Feld enthaltenen Folgen von Brüchen,
    // in denen nicht der Wert 0 vorkommt. Eine solche Zahlenfolge endet
    // immer mit dem Auftreten einer 0 oder dem Ende des Feldes. Die
    // ermittelte Anzahl wird von der Methode zurückgegeben.
    public static Fraction countSequences(Fraction[] arr) {
        int count = 0;
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toDouble() == 0) {
                if (num != 0) {
                    count++;
                    num = 0;
                }
            } else {
                num++;
            }
        }

        if (num != 0) {
            count++;
        }

        return new Fraction(count);

    }
}
