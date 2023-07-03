public class MethodsTestat2
{
    
    public static Fraction countNegatives( Fraction[] arr )
    {
        int count = 0;
        for ( Fraction f : arr )
        {
            if ( f.toDouble() < 0 )
            {
                count++;
            }
        }
        return new Fraction( count );
    }
    
    public static Fraction sumUpNegatives( Fraction[] arr )
    {
        Fraction sum = new Fraction();
        for ( Fraction f : arr )
        {
            if ( f.toDouble() < 0 )
            {
                sum = sum.add(f);
            }
        }
        return sum;
    }
    
    public static Fraction maximum( Fraction[] arr )
    {
        if ( arr.length == 0 ) 
        {
            return null;
        }
        Fraction max = arr[0];
        for ( Fraction f : arr )
        {
            if (max.toDouble() < f.toDouble() )
            {
                max = f;
            }
        }                   
        return max;
    }

    public static Fraction countMaximum( Fraction[] arr )
    {
        int count = 0;
        Fraction max = maximum( arr );
        for ( Fraction f : arr )
        {
            if ( f.equals( max ) )
            {
                count++;
            }
        }
        return new Fraction ( count );
    }
    public static boolean isSorted( Fraction[] arr )
    {
        for ( int i=1; i < arr.length; i++ )
        {
            if ( arr[i-1].toDouble() >= arr[i].toDouble() )
            {
                return false;
            }
        }
        return true; 
    }
    
    public static Fraction[] increaseArray( Fraction[] arr, Fraction z )
    {
        for ( int i=0; i < arr.length; i++ )
        {
            arr[i] = arr[i].add( z );
        }
        return arr;
    }
    
    public static Fraction[] doubleIfContainsPositive( Fraction[] arr )
    {
        for ( Fraction f : arr )
        {
            if ( f.toDouble() > 0 )
            {
                for ( int i=0; i < arr.length; i++ )
                {
                    arr[i] = arr[i].multiply( new Fraction( 2 ));
                }
                return arr;
            }
        }
        return arr;          
    }

    public static String toString( Fraction[] arr )
    {
        String result = "";
        for( int i=0; i < arr.length; i++ )
        {
            result = result + arr[i].toString();
            if ( i < arr.length-1 )
            {
                result = result + ", ";
            }
        }
        return result;
    }

    public static Fraction[] selectNegatives( Fraction[] arr )
    {
        Fraction[] negativeValues = new Fraction[(int)(countNegatives( arr ).toDouble())];
        int position = 0;
        for ( Fraction f : arr )
        {
            if ( f.toDouble() < 0 )
            {
                negativeValues[position] = f;
                position++;
            }
        }
        return negativeValues;
    }

    public static Fraction countSequences( Fraction[] arr )
    {
        int count = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if ( arr[i].equals( new Fraction() ) && ! arr[i-1].equals( new Fraction() ) )
            {
                count++;
            }
        }
        if ( ! arr[arr.length-1].equals(new Fraction() ) )
        {
            count++;
        }
        return new Fraction( count );
    }

    
}
