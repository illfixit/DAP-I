public class DoubleAllInIntervalStrategy 
extends DoublyLinkedList.SubstitutionStrategy<Integer>
{
    private int lowerBound, upperBound;
    public DoubleAllInIntervalStrategy( int low, int up )
    {
        lowerBound = low;
        upperBound = up;
    }
    
    public Integer substitute( Integer ref )
    {
        if ( ref >= lowerBound && ref <= upperBound )
        {
            return 2 * ref;
        }
        else
        {
            return ref;
        }
    }
}