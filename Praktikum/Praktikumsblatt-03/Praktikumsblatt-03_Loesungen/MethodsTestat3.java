public class MethodsTestat3
{

    public static int digitSum( int n ) 
    {
        n = Math.abs( n );
        if ( n < 10 )
        {
            return n;
        }
        else
        {
            return n % 10 + digitSum( n/10 );
        }
    }

    public static int power( int a, int n )
    {
        if ( n < 0 || a == 0)
        {
            return 0;
        }
        else 
        {
            if ( n == 0 )     // Abbruchbedingung
            {
                return 1;
            }
            else            // rekursiver Aufruf
            {
                return a * power( a, n-1 );
            }
        }
    }

    public static int sumUpNegatives( int[] arr, int n )
    {     
        if ( n<0 || n>=arr.length )       
        {
            return 0; 
        }
        else
        {
            if ( n == 0 )
            { 
                if ( arr[0] < 0 )
                {
                    return arr[0];
                } 
                else 
                {
                    return 0;
                }
            }
            else
            {
                if ( arr[n] < 0 )
                {
                    return arr[n] + sumUpNegatives( arr, n-1 );
                } 
                else 
                {
                    return sumUpNegatives( arr, n-1 );
                }
            }
        }
    }
    
    public static int countPositives( int[] arr, int n )
    {     
        if ( n<0 || n>=arr.length )       
        {
            return 0; 
        }
        else
        {
            if ( n == 0 )
            { 
                if ( arr[0] > 0 )
                {
                    return 1;
                } 
                else 
                {
                    return 0;
                }
            }
            else
            {
                if ( arr[n] > 0 )
                {
                    return 1 + countPositives( arr, n-1 );
                } 
                else 
                {
                    return countPositives( arr, n-1 );
                }
            }
        }
    }

    public static int countPositivesLimited(int[] arr, int d, int t)
    {     
        if ( d<0 || d > t || t>=arr.length )       
        {
            throw new RuntimeException(); 
        }
        else
        {
            if (t==d)
            { 
                if ( arr[d] > 0 )
                {
                    return 1;
                } else {
                    return 0;
                }
            }
            else
            {
                if ( arr[t] > 0 )
                {
                    return 1 + countPositivesLimited( arr, d, t-1 );
                } else {
                    return countPositivesLimited( arr, d, t-1 );
                }
            }
        }
    }

    public static int maximum( int[] arr, int i )
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
            int max = maximum( arr, i-1 );
            if ( arr[i] > max ) 
                return arr[i];
            else
                return max;
        }
    }    

    public static boolean isSorted( int[] arr, int i )
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
                return arr[i-1] < arr[i] && isSorted( arr,i-1 );
            }
        }
    }

    public static boolean contains( int[] arr, int i, int x )
    {     
        if ( i<0 || i>=arr.length ) 
        {
            throw new RuntimeException(); 
        }
        else
        {
            if (i==0)
            { 
                return ( arr[0]==x );
            }
            else
            {
                return arr[i]==x || contains( arr, i-1, x );
            }
        }
    }

    public static boolean contentCheck( char[] arr1, char[] arr2, int i )
    {
        if ( i<0 || i>arr1.length-1 || i>arr2.length-1 )
        {
            throw new RuntimeException(); 
        }
        else
        {
            if ( i==0 )
            {
                return arr1[0] == arr2[0];   
            }
            else
            {
                if (arr1[i] != arr2[i])
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

    public static boolean palindromCheck( char[] arr, int i )
    {
        if ( i<0 || i>arr.length-1 )
            return false;
        else
        {
            int j=arr.length-1-i; /* linker Index */
            if ( i <= j )
            {
                return true;
            }
            else
            {
                return arr[i] == arr[j] && palindromCheck( arr, i-1 );
            }
        }
    }  

    public static int getIndex( int[] arr, int i, int x )
    {
        if ( i < 0 || i>arr.length-1 )
        {
            return -1;
        }
        else
        {
            int lower = getIndex( arr, i-1, x );
            if ( lower != -1 || arr[i] != x )
            {
                return lower;
            }
            else
            {
                return i;
            }
        }
    }

    public static String toString( int[] arr, int i )
    {
        if ( i < 0 || i >= arr.length )
        { 
            return "";
        }
        else
        {
            if ( i == 0 )
            {
                return arr[0] + "";
            }
            else
            { 
                return toString( arr, i-1 ) + "," + arr[i];
            }
        }
    }
    
}

    