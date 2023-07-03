public class Blatt3 {

    // 1 - Quersumme
    // Entwickle eine rekursive Methode int digitSum( int n ),
    // die für einen int-Parameter n die Quersumme des Wertes
    // von n berechnet und zurückgibt.
    // Hinweis: Die Quersumme einer Zahl ergibt sich aus der Addition
    // der letzten Ziffer mit der Summe der restlichen Ziffern.
    public static int digitSum(int n) {
        if (n < 10) {
            return n;
        } else {
            return (n % 10) + digitSum(n / 10);
        }
    }

    // 2 - Potenz
    // Entwickle eine rekursive Methode int power( int a, int n ),
    // die für zwei int-Parameter a und n die n-te Potenz
    // des Wertes von a berechnet und zurückgibt.
    public static int power(int a, int n) {
        if (n == 1) {
            return a;
        } else {
            return a * power(a, n - 1);
        }
    }

    // 3 - Werte aufsummieren
    // Entwickle eine rekursive Methode
    // int sumUpNegatives( int[] arr, int n )
    // Die Methode sumUpNegatives bildet
    // die Summe der negativen Werte im Feld arr im Bereich
    // von arr[0] bis arr[n] mit 0<=n<arr.length
    // und gibt die ermittelte Summe zurück.
    public static int sumUpNegatives(int[] arr, int n) {
        if (n == 0) {
            if (arr[n] < 0) {
                return arr[n];
            } else {
                return 0;
            }
        } else {
            if (arr[n] < 0) {
                return arr[n] + sumUpNegatives(arr, n - 1);
            } else {
                return 0 + sumUpNegatives(arr, n - 1);
            }
        }

    }

    // 4 - Zählen von positiven Werten
    // Entwickle eine rekursive Methode
    // int countPositives( int[] arr, int n ),
    // die für ein Feld arr die Anzahl der
    // positiven Werte im Bereich
    // von arr[0] bis arr[n] mit 0<=n<arr.length
    // bestimmt und zurückgibt.
    public static int countPositives(int[] arr, int n) {
        if (n < 0 || n >= arr.length) {
            return 0;
        }

        if (n == 0) {
            if (arr[0] > 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (arr[n] > 0) {
                return 1 + countPositives(arr, n - 1);
            } else {
                return 0 + countPositives(arr, n - 1);
            }
        }

    }

    // 5 - Zählen von positiven Werten in einem Teil des Feldes
    // Entwickle eine rekursive Methode
    // int countPositivesLimited( int[] arr, int d, int t ),
    // die für ein Feld arr im Bereich von jeweils
    // einschließlich arr[d] bis arr[t]
    // mit d<=t<arr.length die Anzahl der positiven Werte bestimmt
    // und zurückgibt.
    public static int countPositivesLimited(int[] arr, int d, int t) {
        if (t < d || t < 0 || d < 0 || t >= arr.length || d >= arr.length) {
            return 0;
        }

        if (d == t) {
            if (arr[d] > 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (arr[d] > 0) {
            return 1 + countPositivesLimited(arr, d + 1, t);
        } else {
            return 0 + countPositivesLimited(arr, d + 1, t);
        }

    }

    // 6 - Bestimmung des Maximums
    // Entwickle eine rekursive Methode
    // int maximum( int[] arr, int i ), die für ein Feld arr
    // das Maximum im Bereich von arr[0] bis arr[i]
    // mit 0<=i<arr.length bestimmt und zurückgibt
    public static int maximum(int[] arr, int i) {
        if (i < 0 || i >= arr.length) {
            return 0;
        }

        if (i == 0) {
            return i;
        } else {
            if (arr[i] > maximum(arr, i - 1)) {
                return arr[i];
            } else {
                return maximum(arr, i - 1);
            }
        }

    }

    // 7 - Prüfen einer Sortierung
    // Entwickle eine rekursive Methode
    // boolean isSorted( int[] arr, int i ),
    // die für ein Feld arr im Bereich von arr[0] bis arr[i]
    // mit 0<=i<arr.length feststellt, ob das Feld aufsteigend
    // sortiert ist, also für alle k mit 0<=k<i gilt:
    // arr[k]<=arr[k+1]. Ist das der Fall, wird true zurückgegeben,
    // sonst false.
    public static boolean isSorted(int[] arr, int i) {
        if (i < 0 || i >= arr.length) {
            throw new RuntimeException();
        }

        if (i == 1) {
            return arr[1] > arr[0];
        } else {
            return arr[i] > arr[i - 1] && isSorted(arr, i - 1);
        }
    }

    // 8 - Inhaltsüberprüfung
    // Entwickle eine rekursive Methode
    // boolean contains( int[] arr, int i, int x ),
    // die für ein Feld arr im Bereich
    // von arr[0] bis arr[i] mit 0<=i<arr.length
    // bestimmt, ob dort der Wert x vorkommt.
    // Ist das der Fall, wird true zurückgegeben, sonst false.
    public static boolean contains(int[] arr, int i, int x) {
        if (i < 0 || i >= arr.length) {
            throw new RuntimeException();
        }

        if (i == 0) {
            return arr[0] == x;
        } else {
            return arr[i] == x || contains(arr, i - 1, x);
        }
    }

    // 9 - Gleichheit von Feldinhalten
    // Entwickle eine rekursive Methode
    // boolean contentCheck( char[] arr1, char[] arr2, int i ),
    // die für die beiden als Parameter übergebenen Felder
    // feststellt, ob die Folgen der Zeichen im Bereich
    // der Indizes von 0 bis i mit 0<=i<arr.length gleich sind.
    // Die Methode gibt einen Wert des Typs boolean zurück.
    public static boolean contentCheck(char[] arr1, char[] arr2, int i) {
        if (i < 0 || i >= arr1.length || i >= arr2.length) {
            throw new RuntimeException();
        }

        if (i == 0) {
            return arr1[0] == arr2[0];
        } else {
            if (arr1[i] != arr2[i]) {
                return false;
            } else {
                return contentCheck(arr1, arr2, i - 1);

            }
        }
    }

    // 10 - Palindrome
    // Ein Palindrom ist eine Zeichenfolge, die vorwärts und
    // rückwärts identisch gelesen werden kann.
    // Entwickle eine rekursive Methode
    // boolean palindromCheck( char[] arr, int i ),
    // die ermittelt, ob die Folge der Zeichen im Feld arr
    // ein Palindrom bildet. Der Parameter i soll dazu benutzt
    // werden, den betrachteten Bereich des Feldes arr einzuschränken.
    // Die Methode gibt einen Wert des Typs boolean zurück.
    public static boolean palindromCheck(char[] arr, int i) {
        if (i < 0 || i >= arr.length) {
            throw new RuntimeException();
        }

        if (i == arr.length / 2) {
            return arr[i] == arr[arr.length - i - 1];
        } else {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            } else {
                return palindromCheck(arr, i - 1);
            }
        }
    }

    // 11 - Ermitteln des Index
    // Entwickle eine rekursive Methode
    // int getIndex( int[] arr, int i, int x ),
    // die den kleinsten Index zurückgibt, an
    // dem der Wert x in arr im Bereich
    // von arr[0] bis arr[i] mit 0<=i<arr.length vorkommt.
    // Kommt x nicht vor oder wird für i ein Wert außerhalb
    // der Grenzen des Felds arr übergeben, wird -1 zurückgegeben.
    public static int getIndex(int[] arr, int i, int x) {
        if (i < 0 || i >= arr.length) {
            return -1;
        } else {
            if (i == 0) {
                if (arr[0] == x) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                if (arr[i] == x) {
                    int k = getIndex(arr, i - 1, x);
                    if (k > -1) {
                        return k;
                    } else {
                        return i;
                    }
                } else {
                    return getIndex(arr, i - 1, x);
                }
            }
        }
    }

    // 12 - Erzeugen eines Textes
    // Entwickle eine rekursive Methode
    // String toString( int[] arr, int i ).
    // Die Methode toString erzeugt einen Text, der alle Werte
    // des Feldes im Bereich
    // von arr[0] bis arr[i] mit 0<=i<arr.length in
    // der Reihenfolge ihres Auftretens durch Kommas getrennt
    // enthält. Der erzeugte Text wird zurückgegeben.
    public static String toString(int[] arr, int i) {

        if (i < 0 || i > arr.length) {
            // throw new IllegalArgumentException();
            return "";
        }

        if (i == 0) {
            return String.valueOf(arr[0]);
        } else {
            return toString(arr, i - 1) + ", " + String.valueOf(arr[i]);
        }

    }

}
