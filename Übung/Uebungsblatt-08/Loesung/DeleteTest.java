public class DeleteTest
{
    public static void main( String[] args )
    {
        testMethods();
    }

    private static void testMethods()
    {
        // k d b f h s o p x v
        CharacterSearchTree cst = new CharacterSearchTree();
        cst.add('k'); cst.add('d'); cst.add('b'); cst.add('f'); cst.add('h'); cst.add('s'); cst.add('o'); 
        cst.add('p'); cst.add('x'); cst.add('v');         
        System.out.println("Testbaum aufgebaut - SOLL-Ergebnis: b d f h k o p s v x");
        cst.show();
        cst.delete();
        System.out.println("Wurzel geloescht) - SOLL-Ergebnis: b d f h o p s v x");
        cst.show();

    }
}
