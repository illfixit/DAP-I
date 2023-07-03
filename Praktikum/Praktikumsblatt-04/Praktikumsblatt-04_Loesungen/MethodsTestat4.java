public class MethodsTestat4
{

    public static Fraction maximum( Fraction[] arr, int i )
    {
        if ( i<0 || i>=arr.length ) 
        {
            throw new RuntimeException(); 
        }        
        if ( i == 0 )
        {
            return arr[0];   
        }
        else
        {
            Fraction max = maximum( arr, i-1 );
            if ( arr[i].toDouble() > max.toDouble() ) 
            {
                return arr[i];
            }
            else
            {
                return max;
            }
        }
    }    

    public static Fraction lastPositive( Fraction[] arr, int i )
    {
        if ( i<0 || i>=arr.length ) 
        {
            throw new RuntimeException(); 
        }        
        if ( i == 0 )
        {
            if ( arr[0].toDouble() > 0 ) 
            {
                return arr[0];
            }
            else
            {
                return null;  
            }
        }
        else
        {

            if ( arr[i].toDouble() > 0 ) 
            {
                return arr[i];
            }
            else
            {
                return lastPositive( arr, i-1 );
            }
        }
    }    
    public static Fraction firstPositive( Fraction[] arr, int i )
    {
        if ( i<0 || i>=arr.length ) 
        {
            throw new RuntimeException(); 
        }        
        if ( i == 0 )
        {
            if ( arr[0].toDouble() > 0 ) 
            {
                return arr[0];
            }
            else
            {
                return null;  
            }
        }
        else
        {
            Fraction first = firstPositive( arr, i-1 );
            if ( first == null && arr[i].toDouble() > 0 ) 
            {
                return arr[i];
            }
            else
            {
                return first;
            }
        }
    }    

    public static boolean isSorted( Fraction[] arr, int i )
    {        
        if ( i<0 || i>=arr.length ) 
        {
            throw new RuntimeException(); 
        } 
        else
        {
            if ( i == 0 )
            {
                return true;    // gibt auch true zurueck fuer Felder der Laenge 1
            }
            else
            {
                return arr[i-1].toDouble() < arr[i].toDouble() && isSorted( arr,i-1 );
            }
        }
    }

    public static boolean contains( Fraction[] arr, int i, Fraction x )
    {     
        if ( i<0 || i>=arr.length ) 
        {
            throw new RuntimeException(); 
        }
        else
        {
            if (i==0)
            { 
                return ( arr[0].equals( x ) );
            }
            else
            {
                return arr[i].equals( x ) || contains( arr, i-1, x );
            }
        }
    }

    public static int countPositives( Fraction[] arr, int d, int t )
    {     
        if ( d<0 || d > t || t>=arr.length )       
        {
            throw new RuntimeException(); 
        }
        else
        {
            if (t==d)
            { 
                if ( arr[d].toDouble() > 0 )
                {
                    return 1;
                } else {
                    return 0;
                }
            }
            else
            {
                if ( arr[t].toDouble() > 0 )
                {
                    return 1 + countPositives( arr, d, t-1 );
                } else {
                    return countPositives( arr, d, t-1 );
                }
            }
        }
    }    

    public static boolean contentCheck( Fraction[] arr1, Fraction[] arr2, int i )
    {
        if ( i<0 || i>arr1.length-1 || i>arr2.length-1 )
        {
            throw new RuntimeException(); 
        }
        else
        {
            if ( i==0 )
            {
                return arr1[0].equals( arr2[0] );   
            }
            else
            {
                if ( ! arr1[i].equals( arr2[i] ) )
                {
                    return false;   
                }
                else
                {
                    return contentCheck( arr1, arr2, i-1 );   
                }
            }     
        }
    }    

    public static boolean palindromCheck( Fraction[] arr, int i )
    {
        if ( i<0 || i>arr.length-1 )
            return false;
        else
        {
            int j=arr.length-1-i; /* rechter Index */
            if ( i >= j )
            {
                return true;
            }
            else
            {
                return arr[i].equals( arr[j] ) && palindromCheck( arr, i+1 );
            }
        }
    }  

    public static int getIndex( Fraction[] arr, int i, Fraction x )
    {
        if ( i < 0 || i>arr.length-1 )
        {
            return -1;
        }
        else
        {
            int lower = getIndex( arr, i-1, x );
            if ( lower != -1 || ! arr[i].equals( x ) )
            {
                return lower;
            }
            else
            {
                return i;
            }
        }
    }

}

    