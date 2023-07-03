public class RemoveAllInIntervalStrategy
extends DoublyLinkedList.DeletionStrategy<Integer>
{
    private int lowerBound, upperBound;
    
    public RemoveAllInIntervalStrategy( int low, int up )
    {
        lowerBound = low;
        upperBound = up;
    }
    
    public boolean select( Integer ref )
    {
        return ref >= lowerBound && ref <= upperBound;
    }
}