public class TreeTestComplete
{
    public static void main( String[] args )
    {
        testMethods();
    }
    
    private static void testMethods()
    {
        char[] chars = {'n','d','a','f','b','e','e','k','i','x','o','n','x','e','s','z','r'};
        CharacterSearchTree cst = new CharacterSearchTree( chars );
        System.out.println("cst.show() - SOLL-Ergebnis: a b d e f i k n o r s x z");
        cst.show();
        System.out.println("\ncst.showPreorder() - SOLL-Ergebnis: n d a b f e k i x o s r z");
        cst.showPreorder();
        System.out.println("\ncst.height() - SOLL-Ergebnis: 5");
        System.out.println( cst.height() );
        System.out.println("\ncst.countCharacters() - SOLL-Ergebnis: 17");
        System.out.println( cst.countCharacters() );
        System.out.println("\ncst.minimum() - SOLL-Ergebnis: a");
        System.out.println( cst.minimum() );
        System.out.println("\ncst.hasOnlyCompleteNodes() - SOLL-Ergebnis: false");
        System.out.println( cst.hasOnlyCompleteNodes() );
        System.out.println("\ncst.containsCharacter('f') - SOLL-Ergebnis: true");
        System.out.println( cst.containsCharacter( 'f' ) );
        System.out.println("\ncst.containsCharacter('r') - SOLL-Ergebnis: true");
        System.out.println( cst.containsCharacter( 'r' ) );
        System.out.println("\ncst.containsCharacter('m') - SOLL-Ergebnis: false");
        System.out.println( cst.containsCharacter( 'm' ) );
        System.out.println();
        System.out.println("cst.add( 'r', 6, 01 ); cst.add( 'e', 5, 001 ) - SOLL-Ergebnis: r mit 7 und 01, e mit 8 und 001");
        cst.add( 'r', 6, "01" ); cst.add( 'e', 5, "001" );
        cst.show();
        
        System.out.println("\ncst.longestCode() - SOLL-Ergebnis: 3");
        System.out.println( cst.longestCode() );
        System.out.println();
        
        System.out.println("\ncst.add( 'j', 2, 001 ); cst.add( 'a', 1, 00110 ) - SOLL-Ergebnis: j mit 2 und 001, a mit 2 und 00110");
        cst.add( 'j', 2, "001" ); cst.add( 'a', 1, "00110" );
        cst.show();
        
        System.out.println("\ncst.longestCode() (Baum geaendert) - SOLL-Ergebnis: 5");
        System.out.println( cst.longestCode() );
        System.out.println();
        
        System.out.println("\ncst.height() (Baum geaendert) - SOLL-Ergebnis: 6");
        System.out.println( cst.height() );
        System.out.println("\ncst.countCharacters() (Baum geaendert) - SOLL-Ergebnis: 31");
        System.out.println( cst.countCharacters() );
        cst.iterativeAdd( '-' );
        System.out.println("\ncst.minimum() (Baum geaendert) - SOLL-Ergebnis: -");
        System.out.println( cst.minimum() );
        System.out.println("\ncst.rotateNodeToRight() (Baum geaendert) - SOLL-Ergebnis: d a - b n f e k i j x o s r z");
        cst = cst.rotateNodeToRight();
        cst.showPreorder();
        
        char[] chars2 = {'k','f','m','b','g','l','n','a','c'};
        CharacterSearchTree cst2 = new CharacterSearchTree( chars2 );
        System.out.println("\ncst2.hasOnlyCompleteNodes() - SOLL-Ergebnis: true");
        System.out.println( cst2.hasOnlyCompleteNodes() );
        
        char[] chars3 = {'k','f','m','b','g','l','n','a','c'};
        CharacterSearchTree cst3 = new CharacterSearchTree( chars3 );
        System.out.println("\ncst2.equalStructure(cst3) - SOLL-Ergebnis: true");
        System.out.println( cst2.equalStructure(cst3) );

        cst3.iterativeAdd( 'x' );
        System.out.println("\ncst2.equalStructure(cst3) (Baum geaendert) - SOLL-Ergebnis: false");
        System.out.println( cst2.equalStructure(cst3) );
        System.out.println();
      
    }

}

