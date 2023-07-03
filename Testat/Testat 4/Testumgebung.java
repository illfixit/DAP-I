public class Testumgebung
{
    public static void main( String args[] )
    {

        // Beispiel 1
        Fraction[] arr1 = { new Fraction(0,1), new Fraction(1,5), new Fraction(11,6), new Fraction(1,5), new Fraction(1,10), new Fraction(1,1) };
        Fraction f1 = new Fraction(1,2);
        System.out.println( Testat.apply( arr1, f1, 5 ).toString() );

        //Beispiel 2
        Fraction[] arr2 = { new Fraction(2,5), new Fraction(11,6), new Fraction(1,1), new Fraction(1,10), new Fraction(2,1) };
        Fraction f2 = new Fraction(1,3);
        System.out.println( Testat.apply( arr2, f2, 4 ).toString() );
        
        //Beispiel 3
        Fraction[] arr3 = { new Fraction(2,1), new Fraction(6,7), new Fraction(8,7) };
        Fraction f3 = new Fraction(1,2);
        System.out.println( Testat.apply( arr3, f3, 2 ).toString() );
        
        //Beispiel 4
        Fraction[] arr4 = { new Fraction(2,7) };
        Fraction f4 = new Fraction(1,2);
        System.out.println( Testat.apply( arr4, f4, 0 ).toString() );
        
        //Beispiel 5
        Fraction[] arr5 = { new Fraction(7,2) };
        Fraction f5 = new Fraction(1,2);
        System.out.println( Testat.apply( arr5, f5, 0 ).toString() );
        
        //Beispiel 6
        Fraction[] arr6 = { new Fraction(1,5), new Fraction(11,6), new Fraction(1,5), new Fraction(1,10), new Fraction(1,1) };
        Fraction f6 = new Fraction(1,2);
        System.out.println( Testat.apply( arr6, f6, -1 ).toString() );
        
        //Beispiel 7
        Fraction[] arr7 = { new Fraction(1,5), new Fraction(11,6), new Fraction(1,5), new Fraction(1,10), new Fraction(1,1) };
        Fraction f7 = new Fraction(1,2);
        System.out.println( Testat.apply( arr7, f7, 5 ) );
        
        //Beispiel 8
        Fraction[] arr8 = {};
        Fraction f8 = new Fraction(1,2);
        System.out.println( Testat.apply( arr8, f8, 1 ).toString() );
        
    }
    
}

