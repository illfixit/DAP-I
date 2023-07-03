public class CountXStrategy 
extends DoublyLinkedList.InspectionStrategy<Integer>
{
    private int toCount;
    private int quantity;

    public CountXStrategy( int x )
    {
        toCount = x;
        quantity = 0;
    }

    public void inspect( Integer ref )
    {
        if ( ref == toCount ) 
        {
            quantity++;
        }
    }

    public int getQuantity()
    {
        return quantity;
    }
    
}