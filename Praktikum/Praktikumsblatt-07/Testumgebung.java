public class Testumgebung
{
    public static void main( String[] args )
    {
        IntIntPairs testPairs = new IntIntPairs( 20 );
        testPairs.put(7,3); testPairs.put(4,3); testPairs.put(1,-9); testPairs.put(6,6); testPairs.put(2,8); 
        testPairs.put(41,12); testPairs.put(9,-11); testPairs.put(8,12); testPairs.put(5,-60); testPairs.put(14,18); 
        testPairs.put(0,12); testPairs.put(-9,-16); testPairs.put(0,0); testPairs.put(17,32); testPairs.put(1,1);

        System.out.println("Beispiel: " + testPairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } ) );

        System.out.print("Beispiel: " + sumUp( testPairs ) ); System.out.println();

    }
    
    public static int sumUp(IntIntPairs pairs)
    {
        return pairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } );
    }
    
//     public static void addNToValue( IntIntPairs pairs, int n )
//     {
//         // hier ergaenzen
//     }
//     
//     public static boolean uniqueKey( IntIntPairs pairs, int n )
//     {
//         // hier ergaenzen        
//     }
//     
//     public static void doubleGreaterN( IntIntPairs pairs, int n )
//     {
//         // hier ergaenzen
//     }
//     
//     public static IntIntPairs concat(IntIntPairs first, IntIntPairs second)
//     {
//         // hier ergaenzen
//     }
}
