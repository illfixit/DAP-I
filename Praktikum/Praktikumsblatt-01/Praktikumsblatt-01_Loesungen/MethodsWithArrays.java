/**
 * Praktikumsblatt 1 - Vorbereitung
 * Methoden mit Feldern als Parametern
 */

public class MethodsWithArrays {

    // 1 - Werte zählen
    // Schreibe die Methode int countNegatives( int[] arr ),
    // die als Parameter ein Feld besitzt. Die Methode
    // countNegatives zählt die negativen Werte in diesem Feld
    // und gibt den ermittelten Wert zurück.

    public static int countNegatives(int[] arr) {
        int negatives = 0;
        for (int number : arr) {
            if (number < 0) {
                negatives++;
            }
        }
        return negatives;
    }

    // 2 - Werte aufsummieren
    // Schreibe die Methode int sumUpNegatives( int[] arr ),
    // die als Parameter ein Feld besitzt.
    // Die Methode sumUpNegatives bildet die Summe der negativen
    // Werte in diesem Feld und gibt den ermittelten Wert zurück.
    public static int sumUpNegatives(int[] arr) {
        int sumOfNegatives = 0;
        for (int number : arr) {
            if (number < 0) {
                sumOfNegatives += number;
            }
        }
        return sumOfNegatives;
    }

    // 3 - Bestimmen des Maximums in einem Feld
    // Schreibe die Methode int maximum( int[] arr ), die ein
    // Feld als Parameter besitzt und die den größten Wert in diesem
    // Feld bestimmt und zurückgibt.
    //
    // Hinweis: Versuche, mit einem Durchlauf durch das Feld auszukommen.
    public static int maximum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int max = arr[0];
        for (int number : arr) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    // 4 - Bestimmen der Häufigkeit des Maximums in einem Feld
    // Schreibe die Methode int countMaximum( int[] arr ),
    // die ein Feld von int-Werten als Parameter besitzt und
    // die zählt, wie häufig der größte Wert vorkommt.
    // Die ermittelte Anzahl wird zurückgegeben.
    public static int countMaximum(int[] arr) {
        int anz = 0;
        int max = maximum(arr);
        for (int number : arr) {
            if (number == max) {
                anz++;
            }
        }
        return anz;
    }

    // alternative effizientere Loesung:
    public static int countMaximumAlternative(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int max = arr[0];
        int count = 1;
        for (int number : arr) {
            if (number == max) {
                count++;
            } else if (number > max) {
                count = 1;
                max = number;
            }
        }
        return count;
    }

    // 5 - Sortierung prüfen
    // Schreibe die Methode boolean isSorted( int[] arr ),
    // die als Parameter ein Feld besitzt. Die Methode isSorted soll
    // true zurückgeben, falls die im Feld enthaltenen Werte
    // aufsteigend sortiert sind; sonst wird false zurückgegeben.

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] >= arr[i]) {
                return false;
            }
        }
        return true;
    }

    // 6 - Palindrome erkennen
    // Ein Palindrom ist eine Folge von int-Werten, die vorwärts
    // und rückwärts gelesen die identische Ziffernfolge ergibt.
    //
    // Beispiele: Die Folgen 12 34 78 34 12 oder
    // 5 17 88 88 17 5 sind Palindrome.
    //
    // Schreibe die Methode boolean checkArray( int[] arr ),
    // die für das als Parameter übergebene Feld bestimmt, ob die
    // Folge der Zahlen ein Palindrom bildet. Die Methode
    // gibt einen Wert des Typs boolean zurück.
    public static boolean checkArray(int[] f) {
        if (f.length == 0)
            return false;
        int i = 0;
        int n = f.length - 1;
        while (i < n) {
            if (f[i] != f[n]) {
                return false;
            }
            i++;
            n--;
        }
        return true;
    }

    // 7 - Erhöhen der Inhalte eines Feldes
    // Schreibe die Methode int[] increaseArray( int[] arr, int z ),
    // die als Parameter ein Feld und einen int-Wert z besitzt.
    // Die Methode increaseArray erhöht alle Werte des Feldes
    // um den Wert z und gibt das veränderte Feld zurück.
    //
    // Beispiel: Werden ein Feld mit den Elementen
    // 80,7,1,56,11,72,43,37 als erstes und der Wert 17
    // als zweites Argument übergeben, so wird dieses Feld
    // verändert und als 97,24,18,73,28,89,60,54 zurückgegeben.
    public static int[] increaseArray(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + n;
        }
        return arr;
    }

    // 8 - Bedingtes Verdoppeln der Inhalte eines Feldes
    // Schreibe die Methode
    // int[] doubleIfContainsPositive( int[] arr ),
    // die als Parameter ein Feld des Typs int besitzt.
    // Die Methode doubleIfContainsPositive verdoppelt alle
    // Werte des Feldes, falls in dem Feld mindestens ein
    // positiver Wert vorkommt; sonst bleibt das Feld unverändert.
    // Das (veränderte) Feld soll zurückgegeben werden.
    // Beispiel: Wird ein Feld mit den Elementen
    // 0,-7,1,5,-1,2,4 als Argument übergeben,
    // so wird dieses Feld verändet und als
    // 0,-14,2,10,-2,4,8 zurückgegeben.
    public static int[] doubleIfContainsPositive(int[] arr) {
        for (int number : arr) {
            if (number > 0) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] *= 2;
                }
                return arr;
            }
        }
        return arr;
    }

    // 9 - Erzeugen eines Textes
    // Schreibe die Methode String toString( int[] arr ),
    // die als Parameter ein Feld besitzt. Die Methode toString
    // erzeugt einen Text, der alle Inhalte des Feldes in der
    // Reihenfolge ihres Auftretens durch Kommas getrennt enthält.
    // Der erzeugte Text wird zurückgegeben.
    public static String toString(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i];
            if (i < arr.length - 1) {
                result = result + ", ";
            }
        }
        return result;
    }

    // 10 - Erzeugen eines Feldes mit drei Elementen
    // Schreibe die Methode int[] copyStartingValues( int[] arr ),
    // die als Parameter ein Feld besitzt. Die Methode
    // copyStartingValues erzeugt ein neues Feld, das in seinen
    // Elementen genau die ersten drei Werte des als Argument
    // übergebenen Feldes enthält, falls dieses mehr als zwei
    // Elemente besitzt. Das erzeugte Feld wird zurückgegeben.
    // Besitzt das als Argument übergebene Feld weniger als drei
    // Elemente, wird es vollständig kopiert.
    //
    // Beispiel: Wird ein Feld mit den Elementen
    // 80,7,1,56,11,72,43,37 als Argument übergeben,
    // so wird ein neues Feld mit den Werten 80,7,1 zurückgegeben.
    public static int[] copyStartingValues(int[] arr) {
        int[] newArr;
        if (arr.length > 2) {
            newArr = new int[3];
        } else {
            newArr = new int[arr.length];
        }
        for (int i = 0; i < arr.length & i < 3; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    // 11 - Erzeugen eines Feldes mit ausgesuchten Inhalten
    // Schreibe die Methode int[] selectNegatives( int[] arr ),
    // die als Parameter ein Feld besitzt. Die Methode selectNegatives
    // gibt ein Feld zurück, in dem ausschließlich die negativen Werte
    // des als Argument übergebenen Feldes enthalten sind.
    // Die Methode countNegatives kann dazu benutzt werden,
    // die Größe des zurückgegebenen Feldes zu bestimmen.
    //
    // Beispiel: Wird ein Feld mit den Elementen
    // 80,-7,1,56,-11,-72,0,37 als Argument übergeben,
    // so wird ein neues Feld mit den Werten -7,-11,-72 zurückgegeben.
    public static int[] selectNegatives(int[] arr) {
        int[] negativeValues = new int[countNegatives(arr)];
        int position = 0;
        for (int number : arr) {
            if (number < 0) {
                negativeValues[position] = number;
                position++;
            }
        }
        return negativeValues;
    }

    // 12 - Erzeugen eines Feldes mit invertiertem Inhalt
    // Schreibe die Methode int[] copyAndInvert( int[] arr ),
    // die als Parameter ein Feld besitzt. Die Methode
    // copyAndInvert gibt ein Feld zurück, das die Werte des als
    // Argument übergebenen Feldes in umgekehrter Reihenfolge enthält.
    //
    // Beispiel: Wird ein Feld mit den Elementen
    // 80,-7,1,56,-11,-72,0,37 als Argument übergeben, so wird ein
    // neues Feld mit den Werten 37,0,-72,-11,56,1,-7,80 zurückgegeben.
    public static int[] copyAndInvert(int[] arr) {
        int[] invertedValues = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            invertedValues[arr.length - 1 - i] = arr[i];
        }
        return invertedValues;
    }

    // 13 - Zusammenführen von Feldern
    // Schreibe die Methode int[] addArrays( int[] arr1, int[] arr2 ),
    // die zwei int-Felder als Parameter besitzt.
    // Haben diese Felder die gleiche Länge, so werden die Werte am
    // gleichen Index aus beiden Feldern addiert und die Summe unter
    // diesem Index in einem dritten int-Feld abgelegt werden.
    // Dieses Feld wird als Ergebnis des Aufrufs von addArrays
    // zurückgegeben. Unterscheiden sich die als Argumente übergebene
    // Felder in ihrer Länge, wird ein leeres Feld zurückgegeben.
    public static int[] addArrays(int[] f, int[] g) {
        if (f.length != g.length) {
            return new int[0];
        }
        int[] feld = new int[f.length];
        for (int i = 0; i < f.length; i++) {
            feld[i] = f[i] + g[i];
        }
        return feld;
    }

    // 14 - Zählen von Folgen
    // Schreibe die Methode int countSequences( int[] arr ),
    // die ein Feld als Parameter besitzt. Die Methode
    // countSequences ermittelt die Anzahl der im Feld enthaltenen
    // Zahlenfolgen, in denen nicht der Wert 0 vorkommt. Eine
    // solche Zahlenfolge endet immer mit dem Auftreten einer 0
    // oder dem Ende des Feldes. Die ermittelte Anzahl wird von der
    // Methode zurückgegeben.
    //
    // Beispiel: Wird ein Feld mit den Elementen
    // 80,7,1,0,11,72,0,0,37,61 als Argument übergeben,
    // so wird der Aufruf von countSequences als Ergebnis
    // 3 liefern, da die Folgen 80,7,1 und 11,72 und 37,61 auftreten.
    public static int countSequences(int[] f) {
        int anz = 0;
        for (int i = 1; i < f.length; i++) {
            if (f[i] == 0 && f[i - 1] != 0) {
                anz++;
            }
        }
        if (f[f.length - 1] != 0) {
            anz++;
        }
        return anz;
    }

    // 15 - Analyse eines Felds
    // Schreibe die Methode boolean twoTimes( int[] arr ),
    // die true zurückgibt, wenn das Feld arr mindestens zwei
    // Elemente besitzt und jeder im Feld vorkommende Wert
    // genau zweimal auftritt. Sonst wird false zurückgegeben.
    //
    // Beispiele: Feld Ergebnis
    // 2 3 4 3 7 7 4 1 2 1 true
    // 2 2 8 8 5 5 3 3 9 9 true
    // 2 3 2 3 5 5 1 2 1 2 false, da der Wert 2 zu häufig vorkommt
    // 2 3 3 5 5 4 1 2 1 false, da der Wert 4 nur einmal vorkommt
    public static boolean twoTimes(int[] arr) {
        int count = 0;
        for (int number1 : arr) {
            for (int number2 : arr) {
                if (number1 == number2) {
                    count++;
                }
            }
            if (count != 2) {
                return false;
            } else {
                count = 0;
            }
        }
        return true;
    }

}
