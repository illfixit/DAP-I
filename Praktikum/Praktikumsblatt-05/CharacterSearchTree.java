public class CharacterSearchTree {

    // Vorgaben

    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public HuffmanTriple getContent() {
        if (!isEmpty()) {
            return content;
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isEmpty() {
        return content == null;
    }

    public boolean isLeaf() {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void iterativeAdd(char t) {
        CharacterSearchTree current = this;
        while (!current.isEmpty() && current.content.getToken() != t) {
            if (current.content.getToken() > t) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        if (current.isEmpty()) {
            current.content = new HuffmanTriple(t);
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        } else {
            current.content.incrementQuantity();
        }
    }

    public void show() {
        if (!isEmpty()) {
            leftChild.show();
            System.out.println(content.toString());
            rightChild.show();
        }
    }

    // 1 - Konstruktor mit Feld von char
    // Implementiere einen Konstruktor, der ein Feld
    // von Zeichen (also des Typs char) als Parameter besitzt
    // und der für die im Feld abgelegten Zeichen Knoten
    // in den Baum in der Reihenfolge ihres Auftretens
    // im Feld einfügt oder – falls bereits ein entsprechender
    // Knoten vorhanden ist – die zugehörige Häufigkeit erhöht.
    public CharacterSearchTree(char[] chars) {
        if (chars != null & chars.length > 0) {

            for (char c : chars) {
                iterativeAdd(c);
            }
        }
    }

    // 2 - Methode void add( char t, int q, String c )
    // mit drei Parametern
    // Implementiere eine Methode add( char t, int q, String c ),
    // die ein Zeichen t zusammen mit der Häufigkeit q
    // und der Kodierung c in den Baum einträgt.
    // Ist für das Zeichen t im Baum noch kein Knoten vorhanden,
    // soll dieser ergänzt werden. Ist für das Zeichen t im Baum
    // bereits ein Knoten vorhanden, soll dessen Häufigkeit
    // um den Wert von q erhöht und die Kodierung auf
    // c gesetzt werden.
    public void add(char t, int q, String c) {
        if (!isEmpty()) {
            if (getContent().getToken() == t) {
                for (int i = 1; i <= q; i++) {
                    getContent().incrementQuantity();
                }
                getContent().setCode(c);
            } else {
                if (getContent().getToken() > t) {
                    leftChild.add(t, q, c);
                } else {
                    rightChild.add(t, q, c);
                }
            }
        } else {
            content = new HuffmanTriple(t, q);
            content.setCode(c);
            leftChild = new CharacterSearchTree();
            rightChild = new CharacterSearchTree();
        }
    }

    // 3 - Methode void showPreOrder()
    // Implementiere eine Methode showPreOrder,
    // die die Inhalte der Knoten des Baums in der Folge eines
    // PreOrder-Durchlaufs anzeigt. Bei einem PreOrder-Durchlauf
    // wird zuerst der Inhalt der Wurzel ausgegeben und danach
    // werden der linke und danach der rechte Teilbaum in dieser
    // Reihenfolge behandelt. Nutze die Methode toString
    // der Klasse HuffmanTriple.
    // Wird der Inhalt eines Blatts ausgegeben,
    // soll ein ’*’ vorangestellt werden.
    public void showPreOrder() {
        if (!isEmpty()) {
            if (isLeaf()) {
                System.out.print("*");
            }
            System.out.println(content.toString());
            leftChild.showPreOrder();
            rightChild.showPreOrder();
        }
    }

    // 4 - Methode int height()
    // Implementiere eine Methode height, die die Höhe
    // des Baums liefert. Die Höhe des Baums ist die Anzahl
    // der Knoten auf dem längsten möglichen Weg von der Wurzel
    // zu einem Blatt. Ein leerer Baum hat die Höhe 0.
    // Ein Baum, der nur aus der Wurzel besteht, hat die Höhe 1.
    public int height() {
        if (!isEmpty()) {
            int lch = leftChild.height();
            int rch = rightChild.height();

            if (lch >= rch) {
                return lch + 1;
            } else {
                return rch + 1;
            }
        } else {
            return 0;
        }
    }

    // 5 - Methode int countCharacters()
    // Implementiere eine Methode countCharacters,
    // die die Summe der quantity-Werte aller HuffmanTriple-Objekte
    // im Baum bildet. Ein leerer Baum besitzt kein
    // HuffmanTriple-Objekt, liefert also als Ergebnis 0.
    public int countCharacters() {
        if (isEmpty()) {
            return 0;
        } else {
            return this.getContent().getQuantity() + leftChild.countCharacters() + rightChild.countCharacters();
        }
    }

    // 6 - Methode int longestCode()
    // Implementiere eine Methode longestCode,
    // die die Länge der längsten Kodierung aus allen
    // HuffmanTriple-Objekten des Baums bestimmt.
    // Ein leerer Baum besitzt kein HuffmanTriple-Objekt
    // und damit auch keine Kodierung, liefert also
    // als Ergebnis 0.
    public int longestCode() {
        if (isEmpty()) {
            return 0;
        } else {
            int cL = getContent().getCode().length();
            int lCL = leftChild.longestCode();
            int rCL = rightChild.longestCode();

            if (cL > lCL && cL > rCL) {
                return cL;
            } else {
                if (lCL >= rCL) {
                    return lCL;
                } else {
                    return rCL;
                }
            }

        }
    }

    // 7 - Methode HuffmanTriple minimum()
    // Implementiere eine Methode minimum, die das
    // HuffmanTriple-Objekt mit dem kleinsten im Baum
    // gespeicherten token-Zeichen liefert.
    // Implementiere minimum mit einem
    // nicht-rekursiven Algorithmus.
    // Beachte dabei, dass ein binärer Suchbaum vorliegt.
    // Wird die Methode für den leeren Teilbaum aufgerufen,
    // soll null zurückgegeben werden.
    public HuffmanTriple minimum() {
        if (isEmpty()) {
            return null;
        } else {
            CharacterSearchTree current = this;

            while (!current.leftChild.isEmpty()) {
                current = current.leftChild;
            }
            return current.getContent();
        }
    }

    // 8 - Methode boolean hasOnlyCompleteNodes()
    // Implementiere eine Methode hasOnlyCompleteNodes,
    // die prüft, ob in einem Baum keine Knoten mit nur
    // einem Nachfolger vorkommen. In diesem Fall soll true
    // zurückgegeben werden, sonst false.
    // Ein leerer Baum soll true liefern.
    public boolean hasOnlyCompleteNodes() {
        if (isEmpty() || isLeaf()) {
            return true;
        } else {
            if (!leftChild.isEmpty() && !rightChild.isEmpty()) {

                return leftChild.hasOnlyCompleteNodes() && rightChild.hasOnlyCompleteNodes();
            } else {
                return false;
            }
        }
    }

    // 9 - Methode boolean containsCharacter( char t )
    // Implementiere eine Methode containsCharacter, die prüft,
    // ob ein als Parameter übergebenes Zeichen im Baum als Wert
    // des Attributs token eines HuffmanTriple-Objekts auftritt.
    // In diesem Fall soll true zurückgegeben werden, sonst
    // false. Ein leerer Baum soll false liefern.
    public boolean containsCharacter(char t) {
        if (isEmpty()) {
            return false;
        } else {
            char cT = this.getContent().getToken();
            if (cT == t) {
                return true;
            } else if (t < cT) {
                return leftChild.containsCharacter(t);
            } else {
                return rightChild.containsCharacter(t);
            }
        }
    }

    // 10 - Methode
    // boolean equalStructure(CharacterSearchTree cst)
    // Implementiere eine Methode equalStructure, die einen
    // Parameter des Typs CharacterSearchTree besitzt.
    // Die Methode soll true zurückgeben, falls der aufrufende
    // Baum und der als Argument übergebene Baum die gleiche
    // Struktur besitzen, also an den gleichen Positionen
    // in den Bäumen Knoten bzw. Nachfolger auftreten.
    // Die Inhalte der Knoten sollen dabei
    // unberücksichtigt bleiben.
    public boolean equalStructure(CharacterSearchTree cst) {
        if (this.isEmpty() && cst.isEmpty()) {
            return true;
        }

        if (this.height() != cst.height()) {
            return false;
        } else {
            return leftChild.equalStructure(cst.leftChild) && rightChild.equalStructure(cst.rightChild);
        }

    }

    // 11 - Methode CharacterSearchTree rotateNodeToRight()
    // Implementiere eine Methode rotateNodeToRight,
    // die eine Rückgabe vom Typ CharacterSearchTree liefert.
    // Die Methode soll den Baum derart umformen, dass das
    // linke Kind der Wurzel zur (neuen) Wurzel wird.
    // Die Teilbäume der betroffenen Knoten sollen unverändert
    // bleiben. Die neue Wurzel soll zurückgegeben werden.
    // Ist der Baum leer oder besitzt die Wurzel kein
    // linkes Kind, soll nichts geschehen
    // und die (alte) Wurzel zurückgegeben werden.
    //
    // Hinweis: Beachte, dass das folgende Beispiel nur einen
    // Sonderfall der Rotation behandelt.
    //
    // Beispiel
    //
    // ------------11
    // -------10--------15
    // ----6----x-----14---x
    // --3---9
    // >>>>>>
    // ------------10
    // ------6----------11
    // --3-----9-----x-----15
    // -x--x--x--x------14---x
    //
    public CharacterSearchTree rotateNodeToRight() {
        CharacterSearchTree newRoot = this;
        if (!isEmpty() && !leftChild.isEmpty()) {
            newRoot = leftChild;
            leftChild = newRoot.rightChild;
            newRoot.rightChild = this;
        }
        return newRoot;

    }

    // 12 - Methode boolean samePath( char t1, char t2 )
    // Implementiere eine Methode
    // boolean samePath( char t1, char t2 ),
    // die true liefern soll, wenn es einen direkten Pfad
    // zwischen der Wurzel und einem (beliebigen) Blatt gibt,
    // auf dem (in beliebiger Reihenfolge) ein
    // HuffmanTriple-Objekt dem dem Zeichen t1 als Attributwert
    // von token und ein HuffmanTriple-Objekt dem
    // dem Zeichen t2 als Attributwert von token liegen.
    // Sonst soll false zurückgegeben werden.
    public boolean samePath(char t1, char t2) {
        if (isEmpty()) {
            return false;
        } else {
            boolean foundT1 = false;
            boolean foundT2 = false;
            CharacterSearchTree current = this;

            while (!current.isEmpty()) {
                char cT = current.getContent().getToken();
                if (cT == t1)
                    foundT1 = true;
                if (cT == t2)
                    foundT2 = true;

                if (foundT1 && foundT2) {
                    break;
                } else if (!foundT1 && !foundT2) {
                    if (cT > t1 && cT > t2) {
                        current = current.leftChild;
                    } else if ((cT < t1 && cT < t2)) {
                        current = current.rightChild;
                    }
                } else if (!foundT1 && foundT2) {
                    if (cT > t1) {
                        current = current.leftChild;
                    } else {
                        current = current.rightChild;
                    }
                } else if (foundT1 && !foundT2) {
                    if (cT > t2) {
                        current = current.leftChild;
                    } else {
                        current = current.rightChild;
                    }
                }

            }

            return foundT1 && foundT2;
        }
    }
}
