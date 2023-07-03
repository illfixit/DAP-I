public class RemoveAndCountAllInIntervalStrategy
extends DoublyLinkedList.DeletionStrategy<Integer>
{
    private int lowerBound, upperBound;
    private int quantity;
    
    public RemoveAndCountAllInIntervalStrategy( int low, int up )
    {
        lowerBound = low;
        upperBound = up;
        quantity = 0;
    }
    
    public boolean select( Integer ref )
    {
        if( ref >= lowerBound && ref <= upperBound )
        {
            quantity++;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
}