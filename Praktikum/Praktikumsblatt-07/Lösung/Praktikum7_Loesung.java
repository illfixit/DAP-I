public class Testumgebung
{
    public static void main( String[] args )
    {
        IntIntPairs testPairs = new IntIntPairs( 20 );
        testPairs.put(7,3); testPairs.put(4,3); testPairs.put(1,-9); testPairs.put(6,6); testPairs.put(2,8); 
        testPairs.put(41,12); testPairs.put(9,-11); testPairs.put(8,12); testPairs.put(5,-60); testPairs.put(14,18); 
        testPairs.put(0,12); testPairs.put(-9,-16); testPairs.put(0,0); testPairs.put(17,32); testPairs.put(1,1);
        testPairs.show();  System.out.println();
        System.out.println("Beispiel: " + testPairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } ) );
        System.out.println("# even key: " + testPairs.accumulate( (k,v) -> { if (k%2==0) { return 1; } else { return 0; } }  ) );
        System.out.println("# value > 10: " + testPairs.accumulate( (k,v) -> { if (v>10) { return 1; } else { return 0; } }  ) );
        System.out.println("sum of all values: " + testPairs.accumulate( (k,v) ->  v ) );
        System.out.print("all keys +10: "); testPairs.manipulate( (k,v) -> k+10, (k,v) -> v ); testPairs.show(); System.out.println();
        System.out.print("some keys +5: "); testPairs.manipulate( (k,v) -> { if (v>3) { return k+5; } else { return k; } }, (k,v) -> v ); testPairs.show(); System.out.println();
        System.out.print("all values *2: "); testPairs.manipulate( (k,v) -> k, (k,v) -> 2*v ); testPairs.show(); System.out.println();
        testPairs.put(8,8); testPairs.put(-2,-2);
        System.out.print("remove k==v: "); testPairs.remove( (k,v) -> k==v ); testPairs.show(); System.out.println();
        System.out.print("remove 6: "); testPairs.remove( (k,v) -> k==6 ); testPairs.show(); System.out.println();
        System.out.print("remove negative values: "); testPairs.remove( (k,v) -> v<0 ); testPairs.show(); System.out.println();
        System.out.print("copy: "); IntIntPairs otherPairs = testPairs.extract( (k,v) -> true ); otherPairs.show(); System.out.println();
        System.out.print("extract multiples of 3: "); otherPairs = testPairs.extract( (k,v) -> v%3==0 ); otherPairs.show(); System.out.println();
        System.out.print("extract values >5: "); otherPairs = testPairs.extract( (k,v) -> v>5 ); otherPairs.show(); System.out.println();
        System.out.print("sumUp: " + sumUp( testPairs ) ); System.out.println();
        System.out.print("add 4 to value: "); addNToValue( testPairs, 4 ); testPairs.show(); System.out.println();
        System.out.print("unique 17: " + uniqueKey( testPairs, 17 )); System.out.println(); 
        System.out.print("unique 14: " + uniqueKey( testPairs, 14 )); System.out.println();
        System.out.print("double >20: "); doubleGreaterN( testPairs, 20 ); testPairs.show(); System.out.println();
        testPairs.show();
        otherPairs.show();
        concat( testPairs, otherPairs ).show(); 
        System.out.println();
    }
    
    public static int sumUp(IntIntPairs pairs)
    {
        return pairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } );
    }
    
    public static void addNToValue( IntIntPairs pairs, int n )
    {
        pairs.manipulate( (k,v) -> k, (k,v) -> v+n );
    }
    
    public static boolean uniqueKey( IntIntPairs pairs, int n )
    {
        return pairs.accumulate( (k,v) -> { if (k==n) { return 1; } else { return 0; } } ) == 1;        
    }
    
    public static void doubleGreaterN( IntIntPairs pairs, int n )
    {
        IntIntPairs greater = pairs.extract( (k,v) -> k>n ); 
        greater.manipulate( (k,v) -> k, (k,v) -> 2*v );
        pairs.combine( greater );
    }
    
    public static IntIntPairs concat(IntIntPairs first, IntIntPairs second)
    {
        IntIntPairs all = new IntIntPairs( first.accumulate( (k,v) -> 1 ) + second.accumulate( (k,v) -> 1 ) ); 
        all.combine( first );
        all.combine( second );
        return all;
    }
}
