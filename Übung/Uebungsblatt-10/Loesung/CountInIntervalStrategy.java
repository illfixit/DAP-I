public class CountInIntervalStrategy 
extends DoublyLinkedList.InspectionStrategy<Integer>
{
    private int lowerBound, upperBound;
    private int quantity;

    public CountInIntervalStrategy( int low, int up )
    {
        lowerBound = low;
        upperBound = up;
        quantity = 0;
    }

    public void inspect( Integer ref )
    {
        if ( ref >= lowerBound && ref <= upperBound ) 
        {
            quantity++;
        }
    }

    public int getQuantity()
    {
        return quantity;
    }
    
}