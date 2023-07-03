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
    }
}
