public class SubtotalOfThreeElementsStrategy
extends DoublyLinkedList.InsertionStrategy<Integer>
{
    private int subtotal;
    private int count;
    
    public SubtotalOfThreeElementsStrategy()
    {
        subtotal = 0;
        count = 0;
    }
    
    public boolean select( Integer ref )
    {
        count++;
        subtotal += ref;
        return count % 3 == 0;
    }
    
    public Integer toInsert( Integer ref )
    {
        int temp = subtotal;
        subtotal = 0;
        return temp;
    }
}