public class AddExpressions
{
    public static boolean addCalcExists( int[] values, int position, int result )
    {
        if ( position == values.length )
        {
            return result == 0;
        } else {
            if ( addCalcExists( values, position+1, result + values[position] ) )
            {
                return true;
            }
            return addCalcExists( values, position+1, result - values[position] );
        }
    }
    
    public static String addCalcExp( int[] values, int position, int result, String exp )
    {
        if ( position == values.length )
        {
            if ( result == 0 )
            {
                return exp;
            } else {
                return "calculation impossible";
            }
        } else {
            String s = addCalcExp( values, position+1, result + values[position], exp + "+" + values[position] );
            if ( ! s.equals( "calculation impossible" ) )
            {
                return s;
            }
            return addCalcExp( values, position+1, result - values[position], exp + "-" + values[position] );
        }
    }
    
    public static void main( String[] args )
    {
        System.out.println( addCalcExists( new int[]{5,3,2,4,1,0,3}, 0, 0 ) );
        System.out.println( addCalcExists( new int[]{5,5,5}, 0, 0 ) );
        System.out.println( addCalcExists( new int[]{5}, 0, 0 ) );
       
        System.out.println( addCalcExp( new int[]{5,3,2,4,1,0,3}, 0, 0, "" ) );
        System.out.println( addCalcExp( new int[]{5,5,5}, 0, 0, "" ) );
    }
}