public class Testumgebung
{
    public static void main( String[] args )
    {
        testDoublyLinkedList();
    }
        
    public static void testDoublyLinkedList()
    {
        DoublyLinkedList integers = new DoublyLinkedList();
        integers.add( 4 );
        integers.add( 5 );
        integers.add( 6 );
        integers.add( 9 );
        integers.add( 7 );
        integers.add( 17 );
        integers.add( 11 );
        integers.add( 4 );
        integers.showAll();

        System.out.println( "getLast(): " + integers.getLast() + " (erwartetes Ergebnis: 4)" );
        System.out.println( "contains(9): " + integers.contains( 9 ) + " (erwartetes Ergebnis: true)"  );
        System.out.println( "contains(27): " + integers.contains( 27 ) + " (erwartetes Ergebnis: false)"  );
        System.out.println( "count(4): " + integers.count( 4 ) + " (erwartetes Ergebnis: 2)" );
        System.out.println( "containsDouble(): " + integers.containsDouble() + " (erwartetes Ergebnis: true)"  );
        System.out.print( "insert(4,1): "); integers.insert(4,1); integers.showAll();
        System.out.print( "toArray(): " ); Integer[] arr = new Integer[integers.size()]; integers.toArray( arr ); for( Integer i : arr ) { System.out.print( i + " " ); } System.out.println();
        System.out.print( "toArray(): " ); arr = new Integer[integers.size()-1]; integers.toArray( arr ); for( Integer i : arr ) { System.out.print( i + " " ); } System.out.println();
        System.out.print( "toArray(): " ); arr = new Integer[integers.size()+1]; integers.toArray( arr ); for( Integer i : arr ) { System.out.print( i + " " ); } System.out.println();
        System.out.print( "flip(): " ); DoublyLinkedList d = integers.flip(); d.showAll();
        System.out.print( "remove(4): "); integers.remove(4); integers.showAll();
        System.out.print( "remove(0): "); integers.remove(0); integers.showAll();
        
        integers.add(17);
        integers.add(17);
        System.out.print( "remove(new Integer(17)): ");  integers.remove(new Integer(17)); integers.showAll();
        DoublyLinkedList integers2 = new DoublyLinkedList();
        integers2.add( 24 );
        integers2.add( 25 );
        integers2.add( 26 );
        integers2.add( 29 );
        integers2.add( 27 );
        integers2.add( 27 );
        integers2.add( 21 );
        integers2.add( 24 );
        System.out.print( "concat(integers2): "); integers.concat(integers2); integers.showAll();
        System.out.print( "Konstruktor: "); DoublyLinkedList integers3 = new DoublyLinkedList(integers); integers3.showAll();
        DoublyLinkedList integers4  = integers3.subList( 2, 7 ); 
        System.out.print( "integer3.sublist(2,7) (ohne to-Index) - Ausgangsliste: "); integers3.showAll();
        System.out.print( "integer3.sublist(2,7) (ohne to-Index) - Subliste: "); integers4.showAll();
        System.out.print( "integers.removeAll(integers4): "); integers.removeAll(integers4); integers.showAll();
        System.out.print( "integers.clear(): "); integers.clear(); integers.showAll();
        System.out.println( "integers4.allEqual(): " + integers4.allEqual()  + " (erwartetes Ergebnis: false)");
        DoublyLinkedList integersAllEqual = new DoublyLinkedList();
        integersAllEqual.add(5);
        integersAllEqual.add(5);
        integersAllEqual.add(5);
        integersAllEqual.add(5);
        integersAllEqual.add(5);
        System.out.println( "integersAllEqual.allEqual(): " + integersAllEqual.allEqual() + " (erwartetes Ergebnis: true)" );
        
    }
}
