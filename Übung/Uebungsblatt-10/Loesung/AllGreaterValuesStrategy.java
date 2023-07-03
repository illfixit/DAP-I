import java.util.*;

public class AllGreaterValuesStrategy
extends DoublyLinkedList.InspectionStrategy<Integer>
{
    private Set<Integer> values;
    private int limit;

    public AllGreaterValuesStrategy( int x )
    {
        values = new TreeSet<>();
        limit = x;
    }

    public void inspect( Integer i )
    {
        if ( i > limit )
        {
            values.add( i );
        }
    }

    Set<Integer> getValues()
    {
        return values;
    }
}
