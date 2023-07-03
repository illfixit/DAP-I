public class RemoveSmallerThanPredecessorStrategy
extends DoublyLinkedList.DeletionStrategy<Integer>
{
    private int predValue;
    private boolean isFirst;
    
    public RemoveSmallerThanPredecessorStrategy()
    {
        predValue = 0;
        isFirst = true;
    }
    
    public boolean select( Integer ref )
    {
        if( isFirst )
        {
            isFirst = false;
            predValue = ref;
            return false;
        }
        else
        {
            boolean result = predValue > (int)ref;
            predValue = (int)ref;
            return result;
        }
    }
    
}